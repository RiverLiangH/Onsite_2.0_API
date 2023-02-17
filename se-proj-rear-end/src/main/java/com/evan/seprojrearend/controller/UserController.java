/**
 * Copyright (C), 2023-02-03
 * FileName: UserController
 * Author:   Lv
 * Date:     2023/2/3 18:09
 * Description: 用户类实现
 */
package com.evan.seprojrearend.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.po.User;
import com.evan.seprojrearend.service.UserService;
import com.evan.seprojrearend.utils.TokenUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags="用户信息模块")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //密钥
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 用户登录验证
     * **/
    @ApiOperation(value="用户登录验证",notes="请输入用户名和密码")
    @ResponseBody
    @PostMapping("login")
    public JsonResult loginValidate(String username, String password){
        String re = null;
        String token = null;
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        //re = userService.isInUser(username, password);
        try {
            re = userService.isInUser(username, password);
            //用户信息存在
            if(re.equals("True")){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                token= TokenUtils.sign(user);    //登录验证
            }
            message.put("token", token);
            message.put("name", username);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }


    /**
     * 用户注册
     * **/
    @ResponseBody
    @PostMapping("sign_up")
    public JsonResult signUp(String username, String mobile, String email, Integer age, String sex, String password, String school, String department, String supervisorname, String supervisorrank, String researchfield, String works, String name){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        String re = null;
        try {
            re = userService.newUser(username, mobile, email, age, sex, password, school, department, supervisorname, supervisorrank, researchfield, works, name);
            message.put("state", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 查询单个用户信息
     * **/
    @ResponseBody
    @GetMapping("check_msg")
    public JsonResult checkMeg(HttpServletRequest request){
        //在请求头里获取token
        String token = request.getHeader("token");
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        JSONObject re = null;
//        re = userService.checkMsg(username);
//        message.put("message", re);
        //创建token验证器
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String username = decodedJWT.getClaim("username").asString();

        try {
            re = userService.checkMsg(username);
            message.put("user", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

}
