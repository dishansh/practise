package com.marvel.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@SpringBootApplication
public class MarvelApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarvelApiApplication.class, args);
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder().create();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .codecs(configurator -> configurator.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
                .build();
    }
}