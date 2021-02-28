package com.marvel.api.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marvel.api.models.Data;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

@Component
public class FileOperationsImpl implements FileOperations{

    private static final Logger logger = Logger.getLogger(FileOperationsImpl.class.getName());

    @Value("${writeDirectoryPath}")
    String writeDirectoryPath;

    @Override
    public List<Character> readFromFile() throws IOException {
        logger.info("Start - Reading from File ");
        // Read from the file
        Data data = new Data();
        try {
            Gson gson = new GsonBuilder().setLenient().create();
            Reader fileReader = new FileReader(writeDirectoryPath+"\\marvel_characters.json");
            data = gson.fromJson(fileReader, Data.class);
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        logger.info("End - Reading from File ");
        return data.getResults();
    }

    @Override
    public boolean writeToFile(MarvelResponse response) {
        logger.info("Start - Writing to File at :"+writeDirectoryPath);
        // Write final response to a file
        try {
            Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
            Writer fileWriter = new FileWriter(writeDirectoryPath+"\\marvel_characters.json", false);
            gson.toJson(response.getData(), fileWriter);
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            logger.info("End - Writing to File at :"+writeDirectoryPath);
        }
    }
}
