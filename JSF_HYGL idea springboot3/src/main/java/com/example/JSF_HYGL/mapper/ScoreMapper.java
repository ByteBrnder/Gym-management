package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {
    //查看
    @Select("select * from score")
    List<Score> findAll();

    //添加
    @Insert("insert into score(kcname,jiaolian,kctime,sxhykdj)values (#{kcname},#{jiaolian},#{kctime},#{sxhykdj})")
    void add(Score score);
    //更新
    @Update("update score set kcname=#{kcname},jiaolian=#{jiaolian},kctime=#{kctime},sxhykdj=#{sxhykdj} where id=#{id}")
    void update(Score score);

    //删除
    @Delete("delete from score where id=#{id}")
    void delete(Integer id);


    //预约


    @Insert("INSERT INTO myscore (user_id, kcname, jiaolian, kctime, sxhykdj)" +
            "SELECT #{userId}, score.kcname, score.jiaolian, score.kctime, score.sxhykdj FROM score WHERE score.id = #{id};")
    void yuyue(@Param("id") Integer id, @Param("userId") Integer userId);
}
