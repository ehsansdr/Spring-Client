package com.example.demo.ToDo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)  // use random port
class TodoClientTest {

    @Autowired
    private ToDoClient todoClient;

    @Test
    void testFindAll() {
        List<ToDo> todos = todoClient.findAll();
        assertEquals(200,todos.size());
    }


}