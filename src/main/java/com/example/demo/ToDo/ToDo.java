package com.example.demo.ToDo;

public record ToDo (
        Integer userId,
        Integer id,
        String title,
        Boolean completed
){
}
