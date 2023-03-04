/**
 * Copyright (C), 2023-03-03
 * FileName: EntryMapper
 * Author:   Lv
 * Date:     2023/3/3 8:28
 * Description: entry interface
 */
package com.evan.seprojrearend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.po.Entry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntryMapper {

    int insert(Entry record);

    Entry selectByPrimaryKey(String participantid, String competitionid);

    //返回所有比赛参赛人数
    List<JSONObject> selectByCount();

}
