package com.example.demo.ToDo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component /* todo: do not forget that and test this in test class */
public class ToDoClient {
    private RestTemplate restTemplate;

    public ToDoClient(RestTemplateBuilder builder) {  // todo : be careful about RestTemplateBuilder
        this.restTemplate = builder.build();    // for instantiating RestTemplate
    }

    public List<ToDo> findAll(){
        // when we execute this we follow the url that we get
        return restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/todos",   // the URI with and the added URI
                HttpMethod.GET,  // the http method
                null,            // not passing the entity
                new ParameterizedTypeReference<List<ToDo>>(){
                }
        ).getBody();

    }
}