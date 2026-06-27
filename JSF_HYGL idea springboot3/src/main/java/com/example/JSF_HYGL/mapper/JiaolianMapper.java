package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.Jiaolian;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JiaolianMapper {

    //查看
    @Select("select * from jiaolianbiao")
    List<Jiaolian> findAll();


    //添加
    @Insert("insert into jiaolianbiao(name,old,xinbie,sckc,phone)values (#{name},#{old},#{xinbie},#{sckc},#{phone})")
    void add(Jiaolian jiaolian);

    //更新
    @Update("update jiaolianbiao set name=#{name},old=#{old},xinbie=#{xinbie},sckc=#{sckc},phone=#{phone} where id=#{id}")
    void update(Jiaolian jiaolian);


    //删除
    @Delete("delete from jiaolianbiao where id=#{id}")
    void delete(Integer id);
}
