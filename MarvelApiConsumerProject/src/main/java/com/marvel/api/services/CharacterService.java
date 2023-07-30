package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.CharacterNotFoundException;
import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.models.Character;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface CharacterService {
    List<Integer> getCharacterIds() throws ApiCallingException, FileReadException, IOException;
    Character getCharacter(String path, int characterId) throws ApiCallingException, CharacterNotFoundException;
}
