package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.CharacterNotFoundException;
import com.marvel.api.models.Character;
import com.marvel.api.models.MarvelResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;

@Component
public class MarvelServiceImpl implements MarvelApi {

    @Value("${baseUrl}")
    String baseUrl;

    @Value("${pubKey}")
    String pbKey;

    @Value("${pvtKey}")
    String pvtKey;

    @Value("${directoryPath}")
    String directoryPath;

    @Value("${fileName}")
    String fileName;

    @Autowired
    FileOperations fileOperations;

    @Autowired
    WebClient webClient;

    private static final Logger logger = Logger.getLogger(MarvelServiceImpl.class.getName());

    @Override
    public Mono<MarvelResponse> callMarvelApi(String url) {

            logger.log(Level.INFO, "URL being hit : " + url);
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .onStatus(httpStatus -> httpStatus == HttpStatus.NOT_FOUND, clientResponse -> Mono.error(new CharacterNotFoundException("Requested Character ID doesn't exist. Please try with other one")))
                    .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ApiCallingException("Unknown error from Marvel")))
                    .bodyToMono(MarvelResponse.class);
    }

    @PostConstruct
    public void aggregateCharactersToAFile() {
        logger.info("Start : Aggregating Marvel Characters Response");

        int offset = 0;
        int limit = 100;
        Map<String, Integer> queryParams = createQueryParametersForCharacters(100, offset);
        String url = createUrl("characters", queryParams);
        List<String> urlsToCall = new LinkedList<>();
        try {
            if (!url.isEmpty()) {
                MarvelResponse characterResponse = callMarvelApi(url).block();
                assert characterResponse != null;
                int totalCharacters = Integer.parseInt(characterResponse.getData().getTotal());
                int numOfCallsRequired = (int) (Math.ceil((double) totalCharacters / limit) - 1);
                logger.info("Total Number Of Characters : " + totalCharacters + " hence number of calls needed : " + numOfCallsRequired);

                for (int i = 1; i <= numOfCallsRequired; i++){
                    queryParams = createQueryParametersForCharacters(100, (i*limit));
                    url = createUrl("characters", queryParams);
                    urlsToCall.add(url);
                }

                MarvelResponse responseFromSubCalls = Flux.fromIterable(urlsToCall)
                        .flatMapSequential(this::callMarvelApi)
                        .reduce((marvelResponse, marvelResponse2) -> {
                            marvelResponse.getData().getCharacters().addAll(marvelResponse2.getData().getCharacters());
                            return marvelResponse;
                        }).block();

                assert responseFromSubCalls != null;
                logger.info(" Characters fetched: " +responseFromSubCalls.getData().getCharacters().size());

                characterResponse.getData().getCharacters().addAll(responseFromSubCalls.getData().getCharacters());
                logger.info("Final Response Characters: " + characterResponse.getData().getCharacters().size());
                if (fileOperations.writeToFile(characterResponse, directoryPath+"\\"+fileName)) {
                    logger.info("[SUCCESS] : Characters from Marvel is written to the file");
                } else {
                    logger.info("[FAILED] : Characters from Marvel is NOT written to the file");
                }
            }
        } catch (Exception e) {
            logger.warning(" Aggregation failed for Marvel GET/characters with below exception");
            e.printStackTrace();
        }
    }

    public Map<String, Integer> createQueryParametersForCharacters(int limit, int offset) {
        Map<String, Integer> parameters = new LinkedHashMap<>();
        parameters.put("limit", limit);
        parameters.put("offset", offset);
        return parameters;
    }

    @Override
    public String createUrl(String path, Integer characterId, Map<String, Integer> queryParams) {
        /* order is important here */
        StringBuilder url = new StringBuilder(baseUrl);
        if (path != null && !path.isEmpty()) {
            url.append("/").append(path);
        }
        if (characterId != 0) {
            url.append("/").append(characterId);
        }
        url = updateUrlWithTimeStampAndKeys(url);
        if (queryParams != null && queryParams.size() > 0) {
            url.append(createQueryParameterString(queryParams));
        }
        return url.toString();
    }

    public String createUrl(String path, Map<String, Integer> queryParams) {
        /* order is important here */
        StringBuilder url = new StringBuilder(baseUrl);
        if (path != null && !path.isEmpty()) {
            url.append("/").append(path);
        }

        url = updateUrlWithTimeStampAndKeys(url);
        if (queryParams != null && queryParams.size() > 0) {
            url.append(createQueryParameterString(queryParams));
        }
        return url.toString();
    }

    public StringBuilder updateUrlWithTimeStampAndKeys(StringBuilder url) {
        // Time Stamp
        String timeStamp = String.valueOf(System.currentTimeMillis());

        // value to be hashed (timeStamp+publicKey+privateKey)
        String stringToBeHashed = timeStamp + pvtKey + pbKey;

        // Generating Hash(MD5)
        String hash = DigestUtils.md5Hex(stringToBeHashed);

        return url.append("?").append("ts=").append(timeStamp).append("&apikey=").append(pbKey).append("&hash=").append(hash);
    }

    protected String createQueryParameterString(Map<String, Integer> queryParams) {
        StringBuilder queryParamString = new StringBuilder();
        if (queryParams.size() > 0) {
            for (Map.Entry<String, Integer> parameter : queryParams.entrySet()) {
                queryParamString.append("&")
                        .append(parameter.getKey())
                        .append("=")
                        .append(parameter.getValue());
            }
        }
        return queryParamString.toString();
    }
}
