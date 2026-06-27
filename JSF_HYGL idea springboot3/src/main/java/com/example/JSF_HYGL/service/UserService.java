package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.User;

import java.util.List;


public interface UserService {
    //根据用户名查询用户
    public User findByUserName(String username);

    //注册
   // void  register(String username, String password,Integer old,String xinbie,Integer phone,Boolean isadmin);

    void  register(String username, String password,Integer old,String xinbie,Boolean isadmin);


    //更新
    void update(User user);
    //更新头像

    void updateAvater(String avatarUrl);
    //更新密码
    void updatePwd(String newPwd);


}
