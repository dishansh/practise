package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.FileEmptyException;
import com.marvel.api.exceptions.InValidResponseFromMarvel;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CharacterServiceImpl implements CharacterService{

    private static final Logger logger = Logger.getLogger(CharacterServiceImpl.class.getName());

    //@Autowired
    MarvelApi marvelApi;

    // Constructor Injection
    @Autowired
    public CharacterServiceImpl(MarvelApi marvelApi){
        this.marvelApi = marvelApi;
    }

    @Autowired
    FileOperations fileOperations;

    // To fetch character Id List
    @Override
    public List<Integer> getCharacterIdList() throws ApiCallingException, FileEmptyException {
        logger.info("Start : Reading from the marvel character file");
        try {
            List<Character> characterResponse = fileOperations.readFromFile();
            if (characterResponse.size()>0) {
                    logger.info("File found. Response de-serialised");
                    return characterResponse.stream().map(res -> Integer.valueOf(res.getId())).collect(Collectors.toList());
                } else {
                    logger.warning("No Data Found in Marvel Response File. Please try again later ");
                    throw new FileEmptyException("No Data Found in Marvel Response File. Please try again later");
            }
        } catch (FileEmptyException fEEx) {
            fEEx.printStackTrace();
            throw fEEx;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiCallingException(e);
        } finally {
            logger.info("End : Reading from the marvel character file");
        }
    }

    // To fetch character details
    @Override
    public Character getCharacter(String path, int characterId) throws ApiCallingException {
        logger.info("Start : Fetching Marvel Character with id: "+characterId);
        String url = marvelApi.createUrl(path, characterId, null);
        try {
            MarvelResponse characterResponse = marvelApi.callMarvelApi(url);
            if (characterResponse.getData() != null) {
                List<Character> charactersList = characterResponse.getData().getResults();
                if (charactersList != null && charactersList.size() > 0) {
                    logger.info("Character found: "+ charactersList);
                    return charactersList.get(0);
                } else {
                    logger.info("Receive empty response from Marvel. Please try again later");
                    throw new InValidResponseFromMarvel("Receive empty response from Marvel. Please try again later");
                }
            } else {
                logger.info("Didn't receive characters from Marvel. Please try again later");
                throw new InValidResponseFromMarvel("Didn't receive valid response from Marvel. Please try again later");
            }
        }catch (InValidResponseFromMarvel invalidResponseException) {
            invalidResponseException.printStackTrace();
            throw invalidResponseException;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ApiCallingException(e);
        } finally {
            logger.info("End : Fetching Marvel Character with id: "+characterId);
        }
    }
}
