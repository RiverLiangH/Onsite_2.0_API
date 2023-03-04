/**
 * Copyright (C), 2023-03-03
 * FileName: EntryController
 * Author:   Lv
 * Date:     2023/3/3 8:47
 * Description: entry controller
 */
package com.evan.seprojrearend.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.service.CompetitionService;
import com.evan.seprojrearend.service.EntryService;
import com.evan.seprojrearend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags="用户参赛模块")
@RestController
@CrossOrigin
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CompetitionService competitionService;

    //密钥
    private static final String TOKEN_SECRET="ljdyaishijin**3nkjnj??";

    /**
     * 用户进行比赛登记
     * **/
    @ApiOperation(value="用户进行比赛登记")
    @ResponseBody
    @PostMapping("register")
    public JsonResult enterContest(String competitionName, HttpServletRequest request){
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
            entryService.newEntry(userid,competitionid);

        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 获取全部比赛参赛人数
     * **/
    @ApiOperation(value="获取全部比赛参赛人数")
    @ResponseBody
    @GetMapping("competitions_take_count")
    public JsonResult getCompetitionsCount(){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        String re = null;
//        re = String.valueOf(entryService.getCompetitionsCount());
//        message.put("competitionCount", re);
        try {
            //System.out.println("controller没问题");
            re = String.valueOf(entryService.getCompetitionsCount());
            message.put("competitionCount", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }
}
