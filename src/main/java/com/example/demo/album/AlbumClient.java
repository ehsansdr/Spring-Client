package com.example.demo.album;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface AlbumClient {

//    @GetExchange for HTTP GET requests
//    @PostExchange for HTTP POST requests
//    @PutExchange for HTTP PUT requests
//    @PatchExchange for HTTP PATCH requests
//    @DeleteExchange for HTTP DELETE requests


    // todo :  Now that we have defined our sample HTTP service interface,

    // it is about Http interface
    /** be careful about the format of naming because it makes the method function*/
    @GetExchange("/albums")
    List<Album> findAll();

    //***************************************

    @GetExchange("/albums/{id}")
    Album getAlbumById(@PathVariable long id);

    @PostExchange("/albums")
    Album saveAlbum(@RequestBody Album album);

    @DeleteExchange("/albums/{id}")
    ResponseEntity<Void> deleteAlbum(@PathVariable long id);


}
