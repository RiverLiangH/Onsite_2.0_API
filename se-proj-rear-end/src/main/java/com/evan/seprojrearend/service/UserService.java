/**
 * Copyright (C), 2023-02-03
 * FileName: UserService
 * Author:   Lv
 * Date:     2023/2/3 18:05
 * Description: 用户类——实现mapper接口
 */
package com.evan.seprojrearend.service;

import com.evan.seprojrearend.mapper.UserMapper;
import com.evan.seprojrearend.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据userid获取用户信息
     * **/
    public User selectByPrimaryKey(String userid){
        return userMapper.selectByPrimaryKey(userid);
    }
}
