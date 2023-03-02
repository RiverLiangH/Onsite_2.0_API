/**
 * Copyright (C), 2023-03-02
 * FileName: SubmitController
 * Author:   Lv
 * Date:     2023/3/2 11:01
 * Description: Submit控制类
 */
package com.evan.seprojrearend.controller;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.service.CompetitionService;
import com.evan.seprojrearend.service.SubmitService;
import com.evan.seprojrearend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags="比赛提交模块")
@RestController
@CrossOrigin
@RequestMapping("/submit")
public class SubmitController {

    @Autowired
    private SubmitService submitService;
    private UserService userService;
    private CompetitionService competitionService;

    //密钥
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 用户进行比赛登记
     * **/
    @ApiOperation(value="用户进行比赛登记")
    @ResponseBody
    @PostMapping("enter")
    public JsonResult enter(String competitionName, HttpServletRequest request){
        //在请求头里获取token
        String token = request.getHeader("token");
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        JSONObject re = null;
        //创建token验证器
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String username = decodedJWT.getClaim("username").asString();
        System.out.println(username);
        try {
            re = userService.checkMsg(username);
            System.out.println(re);

        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }
}
