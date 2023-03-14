package com.evan.seprojrearend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.po.sceneSubmit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface sceneSubmitMapper {
    int insert(sceneSubmit record);

    int insertSelective(sceneSubmit record);

    List<JSONObject> selectByScenename(@Param("scenename") String scenename);
}