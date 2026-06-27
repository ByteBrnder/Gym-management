package com.example.JSF_HYGL.mapper;


import com.example.JSF_HYGL.pojo.Qicai;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QicaiMapper {
    //新增器材
    @Insert("insert into qicaibiao(qctp,qcname,jiage,goumaitime)values(#{qctp},#{qcname},#{jiage},now())")
    void add(Qicai qicai);



    //查询
    @Select("select * from qicaibiao ")
    List<Qicai> findAll();



    //更新
    @Update("update qicaibiao set qcname=#{qcname},jiage=#{jiage} where id=#{id}")
    void update(Qicai qicai);


    //删除
    @Delete("delete from qicaibiao where id=#{id}")
    void delete(Integer id);
}
