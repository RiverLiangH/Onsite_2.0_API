/**
 * Copyright (C), 2023-02-28
 * FileName: CompetitionService
 * Author:   Lv
 * Date:     2023/2/28 8:13
 * Description: 比赛服务类——实现mapper接口
 */
package com.evan.seprojrearend.service;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.mapper.CompetitionMapper;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionMapper competitionMapper;

    /**
     * 根据比赛名称获取比赛信息
     * **/
    public JSONObject getCompetitionInfo(String competitionname){
        return competitionMapper.selectByName(competitionname);
    }
}
