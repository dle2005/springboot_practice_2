package com.example.hello;

import com.example.hello.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        // Object Mapper
        // Text Json <-> Object

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("steve");
        user.setAge(10);
        user.setPhoneNumber("010-1234-5678");

        // object -> text
        String text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        var objectUser = objectMapper.readValue(text, User.class); // default constructor 가 존재해야 함
        System.out.println(objectUser);
    }

}
