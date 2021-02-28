package com.marvel.api.services;

import com.marvel.api.models.MarvelResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class MarvelServiceImpl implements MarvelApi{

    @Value("${baseUrl}")
    String baseUrl;

    @Value("${pubKey}")
    String pbKey;

    @Value("${pvtKey}")
    String pvtKey;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FileOperations fileOperations;

    private static final Logger logger = Logger.getLogger(MarvelServiceImpl.class.getName());

    public MarvelResponse callMarvelApi(String url) {
        try {
            logger.log(Level.INFO, "URL being hit : " + url);
            return restTemplate.getForObject(url, MarvelResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Call to Marvel Api failed. Error Message :"+e.getMessage());
            throw e;
        }
    }

    @PostConstruct
    public void aggregateCharactersToAFile() {

        logger.info("Start : Aggregating Marvel Characters Response");

        int offset = 0;
        int limit = 100;
        Map<String, Object> queryParams = createQueryParametersForCharacters(100, offset);
        String url = createUrl("characters", 0, queryParams);
        try {
            if (!url.isEmpty()) {
                MarvelResponse characterResponse = callMarvelApi(url);
                int totalCharacters = Integer.parseInt(characterResponse.getData().getTotal());
                int numOfCallsRequired = (int) (Math.ceil((double) totalCharacters / limit) - 1);
                logger.info("Total Number Of Characters : "+totalCharacters + " hence number of calls needed : "+numOfCallsRequired);
                logger.info("Start : Multiple calls started");
                while (numOfCallsRequired > 0) {
                    offset = numOfCallsRequired * limit;
                    queryParams = createQueryParametersForCharacters(100, offset);
                    url = createUrl("characters", 0, queryParams);
                    MarvelResponse tempCharacterResponse = callMarvelApi(url);
                    if (tempCharacterResponse != null) {
                        characterResponse.getData().getResults().addAll(tempCharacterResponse.getData().getResults());
                    }
                    numOfCallsRequired--;
                }
                logger.info("Final Response Characters: " + characterResponse.getData().getResults().size());
                if (fileOperations.writeToFile(characterResponse)) {
                    logger.info("[SUCCESS] : File Write");
                } else {
                    logger.info(" [FAILED] : Final Response To File");
                }
            }
        } catch (Exception e) {
            logger.warning(" Aggregation failed for Marvel GET/characters with below exception");
            e.printStackTrace();
        }
    }

    public Map<String, Object> createQueryParametersForCharacters(int limit, int offset) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("limit", limit);
        parameters.put("offset", offset);
        return parameters;
    }

    public String createUrl(String path, Integer characterId, Map<String, Object> queryParams) {
        /* order is important here */
        String url = baseUrl;
        if(path!=null && !path.isEmpty()){
            url = url + "/" + path;
        }
        if(characterId != 0){
            url = url + "/" + characterId;
        }
        url = updateUrlWithTimeStampAndKeys(url) ;
        if(queryParams!=null && queryParams.size()> 0){
            url = url + createQueryParameterString(queryParams);
        }
        return url;

    }

    public String updateUrlWithTimeStampAndKeys(String url){
        // Time Stamp
        String timeStamp = String.valueOf(System.currentTimeMillis());

        // value to be hashed (timeStamp+publicKey+privateKey)
        String stringToBeHashed = timeStamp + pvtKey + pbKey;

        // Generating Hash(MD5)
        String hash = DigestUtils.md5Hex(stringToBeHashed);

        return url + "?" +
                "ts=" + timeStamp +
                "&apikey=" + pbKey +
                "&hash=" + hash;
    }

    public String createQueryParameterString(Map<String, Object> queryParams) {
        StringBuilder queryParamString = new StringBuilder();
        if (queryParams.size() > 0) {
            for (Map.Entry<String, Object> parameter : queryParams.entrySet()) {
                queryParamString.append("&")
                        .append(parameter.getKey())
                        .append("=")
                        .append(parameter.getValue());
            }
        }
        return queryParamString.toString();
    }
}
