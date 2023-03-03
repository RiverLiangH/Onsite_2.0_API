/**
 * Copyright (C), 2023-03-03
 * FileName: EntryMapper
 * Author:   Lv
 * Date:     2023/3/3 8:28
 * Description: entry interface
 */
package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Entry;
import org.apache.ibatis.annotations.Param;

public interface EntryMapper {

    int insert(Entry record);

    Entry selectByPrimaryKey(String participantid, String competitionid);
}
