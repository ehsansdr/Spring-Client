package com.example.demo.album;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scripting.bsh.BshScriptFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AlbumClientConfig {
//    https://www.baeldung.com/spring-6-http-interface
    @Bean
    AlbumClient albumClient(){

        // Now that we have defined our sample HTTP service interface,
        // we’ll need to create a proxy that implements the interface and performs the exchanges.

        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");

        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory
                        .builderFor(RestClientAdapter.create(restClient)).build();

//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.forClient(webClient))
//                .build();
//        booksService = httpServiceProxyFactory.createClient(BooksService.class);

        return factory.createClient(AlbumClient.class);
    }

}
