package com.marvel.api.controllers;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.FileEmptyException;
import com.marvel.api.exceptions.InValidResponseFromMarvel;
import com.marvel.api.models.Character;
import com.marvel.api.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersController {

    @Autowired
    CharacterService characterService;

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacterIds() {
        try {
            return new ResponseEntity<>(characterService.getCharacterIdList(), HttpStatus.OK);
        } catch (FileEmptyException fileEmptyException) {
            return new ResponseEntity<>(fileEmptyException , HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ApiCallingException ape) {
            return new ResponseEntity<>(ape , HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiCallingException(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/characters/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCharacter(@PathVariable("characterId") Integer characterId) {
        try {
            Character res = characterService.getCharacter("characters", characterId);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (InValidResponseFromMarvel invalidResponse) {
            return new ResponseEntity<>(invalidResponse,  HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (ApiCallingException ape) {
            return new ResponseEntity<>(ape,  HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiCallingException(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
