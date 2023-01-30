package com.evan.seprojrearend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloController {
    @RequestMapping("/test")
    public String hello(){
        return "hello world!";
    }
}
