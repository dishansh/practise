package com.marvel.api.services;

import com.marvel.api.exceptions.ApiCallingException;
import com.marvel.api.exceptions.CharacterNotFoundException;
import com.marvel.api.models.MarvelResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public interface MarvelApi {
    Mono<MarvelResponse> callMarvelApi(String url) throws ApiCallingException, CharacterNotFoundException;
    String createUrl(String path, Integer pathVariable, Map<String, Integer> queryParameters);
}
