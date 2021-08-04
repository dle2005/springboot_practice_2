package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 Class 는 REST API 처리하는 Controller
@RequestMapping("/api") // RequestMapping URI 를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") // http://localhost:9090/api/hello
    public String hello() {
        return "hello spring boot!";
    }

    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // req -> object mapper -> object -> method -> object -> object mapper -> json -> res
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; // 200 ok
    }

    @PutMapping("/put02")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
