package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Competition;

public interface CompetitionMapper {
    int deleteByPrimaryKey(String competitionid);

    int insert(Competition record);

    int insertSelective(Competition record);

    Competition selectByPrimaryKey(String competitionid);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}