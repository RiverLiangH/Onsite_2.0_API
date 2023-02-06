/**
 * Copyright (C), 2023-02-03
 * FileName: UserController
 * Author:   Lv
 * Date:     2023/2/3 18:09
 * Description: 用户类实现
 */
package com.evan.seprojrearend.controller;

import com.evan.seprojrearend.po.User;
import com.evan.seprojrearend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("list")
//    public List<User> selectAll(){
//        return userService.selectAll();
//    }

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

    //增加新用户
    @PostMapping("/addUser")
    public Integer addUser(@RequestBody User user){
//        return userService.addUser(user);
        return 1;
    }
}
