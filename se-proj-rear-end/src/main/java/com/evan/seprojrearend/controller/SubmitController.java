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
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags="比赛提交模块")
@RestController
@CrossOrigin
@RequestMapping("/submit")
public class SubmitController {

    @Autowired
    private SubmitService submitService;
    @Autowired
    private UserService userService;
    @Autowired
    private CompetitionService competitionService;

    //密钥
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 用户提交比赛作品
     * **/
    @ApiOperation(value="用户提交比赛作品")
    @ResponseBody
    @PostMapping("enter")
    public JsonResult enter(String competitionName, String dockerId, HttpServletRequest request){
        //在请求头里获取token
        String token = request.getHeader("token");
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        JSONObject user = null;
        JSONObject competition = null;
        //创建token验证器
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String username = decodedJWT.getClaim("username").asString();
        System.out.println(username);

        try {
            user = userService.checkMsg(username);  // 获取用户信息
            competition = competitionService.getCompetitionInfo(competitionName);   // 获取比赛信息
            String userid = user.getString("userId");
            String competitionid = competition.getString("competitionId");
            System.out.println("userid:"+userid);
            System.out.println("competitionid:"+competitionid);

            String result = submitService.newSubmit(userid,competitionid,dockerId);
//            if(result.equals("False"))
//                return JsonResult.isError(10001,"未参赛不允许进行提交");

        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 获取全部提交信息（按成绩排序）
     * **/
    @ResponseBody
    @ApiOperation(value = "分页查询用户作品提交信息")
    @GetMapping("find_by_paging")
    public JsonResult findByPaging(Integer pageNum, Integer pageSize){
        JSONObject re = null;
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        try {
            re = submitService.findByPaging(pageNum, pageSize);
            message.put("submit", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

}
