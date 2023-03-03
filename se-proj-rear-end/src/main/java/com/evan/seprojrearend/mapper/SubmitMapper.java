package com.evan.seprojrearend.mapper;

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
//    Submit selectByPrimaryKey(String submitid);
//
//    int updateByPrimaryKeySelective(Submit record);
//

}
