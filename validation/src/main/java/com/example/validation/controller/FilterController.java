package com.example.validation.controller;

import com.example.validation.dto.FilterUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // lombok logging
@RestController
@RequestMapping("/filter")
public class FilterController {

    @PostMapping("")
    public FilterUser user(@RequestBody FilterUser user) {
        log.info("User : {}", user);

        return user;
    }
}
