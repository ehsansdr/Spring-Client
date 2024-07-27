package com.example.demo.post;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;


@Component /* todo: do not forget that and test this in test class */
public class PostClient {

    private final RestClient restClient;

    public PostClient(RestClient.Builder builder) {  // todo : be careful about RestClient.Builder
        this.restClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<Post> findAll(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {} /** you can have without Pst class*/
                );
    }





}
