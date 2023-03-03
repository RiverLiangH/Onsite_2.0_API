package com.evan.seprojrearend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.po.Competition;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompetitionMapper {

    //根据比赛名称获取比赛信息
    JSONObject selectByName(@Param("competitionname") String competitionname);

    List<JSONObject> selectAll();
}
