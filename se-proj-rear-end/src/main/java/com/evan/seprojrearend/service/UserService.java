/**
 * Copyright (C), 2023-02-03
 * FileName: UserService
 * Author:   Lv
 * Date:     2023/2/3 18:05
 * Description: 用户类——实现mapper接口
 */
package com.evan.seprojrearend.service;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.mapper.UserMapper;
import com.evan.seprojrearend.po.User;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据userid获取用户信息
     * **/
    public User selectByPrimaryKey(String userid){
        return userMapper.selectByPrimaryKey(userid);
    }

    /**
     * 用户登录验证
     * **/
    public String isInUser(String username, String password){

        //查找对应手机号码和密码的用户是否存在
        List<JSONObject> thisUser = userMapper.selectByName(username, password);
        if(thisUser.size()==0)
            return "False";
        else
            return "True";
    }

    /**
     * 用户注册
     * **/
    public String newUser(String username,String mobile,String email,Integer age,String sex,String password,String school,String department,String supervisorname,String supervisorrank,String researchfield,String works,String name){
        User newUser = new User();
        long time=new Date().getTime();
        System.out.println(""+time);
        Date dates=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String times=sdf.format(dates);

        newUser.setUserid(times);
        newUser.setUsername(username);
        newUser.setMobile(mobile);
        newUser.setAge(age);
        newUser.setEmail(email);
        newUser.setSex(sex);
        newUser.setPassword(password);
        newUser.setSchool(school);
        newUser.setDepartment(department);
        newUser.setSupervisorname(supervisorname);
        newUser.setSupervisorrank(supervisorrank);
        newUser.setResearchfield(researchfield);
        newUser.setWorks(works);
        newUser.setName(name);
        if(userMapper.insert(newUser)==1)
            return "True";
        else
            return "False";
    }

    /**
     * 查询用户信息
     * **/
    public JSONObject checkMsg(String username){
//        System.out.println(userMapper.selectByUsername(username));
        return userMapper.selectByUsername(username);
    }

    /**
     * 修改信息
     * **/
    public String changeUserMsg(String userid, String username,String mobile,String email,Integer age,String sex,String school,String department,String supervisorname,String supervisorrank,String researchfield,String works,String name){
        //根据userId查找
        User newUser = userMapper.selectByPrimaryKey(userid);

        //更新信息
        newUser.setUsername(username);
        newUser.setMobile(mobile);
        newUser.setAge(age);
        newUser.setEmail(email);
        newUser.setSex(sex);
        newUser.setSchool(school);
        newUser.setDepartment(department);
        newUser.setSupervisorname(supervisorname);
        newUser.setSupervisorrank(supervisorrank);
        newUser.setResearchfield(researchfield);
        newUser.setWorks(works);
        newUser.setName(name);
        if(userMapper.updateByPrimaryKeySelective(newUser)==1)
            return "True";
        else
            return "False";
    }

    /**
     * 修改密码
     * **/
    public String modifyPassword(String username, String password){
        User thisUser = userMapper.selectByUname(username);
        thisUser.setPassword(password);
        if(userMapper.updateByPrimaryKeySelective(thisUser)==1)
            return "True";
        else
            return "False";
    }

    /**
     * 判断用户名是否存在
     * **/
    public String validateUsername(String username){
        if(userMapper.countUsername(username)>=1)
            return "True";
        else
            return "False";
    }


}
