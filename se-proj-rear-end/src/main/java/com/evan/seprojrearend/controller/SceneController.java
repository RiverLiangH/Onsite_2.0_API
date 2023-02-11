/**
 * Copyright (C), 2023-02-09
 * FileName: SceneController
 * Author:   Lv
 * Date:     2023/2/9 18:31
 * Description: 场景的控制类
 */
package com.evan.seprojrearend.controller;

import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.po.Scene;
import com.evan.seprojrearend.service.SceneService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags="场景信息模块")
@RestController
@CrossOrigin
@RequestMapping("/scene")
public class SceneController {
    @Autowired
    private SceneService sceneService;

    /**
     *
     * **/
//    @ApiOperation(value="分页测试")
//    @ResponseBody
//    @GetMapping("test")
//    public Page<Scene> test(int currentPage, int pageSize){
//        return sceneService.getSceneList(currentPage,pageSize);
//    }
}
