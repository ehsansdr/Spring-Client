package com.example.demo.album;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlbumClientTest {

    @Autowired
    private AlbumClient client;

    @Test
    void testFindAll() {
        List<Album> albums = client.findAll(); // from interface without the body just annotation
        assertEquals(100,albums.size());
    }
    //***********************************
    @Test
    void testFindAlbumById() {
        Album album = client.getAlbumById(5); // from interface without the body just annotation

        Album album2 = new Album(1,5,"eaque aut omnis a");
//        {
//            "userId": 1,
//                "id": 5,
//                "title": "eaque aut omnis a"
//        }

        System.out.println(album);
        assertEquals(album2,album);
    }

    @Test
    void testFindAll2() {
        List<Album> albums = client.findAll(); // from interface without the body just annotation
        assertEquals(100,albums.size());
    }


}