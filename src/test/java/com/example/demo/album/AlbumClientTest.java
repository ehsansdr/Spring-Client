package com.example.demo.album;

import com.example.demo.User.UserClient;
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

}