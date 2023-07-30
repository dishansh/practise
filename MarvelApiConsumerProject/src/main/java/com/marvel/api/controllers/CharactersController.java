package com.marvel.api.controllers;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.CharacterNotFoundException;
import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.exceptions.InValidResponseFromMarvel;
import com.marvel.api.models.Character;
import com.marvel.api.services.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersController {

    private final CharacterService characterService;

    public CharactersController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacterIds() {
        try {
            return new ResponseEntity<>(characterService.getCharacterIds(), HttpStatus.OK);
        } catch (FileReadException fileReadException) {
            return new ResponseEntity<>("Unable to fulfill this request now. Please try again in sometime", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Sorry! This request cannot be served at the moment.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/characters/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacter(@PathVariable("characterId") String characterId) {
        try {
            Character res = characterService.getCharacter("characters", Integer.parseInt(characterId));
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (NumberFormatException nFe) {
            return new ResponseEntity<>("Character Id provided is not acceptable (Only numbers accepted)", HttpStatus.BAD_REQUEST);
        } catch (InValidResponseFromMarvel invalidResponse) {
            return new ResponseEntity<>(invalidResponse.getMessage(), HttpStatus.NO_CONTENT);
        } catch (ApiCallingException ape) {
            return new ResponseEntity<>(ape.getMessage(), HttpStatus.BAD_GATEWAY);
        } catch (CharacterNotFoundException characterNotFoundException) {
            return new ResponseEntity<>(characterNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Sorry! This request cannot be served at the moment. Please contact TechDesk.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
