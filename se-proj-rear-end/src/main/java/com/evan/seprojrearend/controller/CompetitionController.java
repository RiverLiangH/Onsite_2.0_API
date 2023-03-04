/**
 * Copyright (C), 2023-02-28
 * FileName: CompetitionController
 * Author:   Lv
 * Date:     2023/2/28 8:17
 * Description: 比赛类实现
 */
package com.evan.seprojrearend.controller;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.service.CompetitionService;
import com.google.gson.JsonObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags="比赛信息模块")
@RestController
@CrossOrigin
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    /**
     * 根据比赛名称获取比赛信息
     * **/
    @ResponseBody
    @GetMapping("competition_info")
    public JsonResult getCompetitionInfo(String competitionName){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        JSONObject re = null;
        try {
            re = competitionService.getCompetitionInfo(competitionName);
            message.put("competition", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 获取全部比赛信息
     * **/
    @ResponseBody
    @GetMapping("all_competitions")
    public JsonResult getCompetitions(){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        List<JSONObject> re = null;
        try {
            System.out.println("controller没问题");
            re = competitionService.getCompetitions();
            message.put("competition", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

}
