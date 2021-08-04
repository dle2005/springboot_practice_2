package com.example.validation.controller;

import com.example.validation.dto.ExceptionUser;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("")
    public ExceptionUser get(@RequestBody(required = false) String name, @RequestParam(required = false) Integer age) {
        ExceptionUser user = new ExceptionUser();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;

        return user;
    }

    @PostMapping("")
    public ExceptionUser post(@Valid @RequestBody ExceptionUser user) {
        System.out.println(user);

        return user;
    }
}
