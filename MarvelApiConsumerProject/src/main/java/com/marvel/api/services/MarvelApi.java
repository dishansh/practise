package com.marvel.api.services;

import com.marvel.api.models.MarvelResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MarvelApi {
    MarvelResponse callMarvelApi(String url);
    String createUrl(String path, Integer pathVariable, Map<String, Object> queryParameters);
}
