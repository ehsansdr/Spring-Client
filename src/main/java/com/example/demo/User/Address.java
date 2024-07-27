package com.example.demo.User;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}
