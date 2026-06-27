package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.TuanKe;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TuankeMapper {
    //查看团课
    @Select("select * from tuanke")
    List<TuanKe> findAll();

    //添加
    @Insert("insert into tuanke(id,tkname,jiaolian,kctime)values (#{id},#{tkname},#{jiaolian},#{kctime})")
    void add(TuanKe tuanKe);

    //更新
    @Update("update tuanke set tkname=#{tkname},jiaolian=#{jiaolian},kctime=#{kctime} where id=#{id}")
    void update(TuanKe tuanKe);

    //删除
    @Delete("delete from tuanke where id=#{id}")
    void delete(Integer id);

    //预约
    @Insert("INSERT INTO myscore (user_id, kcname, jiaolian, kctime,sxhykdj)" +
            "SELECT #{userId}, tuanke.tkname, tuanke.jiaolian, tuanke.kctime,tuanke.sxhykdj FROM tuanke WHERE tuanke.id = #{id};")
    void yuyue(@Param("id") Integer id, @Param("userId") Integer userId);
}
