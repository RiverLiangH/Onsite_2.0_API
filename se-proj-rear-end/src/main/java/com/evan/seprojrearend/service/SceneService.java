/**
 * Copyright (C), 2023-02-09
 * FileName: SceneService
 * Author:   Lv
 * Date:     2023/2/9 18:25
 * Description: 场景类的业务逻辑方法
 */
package com.evan.seprojrearend.service;

import com.evan.seprojrearend.mapper.SceneMapper;
import com.evan.seprojrearend.po.Scene;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class SceneService {
    @Autowired
    private SceneMapper sceneMapper;

    /**
     * 获取所有场景并返回分页场景
     * @param currentPage 当前页码
     * @param pageSize 一页中包含的数据条数
     * **/
//    public Page<Scene> getSceneList(int currentPage, int pageSize){
//        Page<Scene> scenePage = PageHelper.startPage(currentPage,pageSize).doSelectPage(() -> sceneMapper.selectAll());
//        return scenePage;
//    }
}
