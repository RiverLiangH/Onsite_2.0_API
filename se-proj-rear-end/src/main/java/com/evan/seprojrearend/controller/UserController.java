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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="用户信息模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

}
