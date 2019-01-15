package com.example.demo.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @RequestMapping("/hello")
    public Object testHello() {
        return "hello springboot";
    }
}