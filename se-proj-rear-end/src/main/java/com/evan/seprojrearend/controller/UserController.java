/**
 * Copyright (C), 2023-02-03
 * FileName: UserController
 * Author:   Lv
 * Date:     2023/2/3 18:09
 * Description: 用户类实现
 */
package com.evan.seprojrearend.controller;

import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.po.User;
import com.evan.seprojrearend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Api(tags="用户信息模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录验证
     * **/
    @ApiOperation(value="用户登录验证",notes="请输入用户名和密码")
    @PostMapping("user/login")
    public JsonResult loginValidate(String username, String password){
        String re = null;
        re = userService.isInUser(username, password);
//        try {
//            re = userService.isInUser(username, password);
//        }catch (Exception e){
//            return JsonResult.isError(10001,"未知错误");
//        }
        return JsonResult.isOk(re);
    }

    /**
     * 用户注册
     * **/
    @PostMapping("user/sign_up/{username}/{mobile}/{email}/{age}/{sex}/{password}/{school}/{department}/{supervisorname}/{supervisorrank}/{researchfield}/{works}")
    public JsonResult signUp(@PathVariable String username,@PathVariable String mobile,@PathVariable String email,@PathVariable Integer age,@PathVariable String sex,@PathVariable String password,@PathVariable String school,@PathVariable String department,@PathVariable String supervisorname,@PathVariable String supervisorrank,@PathVariable String researchfield,@PathVariable String works){
        String re = null;
        re = userService.newUser(username, mobile, email, age, sex, password, school, department, supervisorname, supervisorrank, researchfield, works);
//        try {
//            re = userService.newUser(username, mobile, email, age, sex, password, school, department, supervisorname, supervisorrank, researchfield, works);
//        }catch (Exception e){
//            return JsonResult.isError(10001,"未知错误");
//        }
        return JsonResult.isOk(re);
    }

}
