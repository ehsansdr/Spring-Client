package com.example.demo.album;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

public interface AlbumClient {

    // it is about Http interface
    @GetExchange("/albums")
    List<Album> findAll();

}
