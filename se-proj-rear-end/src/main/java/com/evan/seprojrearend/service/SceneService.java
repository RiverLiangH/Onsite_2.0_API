package com.evan.seprojrearend.service;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.mapper.SceneMapper;
import com.evan.seprojrearend.po.Scene;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class SceneService {

    @Autowired
    private SceneMapper sceneMapper;

    public SceneService(SceneMapper sceneMapper) {
        this.sceneMapper = sceneMapper;
    }

    //分页筛选数据
    public JSONObject findByPaging(String source, String scenetype, String risktype, String roadtype, Integer lanenum, Integer pageNum, Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        Map param = new HashMap();
        param.put("source",source);
        param.put("scenetype",scenetype);
        param.put("risktype",risktype);
        param.put("roadtype",roadtype);
        param.put("lanenum",lanenum);
        Page<Scene> data = sceneMapper.findByPaging(param);
        JSONObject result = new JSONObject();
        result.put("scene",data);
        result.put("pages",data.getPages());
        result.put("total",data.getTotal());
        return result;
    }

    //返回单独一组数据
    public JSONObject getSceneMsg(String sceneName){
        return sceneMapper.selectByScenename(sceneName);
    }
}
