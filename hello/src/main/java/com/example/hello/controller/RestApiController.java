package com.example.hello.controller;

import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/rest/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
//        System.out.println(id);
//        System.out.println(name);
        return id + " " + name;
    }

    @PostMapping("/rest/post")
    public User post(@RequestBody User user) {
//        System.out.println(user);
        return user;
    }

    @Timer
    @DeleteMapping("/rest/delete")
    public void delete() throws InterruptedException {

        Thread.sleep(2000);
    }

    @Decode
    @PutMapping("/rest/put")
    public User put(@RequestBody User user) {
        System.out.println("put");
        System.out.println(user);

        return user;
    }

}
