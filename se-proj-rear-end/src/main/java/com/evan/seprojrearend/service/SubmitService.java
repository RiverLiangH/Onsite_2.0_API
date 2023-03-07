/**
 * Copyright (C), 2023-02-28
 * FileName: SubmitService
 * Author:   Lv
 * Date:     2023/2/28 23:15
 * Description: Submit服务类
 */
package com.evan.seprojrearend.service;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.mapper.EntryMapper;
import com.evan.seprojrearend.mapper.SubmitMapper;
import com.evan.seprojrearend.po.Entry;
import com.evan.seprojrearend.po.Scene;
import com.evan.seprojrearend.po.Submit;
import com.evan.seprojrearend.po.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmitService {

    @Autowired
    private SubmitMapper submitMapper;
    @Autowired
    private EntryMapper entryMapper;

    /**
     * 用户提交比赛作品
     * **/
    public JSONObject newSubmit(String submitterid, String competitionid, String dockerid){
        JSONObject message = new JSONObject();  // 需要返回的数据
        System.out.println("newSubmit开始执行");
        Submit newSubmit = new Submit();
        long time=new Date().getTime();
        Date dates=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String times=sdf.format(dates);

        newSubmit.setSubmitid("s_"+times+"_"+submitterid);
        newSubmit.setSubmitterid(submitterid);
        newSubmit.setCompetitionid(competitionid);
        newSubmit.setDockerid(dockerid);
        newSubmit.setSubmittime(dates);

        /*将需要返回的信息加入message中*/
        message.put("submitTime",dates);
        message.put("dockerId",dockerid);
        message.put("submitterId",submitterid);
        message.put("competitionId",competitionid);

        Entry tempEntry = entryMapper.selectByPrimaryKey(submitterid,competitionid);
        System.out.println("tempEntry:"+tempEntry);
        // 检查用户是否参赛，未参赛则不允许提交
        if(tempEntry.getParticipantid().equals(submitterid) && tempEntry.getCompetitionid().equals(competitionid))
        {
            System.out.println("提交成功");
            if(submitMapper.insert(newSubmit)==1)
                message.put("result","True");
            else
                message.put("result","False");
        }
        else
            message.put("result","False");
        return message;
    }

    /**
    * 获取全部提交信息（按成绩排序）
    * **/
    public JSONObject findByPaging(String competitionId, Integer pageNum, Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        Page<Submit> data = submitMapper.findByPaging(competitionId);
        JSONObject result = new JSONObject();
        result.put("submit",data);
        result.put("pages",data.getPages());
        result.put("total",data.getTotal());
        return result;
    }

    /**
     * 获取单个用户的全部提交信息
     * **/
    public List<JSONObject> selectBySubmitterId(String submitterId, String competitionId){
        return submitMapper.selectBySubmitterId(submitterId,competitionId);
    }
}
