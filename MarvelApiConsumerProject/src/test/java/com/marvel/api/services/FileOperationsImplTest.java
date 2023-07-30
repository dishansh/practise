package com.marvel.api.services;

import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.models.Character;
import com.marvel.api.models.Data;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Thumbnail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FileOperationsImplTest {

    @Autowired
    FileOperations fileOperations;

    @Test
    public void readFromFileReturnsCharacters_whenFileExist() throws IOException, FileReadException {
        List<Character> characters= fileOperations.readFromFile("src\\test\\resources\\Marvel_Characters_Test_Records\\test_marvel_characters.json");
        assertNotNull(characters);
        assertNotEquals(characters.size(), 0);
    }

    @Test
    public void readFromFileReturnsException_whenFileDoesNotExist() {
        assertThrows(FileNotFoundException.class, () -> fileOperations.readFromFile("src\\test1\\resources\\Marvel_Characters_Test_Records\\test_marvel_characters.json"));
    }

    @Test
    public void writeToFileSucceeds_whenValidResponseIsWritten() {
        assertTrue(fileOperations.writeToFile(createMarvelResponseForTestWithOnlyCharactersList(), "src\\test\\resources\\Marvel_Characters_Test_Records\\test_marvel_characters.json"));
    }

    @Test
    public void writeToFileFails_whenInValidResponseIsWritten() {
        assertFalse(fileOperations.writeToFile(null, "src\\test\\resources\\Marvel_Characters_Test_Records\\test_marvel_characters.json"));
    }

    @Test
    public void writeToFileFails_whenInValidFileIsProvided() {
        assertFalse(fileOperations.writeToFile(createMarvelResponseForTestWithOnlyCharactersList(), "src\\test3\\resources\\Marvel_Characters_Test_Records\\test_marvel_characters.json"));
    }

    private MarvelResponse createMarvelResponseForTestWithOnlyCharactersList(){
        List<Character> characterList = Arrays.asList(new Character("1231", "Test1", "Test Description", new Thumbnail("testPath", "testExtension")),
                new Character("1232", "Test2", "Test Description", new Thumbnail("testPath", "testExtension")),
                new Character("1233", "Test3", "Test Description", new Thumbnail("testPath", "testExtension")),
                new Character("1234", "Test4", "Test Description", new Thumbnail("testPath", "testExtension")));
        MarvelResponse marvelResponse = new MarvelResponse();
        marvelResponse.setData(new Data("12", "50", "1493", "4", characterList));
        return marvelResponse;

    }
}