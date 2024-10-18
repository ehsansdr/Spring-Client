package com.example.demo.User;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserClientTest {

    @Autowired
    private UserClient userClient;

    @Test
    void testFindAll() {
        // for testing the webclient we need to expect like this
        StepVerifier.create(userClient.findAll())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void test(){
        String sJava="\\u0048\\u0065\\u006C\\u006C\\u006F";
        System.out.println("StringEscapeUtils.unescapeJava(sJava):\n" + StringEscapeUtils.unescapeJava(sJava));
    }
}