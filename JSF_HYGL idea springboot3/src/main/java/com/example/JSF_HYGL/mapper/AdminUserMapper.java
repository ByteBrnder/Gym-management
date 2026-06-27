package com.example.JSF_HYGL.mapper;

import com.example.JSF_HYGL.pojo.AdminUser;
import com.example.JSF_HYGL.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminUserMapper {

    //查询
    @Select("select * from user")
    List<AdminUser> findAll();

    //添加
    @Insert("insert into user(id,username,password,old,xinbie,phone,ruhuirq,isadmin)values(#{id},#{username},#{password},#{old},#{xinbie},#{phone},now(),#{isadmin})")
    void add(AdminUser adminUser);

    //修改
    @Update("update user set username=#{username},password=#{password},old=#{old},xinbie=#{xinbie},phone=#{phone},isadmin=#{isadmin} where id=#{id}")
    void update(AdminUser adminUser);

    @Delete("delete from user where id=#{id}")
    void delete(Integer id);
}
