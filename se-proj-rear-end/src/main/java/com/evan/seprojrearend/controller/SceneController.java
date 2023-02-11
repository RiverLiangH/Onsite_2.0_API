package com.evan.seprojrearend.controller;

import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.service.SceneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@Api(tags="场景模块")
@RestController
@CrossOrigin
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    @Lazy
    private SceneService sceneService;

    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    /**
     * 用户登录验证
     * **/
    @ResponseBody
    @ApiOperation(value = "分页查询")
    @GetMapping("find_by_paging")
    public JsonResult findByPaging(Integer pageNum, Integer pageSize){
        String re = null;
//        re = String.valueOf(sceneService.findByPaging(pageNum, pageSize));
        try {
            re = String.valueOf(sceneService.findByPaging(pageNum, pageSize));
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(re);
    }

}
