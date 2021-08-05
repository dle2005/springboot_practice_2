package com.example.validation.controller;

import com.example.validation.dto.ExceptionUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/exception")
@Validated
public class ExceptionController {

    @GetMapping("")
    public ExceptionUser get(
            @Size(min = 2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age) {
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
