package com.evan.seprojrearend.mapper;

import com.alibaba.fastjson.JSONObject;
import com.evan.seprojrearend.po.Scene;
import com.evan.seprojrearend.po.Submit;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SubmitMapper {

    int insert(Submit record);

//    List<Submit> selectAll(); //获取全部提交信息（按成绩排序）

    Page<Submit> findByPaging();   //获取全部提交信息（按成绩排序）

//    int updateByPrimaryKey(Submit record);

//    int deleteByPrimaryKey(String submitid);
//
//    int insertSelective(Submit record);
//
    List<JSONObject> selectBySubmitterId(String submitterid, String competitionid);   //获取单个用户的全部提交信息
//
//    int updateByPrimaryKeySelective(Submit record);
//

}
