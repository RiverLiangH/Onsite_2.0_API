package com.evan.seprojrearend.controller;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.common.JsonResult;
import com.evan.seprojrearend.mapper.sceneSubmitMapper;
import com.evan.seprojrearend.service.SceneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 场景分页查询
     * **/
    @ResponseBody
    @ApiOperation(value = "分页查询")
    @GetMapping("find_by_paging")
    public JsonResult findByPaging(String source, String scenetype, String risktype, String roadtype, Integer lanenum, Integer pageNum, Integer pageSize){
        String re = null;
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        try {
            re = String.valueOf(sceneService.findByPaging(source, scenetype, risktype, roadtype, lanenum, pageNum, pageSize));
            message.put("scene", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 根据sceneName返回一组数据
     * **/
    @ResponseBody
    @ApiOperation(value = "根据sceneName返回一组数据")
    @GetMapping("get_scene_msg")
    public JsonResult getScenceMsg(String sceneName){
        String re = null;
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        try {
            re = String.valueOf(sceneService.getSceneMsg(sceneName));
            message.put("scene", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

    /**
     * 获取某个场景提交的所有用户
     * **/
    @ResponseBody
    @GetMapping("scene_user")
    public JsonResult getSceneUser(String sceneName){
        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
        List<JSONObject> re = null;
//        re = String.valueOf(sceneService.sceneUser(sceneName));
//        message.put("users", re);
        try {
            re = sceneService.sceneUser(sceneName);
            message.put("users", re);
        }catch (Exception e){
            return JsonResult.isError(10001,"未知错误");
        }
        return JsonResult.isOk(message);
    }

//    /**
//     * 获取某个场景所有信息
//     * **/
//    @ResponseBody
//    @GetMapping("scene_msg")
//    public JsonResult getSceneMsg(String sceneName){
//        Map<String, Object> message = new HashMap<>();  // 前后端传递消息
//        List<JSONObject> re = null;
//        //在请求头里获取token
//        try {
//            //re = submitService.selectBySubmitterId(userid,competitionid);
//            message.put("msg", re);
//        }catch (Exception e){
//            return JsonResult.isError(10001,"未知错误");
//        }
//        return JsonResult.isOk(message);
//    }

}
