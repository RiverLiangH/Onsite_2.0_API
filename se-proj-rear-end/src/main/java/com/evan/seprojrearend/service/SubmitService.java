/**
 * Copyright (C), 2023-02-28
 * FileName: SubmitService
 * Author:   Lv
 * Date:     2023/2/28 23:15
 * Description: Submit服务类
 */
package com.evan.seprojrearend.service;

import com.evan.seprojrearend.mapper.EntryMapper;
import com.evan.seprojrearend.mapper.SubmitMapper;
import com.evan.seprojrearend.po.Entry;
import com.evan.seprojrearend.po.Submit;
import com.evan.seprojrearend.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SubmitService {

    @Autowired
    private SubmitMapper submitMapper;
    @Autowired
    private EntryMapper entryMapper;

    /**
     * 用户提交比赛作品
     * **/
    public String newSubmit(String submitterid, String competitionid, String dockerid){
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

        Entry tempEntry = entryMapper.selectByPrimaryKey(submitterid,competitionid);
        System.out.println("tempEntry:"+tempEntry);
        // 检查用户是否参赛，未参赛则不允许提交
        if(tempEntry.getParticipantid().equals(submitterid) && tempEntry.getCompetitionid().equals(competitionid))
        {
            System.out.println("提交成功");
            if(submitMapper.insert(newSubmit)==1)
                return "True";
            else
                return "False";
        }
        else
            return "False";


    }
}
