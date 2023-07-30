package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.CharacterNotFoundException;
import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.exceptions.InValidResponseFromMarvel;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.util.List;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CharacterServiceImpl implements CharacterService{

    private static final Logger logger = Logger.getLogger(CharacterServiceImpl.class.getName());

    @Autowired
    MarvelApi marvelApi;

    @Autowired
    FileOperations fileOperations;

    @Value("${directoryPath}")
    String directoryPath;

    @Value("${fileName}")
    String fileName;

    // To fetch character Id List
    @Override
    public List<Integer> getCharacterIds() throws FileReadException, IOException {
        logger.info("Start : Reading from the marvel characters file");
        try {
            logger.info("Path for the file is : "+directoryPath+"\\"+fileName);
            List<Character> characters = fileOperations.readFromFile(directoryPath+"\\"+fileName);
            if (characters.size()>0) {
                    logger.info("File found and Response de-serialised");
                    return characters.stream().map(res -> Integer.valueOf(res.getId())).collect(Collectors.toList());
                } else {
                    logger.warning("Character Details not found in Marvel Response File. Please try again later");
                    throw new FileReadException("Character Details not found in Marvel Response File. Please try again later");
            }
        } catch (FileReadException fileReadException){
            throw fileReadException;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            logger.info("End : Reading from the marvel characters file");
        }
    }

    // To fetch character details
    @Override
    public Character getCharacter(String path, int characterId) throws ApiCallingException, CharacterNotFoundException {
        logger.info("Start : Fetching Marvel Character with id: " + characterId);
        try {
            String url = marvelApi.createUrl(path, characterId, null);
            MarvelResponse characterResponse = marvelApi.callMarvelApi(url).block();
            if (Objects.requireNonNull(characterResponse).getData() != null) {
                List<Character> charactersList = (List<Character>) characterResponse.getData().getCharacters();
                if (charactersList != null && charactersList.size() > 0) {
                    logger.info("Character found: " + charactersList.get(0));
                    return charactersList.get(0);
                } else {
                    logger.info("Received response from Marvel without the requested character. Please try again later");
                    throw new InValidResponseFromMarvel("Received response from Marvel without the requested character. Please try again later");
                }
            } else {
                logger.info("Didn't receive characters from Marvel. Please try again later");
                throw new InValidResponseFromMarvel("Didn't receive valid response from Marvel. Please try again later");
            }
        } catch (ApiCallingException aPe) {
            throw aPe;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            logger.info("End : Fetching Marvel Character with id: " + characterId);
        }
    }
}
