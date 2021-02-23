package com.marvel.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.InValidResponseFromMarvel;
import com.marvel.api.models.Data;
import com.marvel.api.models.Example;
import com.marvel.api.models.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    @Value("${baseUrl}")
    String baseUrl;

    @Value("${pubKey}")
    String pbKey;

    @Value("${pvtKey}")
    String pvtKey;

    @Autowired
    RestTemplate restTemplate;

    public Example callMarvelApi(String url) {
        try {
            System.out.println("URL being hit >>>>>>>>>> " + url);
            return restTemplate.getForObject(url, Example.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PostConstruct
    public void aggregateCharactersToAFile() {

        int offset = 0;
        int limit = 100;
        Map<String, Object> queryParams = createQueryParametersForCharacters(100, offset);
        String url = createUrlForCharacters("characters", queryParams);

        try {
            if (!url.isEmpty()) {
                Example characterResponse = callMarvelApi(url);
                int totalCharacters = Integer.parseInt(characterResponse.getData().getTotal());
                int numOfCallsRequired = (int) (Math.ceil((double) totalCharacters / limit) - 1);
                while (numOfCallsRequired > 0) {
                    offset = numOfCallsRequired * limit;
                    queryParams = createQueryParametersForCharacters(100, offset);
                    url = createUrlForCharacters("characters", queryParams);
                    Example tempCharacterResponse = callMarvelApi(url);
                    if (tempCharacterResponse != null) {
                        characterResponse.getData().getResults().addAll(tempCharacterResponse.getData().getResults());
                    }
                    numOfCallsRequired--;
                }
                System.out.println(" Final Response Characters: " + characterResponse.getData().getResults().size());
                if (writeToFile(characterResponse)) {
                    System.out.println(" [SUCCESS] : Final Response To File");
                } else {
                    System.out.println(" [FAILED] : Final Response To File");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To fetch character Id List
    public List<Integer> getCharacterIdList() throws ApiCallingException {
        try {
            List<Result> characterResponse = readFromFile();
            if (characterResponse.size()>0) {
                    return characterResponse.stream().map(res -> Integer.valueOf(res.getId())).collect(Collectors.toList());
                } else {
                    throw new InValidResponseFromMarvel("No Data Found in Marvel Response File. Please try again later");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiCallingException(e);
        }
    }

    // To fetch character details
    public Result getCharacter(String path, int characterId) throws ApiCallingException {
        String url = createUrlForCharacterApi(path, characterId);
        try {
            Example characterResponse = callMarvelApi(url);
            if (characterResponse.getData() != null) {
                List<Result> charactersList = characterResponse.getData().getResults();
                if (charactersList != null && charactersList.size() > 0) {
                    return charactersList.get(0);
                } else {
                    throw new InValidResponseFromMarvel("Didn't recieve characters from Marvel. Please try again later");
                }
            } else {
                throw new InValidResponseFromMarvel("Didn't recieve valid response from Marvel. Please try again later");
            }
        } catch (Exception e) {
            throw new ApiCallingException(e);
        }
    }

    public Map<String, Object> createQueryParametersForCharacters(int limit, int offset) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("limit", limit);
        parameters.put("offset", offset);
        return parameters;
    }

    public String createUrlForCharacters(String path, Map<String, Object> queryParams) {
        // Time Stamp
        String timeStamp = String.valueOf(System.currentTimeMillis());

        // value to be hashed (timeStamp+publicKey+privateKey)
        String stringToBeHashed = timeStamp + pvtKey + pbKey;

        // Generating Hash(MD5)
        String hash = DigestUtils.md5Hex(stringToBeHashed);

        /* constructing url to call */
        return baseUrl +
                "/" +
                path +
                "?" +
                "ts=" + timeStamp +
                "&apikey=" + pbKey +
                "&hash=" + hash +
                createQueryParameterString(queryParams);

    }

    public String createUrlForCharacterApi(String path, Integer characterId) {
        // Time Stamp
        String timeStamp = String.valueOf(System.currentTimeMillis());

        // value to be hashed (timeStamp+publicKey+privateKey)
        String stringToBeHashed = timeStamp + pvtKey + pbKey;

        // Generating Hash(MD5)
        String hash = DigestUtils.md5Hex(stringToBeHashed);

        /* constructing url to call */
        return baseUrl +
                "/" +
                path + "/" + characterId +
                "?" +
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

    public boolean writeToFile(Example response) {
        // Write final response to a file
        try {
            Gson gson = new GsonBuilder().setLenient().create();
            Writer fileWriter = new FileWriter("marvel_characters.json", false);
            gson.toJson(response.getData(), fileWriter);
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Result> readFromFile() {
        // Read from the file
        Data data = new Data();
        try {
            Gson gson = new GsonBuilder().setLenient().create();
            Reader fileReader = new FileReader("marvel_characters.json");
            data = gson.fromJson(fileReader, Data.class);
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.getResults();
    }
}
