package com.marvel.api.services;

import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Character;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FileOperations {

    boolean writeToFile(MarvelResponse response, String fullFileName);
    List<Character> readFromFile(String fullFileName) throws IOException, FileReadException;
}
