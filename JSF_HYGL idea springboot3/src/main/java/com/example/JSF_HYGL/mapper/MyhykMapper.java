package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.MyScore;
import com.example.JSF_HYGL.pojo.Myhyk;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface MyhykMapper {


    //查看我的会员卡
    @Select("SELECT b.* FROM `user` a INNER JOIN myhyk b ON a.id = b.user_id WHERE a.id = #{userId}")
    List<Myhyk> findAll(@Param("userId") Integer userId);

    //更新到期时间
    @Update("update myhyk set daoqitime=DATE_ADD(#{time},INTERVAL 1 MONTH)where id=#{id}")
    void update(LocalDateTime time,Integer id);

    //删除
    @Delete("delete from myhyk where id=#{id}")
    void delete(Integer id);
}
