package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.AdminUser;
import com.example.JSF_HYGL.pojo.User;

import java.util.List;

public interface AdminUserService {

    void add(AdminUser adminUser);

    List<AdminUser> findAll();

    void update(AdminUser adminUser);

    void delete(Integer id);
}
