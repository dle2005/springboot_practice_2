package com.example.validation.controller.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello() {
        return "public hello";
    }
}
