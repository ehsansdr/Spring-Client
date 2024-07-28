package com.example.demo.User;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component /* todo: do not forget that and test this in test class */
public class UserClient {

    //for using webClient you should have Spring reactive web dependency
    private WebClient webClient;

    public UserClient(WebClient.Builder builder) { // todo : be careful about WebClient.Builder
        this.webClient = builder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public Flux<User> findAll(){
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class); // return the content to the flux (i think kind of the list for webClient)
    }


//    public User findOne(){
//        return webClient.get()
//                .uri("/users/1")
//                .retrieve()
//                .bodyToMono(User.class) // return the content to on object
//                .block(); //
//    }

}
