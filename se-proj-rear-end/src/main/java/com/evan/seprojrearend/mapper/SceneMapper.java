package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Scene;

public interface SceneMapper {
    int deleteByPrimaryKey(String scenename);

    int insert(Scene record);

    int insertSelective(Scene record);

    Scene selectByPrimaryKey(String scenename);

    int updateByPrimaryKeySelective(Scene record);

    int updateByPrimaryKey(Scene record);
}