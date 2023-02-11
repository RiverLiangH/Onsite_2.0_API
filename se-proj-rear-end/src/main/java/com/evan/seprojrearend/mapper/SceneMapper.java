package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Scene;

import java.util.List;

public interface SceneMapper {
    int deleteByPrimaryKey(String scenename);

    int insert(Scene record);

    int insertSelective(Scene record);

    Scene selectByPrimaryKey(String scenename);

    int updateByPrimaryKeySelective(Scene record);

    int updateByPrimaryKey(Scene record);

    List<Scene> selectAll(); //获取全部场景信息
}
