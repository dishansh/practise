package com.marvel.api.controller;

import com.marvel.api.models.MarvelCharacter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharactersController {

    @GetMapping(value = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getCharacterIds(){
        return new ArrayList<>();
    }

    @GetMapping(value = "/characters/{charcaterId}")
    public ResponseEntity<MarvelCharacter> getCharacter(@PathVariable Integer characterId){
        return new ResponseEntity<>(new MarvelCharacter(), HttpStatus.OK);
    }
}
