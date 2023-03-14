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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public JsonResult enter(String paperType, String competitionName, String dockerId, HttpServletRequest request){
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

            /**获取switchtime**/
//            String switchtime_str = competition.getString("switchtime");
//            System.out.println("时间："+switchtime_str);
//
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
//            System.out.println("执行到Date转换前");
////            DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
//            Date switchtime = sdf.parse(switchtime_str);
//            System.out.println(switchtime.getTime());

            String switchtime_str = competition.getString("switchtime");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date switchtime = format.parse(switchtime_str);
            System.out.println(switchtime);


            System.out.println("执行enter操作");
            System.out.println(switchtime);

            System.out.println("userid:"+userid);
            System.out.println("competitionid:"+competitionid);

            JSONObject submit = submitService.newSubmit(switchtime,userid,competitionid,dockerId);
            message.put("submit",submit);
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
    public JsonResult findByPaging(String competitionName, Integer pageNum, Integer pageSize){
        JSONObject re = null;
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        try {
            JSONObject competition = competitionService.getCompetitionInfo(competitionName);   // 获取比赛信息
            String competitionid = competition.getString("competitionId");
            re = submitService.findByPaging(competitionid, pageNum, pageSize);
            message.put("submit", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 获取单个用户的全部提交信息
     * **/
    @ResponseBody
    @GetMapping("personal_submits")
    public JsonResult getPersonalSubmits(String competitionName, HttpServletRequest request){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        List<JSONObject> re = null;
        //在请求头里获取token
        String token = request.getHeader("token");
        //创建token验证器
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        String username = decodedJWT.getClaim("username").asString();
        JSONObject user = userService.checkMsg(username);  // 获取用户信息
        String userid = user.getString("userId");
        JSONObject competition = competitionService.getCompetitionInfo(competitionName);   // 获取比赛信息
        String competitionid = competition.getString("competitionId");

        try {
            re = submitService.selectBySubmitterId(userid,competitionid);
            message.put("submits", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

}
