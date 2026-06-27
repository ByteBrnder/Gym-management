package com.example.JSF_HYGL.mapper;



import com.example.JSF_HYGL.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
    //添加
//    @Insert("insert into user(username,password,old,xinbie,phone,ruhuirq,isadmin)values(#{username},#{password},#{old},#{xinbie},#{phone},now(),#{isadmin})")
//    void add(String username,String password,Integer old,String xinbie,int phone,Boolean isadmin);
    //添加
    @Insert("insert into user(username,password,old,xinbie,ruhuirq,isadmin)values(#{username},#{password},#{old},#{xinbie},now(),#{isadmin})")
    void add(String username,String password,Integer old,String xinbie,Boolean isadmin);


    //更新old phone 且不为空
    @Update("update user set old=#{old},phone=#{phone} where id=#{id} ")
    void update(User user);

    @Update("update user set touxiang=#{avatarUrl} where id=#{id}")
    void updateAvater(String avatarUrl,Integer id);

    @Update("update user set  password=#{newPwd} where id=#{id}")
    void updatePwd(String newPwd, Integer id);
}
