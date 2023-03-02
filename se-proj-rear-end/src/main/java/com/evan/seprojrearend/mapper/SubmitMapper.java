package com.evan.seprojrearend.mapper;

import com.evan.seprojrearend.po.Submit;
import org.apache.ibatis.annotations.Param;

public interface SubmitMapper {

    int insert(Submit record);

//    int deleteByPrimaryKey(String submitid);
//
//    int insertSelective(Submit record);
//
//    Submit selectByPrimaryKey(String submitid);
//
//    int updateByPrimaryKeySelective(Submit record);
//
//    int updateByPrimaryKey(Submit record);

}
