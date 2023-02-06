package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Submit;

public interface SubmitMapper {
    int deleteByPrimaryKey(String submitid);

    int insert(Submit record);

    int insertSelective(Submit record);

    Submit selectByPrimaryKey(String submitid);

    int updateByPrimaryKeySelective(Submit record);

    int updateByPrimaryKey(Submit record);
}