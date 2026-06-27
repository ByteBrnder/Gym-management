package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.MyScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyScoreMapper {

    //查询该用户的课表
    @Select("SELECT b.* FROM `user` a INNER JOIN myscore b ON a.id = b.user_id WHERE a.id = #{userId}")
    List<MyScore> findAll(@Param("userId") Integer userId);


    //取消预约
    @Delete("delete from myscore where id=#{id}")
    void delete(Integer id);
}
