package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.FileEmptyException;
import com.marvel.api.models.Character;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterService {
    List<Integer> getCharacterIdList() throws ApiCallingException, FileEmptyException;
    Character getCharacter(String path, int characterId) throws ApiCallingException;
}
