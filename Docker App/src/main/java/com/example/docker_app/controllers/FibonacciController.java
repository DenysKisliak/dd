package com.example.docker_app.controllers;

import com.example.docker_app.dao.dto.FibonacciBaseDto;
import com.example.docker_app.dao.entity.Fibonacci;
import com.example.docker_app.service.FibonacciService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.List;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private final FibonacciService fibonacciService;

    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping
    public List<FibonacciBaseDto> getBaseFibonacciPage(){
        WebClient client = WebClient.create();
        RequestHeadersUriSpec<?> uriSpec = client.get();
        RequestHeadersSpec<?> uri = uriSpec.uri("http://172.20.0.2:8081/second");

        uri.header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .ifNoneMatch("*")
                .ifModifiedSince(ZonedDateTime.now())
                .retrieve();
        Mono<FibonacciBaseDto> response = uri.retrieve()
                .bodyToMono(FibonacciBaseDto.class);

        return List.of(response.block());
    }

    @GetMapping("/calc")
    public Fibonacci getFibonacciValue(@RequestParam(name = "index")Long index){
        return fibonacciService.getFibonacciValueByIndex(index);
    }
}
