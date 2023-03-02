/**
 * Copyright (C), 2023-02-28
 * FileName: SubmitService
 * Author:   Lv
 * Date:     2023/2/28 23:15
 * Description: Submit服务类
 */
package com.evan.seprojrearend.service;

import com.evan.seprojrearend.mapper.SubmitMapper;
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

    /**
     * 用户进行比赛登记
     * **/
    public String newSubmit(String submitterid, String competitionid){
        Submit newSubmit = new Submit();
        long time=new Date().getTime();
        System.out.println(""+time);
        Date dates=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String times=sdf.format(dates);

        newSubmit.setSubmitid('c'+times);
        newSubmit.setSubmitterid(submitterid);
        newSubmit.setCompetitionid(competitionid);

        if(submitMapper.insert(newSubmit)==1)
            return "True";
        else
            return "False";

    }
}
