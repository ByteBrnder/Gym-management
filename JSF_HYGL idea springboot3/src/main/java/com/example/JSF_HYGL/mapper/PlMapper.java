package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.Pl;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlMapper {


    //显示所有评论
    @Select("select * from plbiao join user on plbiao.user_id = user.id")
    List<Pl> findAll();

    //添加
    @Insert("insert into plbiao(user_id,pl,fabiaotime)values (#{userId},#{pl},now())")
    void add(@Param("pl")String pl,@Param("userId") Integer userId);
}
