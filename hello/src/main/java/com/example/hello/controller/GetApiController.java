package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String getHello() {
        return "get hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    // 주소에 대문자 사용x -> '-'사용
    // {}안의 이름과 @PathVariable 변수명이 동일해야함
    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        return pathName;
    }

    // Query Parameter

    // search?q=intellij
    // &oq=intellij
    // &aqs=chrome..69i57j69i59l3j0l3j69i61.4285j0j7
    // &sourceid=chrome
    // &ie=UTF-8

    // 처음으로 path variable 을 붙여주기 위해 ? 사용하고 key = value 형식

    // http://localhost:9090/api/get/query-param?user=steve&email=steave@gmail.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println();

            sb.append(key).append(" = ").append(value).append("\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return name + " " + email + " " + age;
    }

    // Dto 를 입력으로 받는경우 @RequestParam 과 같은 어노테이션이 필요 없음

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {

        return userRequest.toString();
    }
}
