package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiImplicitParams({
                    @ApiImplicitParam(name = "x", value = "x값", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "y", value = "y값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(
//            @ApiParam(value = "x값")
            @PathVariable int x,
//            @ApiParam(value = "y값")
            @RequestParam int y) {
        return x + y;
    }

    @ApiOperation(value = "사용자의 나이와 이름을 에코하는 method")
    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때")
    @GetMapping("/user")
    public UserRes userGet(UserReq req) {
        return new UserRes(req.getName(), req.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req) {
        return new UserRes(req.getName(), req.getAge());
    }
}
