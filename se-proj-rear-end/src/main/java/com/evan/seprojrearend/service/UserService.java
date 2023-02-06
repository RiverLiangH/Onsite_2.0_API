package com.evan.seprojrearend.service;

import com.evan.seprojrearend.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private com.evan.seprojrearend.mapper.UserMapper UserMapper;

    //1.1 用户登录验证
    public String isInUser(String email, String password){

        User thisUser = UserMapper.selectByPrimaryKey(email);
        if(thisUser!=null&& Objects.equals(thisUser.getPassword(), password))
            return "True";
        else
            return "False";
    }

    //1.2 用户注册
    public String newUser(String email,String password){

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        if(UserMapper.insert(newUser)==1)
            return "True";
        else
            return "False";
    }
}