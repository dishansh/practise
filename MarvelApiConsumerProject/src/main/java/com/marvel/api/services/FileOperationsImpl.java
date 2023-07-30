package com.marvel.api.services;

import com.google.gson.Gson;
import com.marvel.api.exceptions.FileReadException;
import com.marvel.api.models.Data;
import com.marvel.api.models.MarvelResponse;
import com.marvel.api.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

@Component
public class FileOperationsImpl implements FileOperations{

    private static final Logger logger = Logger.getLogger(FileOperationsImpl.class.getName());

    @Autowired
    Gson gson;

    // Read from the file
    @Override
    public List<Character> readFromFile(String fullFileName) throws IOException, FileReadException {
        logger.info("Start - Reading from File: "+fullFileName);
        try {
            Reader fileReader = new FileReader(fullFileName);
            Data data = gson.fromJson(fileReader, Data.class);
            fileReader.close();
            return (List<Character>) data.getCharacters();
        } catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
            throw new FileReadException("Unable to read file");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            logger.info("End - Reading from File: "+fullFileName);
        }
    }

    // Write final response to a file
    @Override
    public boolean writeToFile(@NonNull MarvelResponse response, @NonNull String fullFileName) {
        logger.info("Start - Writing to File at :"+fullFileName);
        try {
            if(response.getData().getCharacters() != null){
                Writer fileWriter = new FileWriter(fullFileName, false);
                gson.toJson(response.getData(), fileWriter);
                fileWriter.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            logger.info("End - Writing to File at :"+fullFileName);
        }
    }
}
