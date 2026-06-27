package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.Huiyuanka;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HuiyuankaMapper {

    //查看
    @Select("select * from hyklx")
     List<Huiyuanka> findAll();

    //添加
    @Insert("insert into hyklx(id,dengji,jiage)values (#{id},#{dengji},#{jiage})")
    void add(Huiyuanka huiyuanka);

    //更新
    @Update("update hyklx set dengji=#{dengji},jiage=#{jiage} where id=#{id} ")
    void update(Huiyuanka huiyuanka);


    //删除
    @Delete("delete from hyklx where id=#{id}")
    void delete(Integer id);


    //购买
    @Insert("INSERT INTO myhyk (user_id, dengji, jiage, goumaitime, daoqitime)" +
            "SELECT #{userId}, hyklx.dengji, hyklx.jiage, now(),now() FROM hyklx WHERE hyklx.id = #{id};")
    void goumai(@Param("id") Integer id, @Param("userId") Integer userId);
}
