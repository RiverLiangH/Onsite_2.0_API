/**
 * Copyright (C), 2023-03-03
 * FileName: EntryService
 * Author:   Lv
 * Date:     2023/3/3 8:42
 * Description: entry service
 */
package com.evan.seprojrearend.service;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.mapper.EntryMapper;
import com.evan.seprojrearend.po.Entry;
import com.evan.seprojrearend.po.Submit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryMapper entryMapper;

    /**
     * 用户参赛记录
     * **/
    public String newEntry(String participantid, String competitionid){
        Entry newEntry = new Entry();
        long time=new Date().getTime();
        System.out.println(""+time);
        Date dates=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        String times=sdf.format(dates);

        newEntry.setEntryid("e_"+times+"_"+participantid);
        newEntry.setParticipantid(participantid);
        newEntry.setCompetitionid(competitionid);
        newEntry.setEntrytime(dates);


        if(entryMapper.insert(newEntry)==1)
            return "True";
        else
            return "False";

    }

    /**
     * 获取全部比赛参赛人数
     * **/
    public List<JSONObject> getCompetitionsCount(){
        //System.out.println("service没问题");
        //return competitionMapper.selectAll();
        return entryMapper.selectByCount();
    }
}
