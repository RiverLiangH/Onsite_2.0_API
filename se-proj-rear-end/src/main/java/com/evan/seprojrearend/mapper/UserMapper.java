package com.evan.seprojrearend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.po.User;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    //修改个人信息
    User selectByUname(@Param("username")String username);

    //查询个人信息
    JSONObject selectByUsername(@Param("username") String username);

    //登录验证
    List<JSONObject> selectByName(@Param("username") String username, @Param("password") String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
