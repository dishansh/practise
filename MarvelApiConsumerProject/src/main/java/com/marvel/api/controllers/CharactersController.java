package com.marvel.api.controllers;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.models.Result;
import com.marvel.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharactersController {

    @Autowired
    CharacterService characterService;

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacterIds() {
        try {
            return new ResponseEntity<>(characterService.getCharacterIdList(), HttpStatus.OK);
        } catch (ApiCallingException ape) {
            return new ResponseEntity<>(ape , HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiCallingException(e), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/characters/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacter(@PathVariable("characterId") Integer characterId) {
        try {
            Result res = characterService.getCharacter("characters", characterId);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (ApiCallingException ape) {
            return new ResponseEntity<>(ape, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiCallingException(e), HttpStatus.NOT_FOUND);
        }
    }
}
