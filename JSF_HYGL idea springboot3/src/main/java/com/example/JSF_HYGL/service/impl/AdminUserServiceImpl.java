package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.AdminUserMapper;
import com.example.JSF_HYGL.mapper.JiaolianMapper;
import com.example.JSF_HYGL.pojo.AdminUser;
import com.example.JSF_HYGL.pojo.User;
import com.example.JSF_HYGL.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public void add(AdminUser adminUser) {
        adminUserMapper.add(adminUser);
    }

    @Override
    public List<AdminUser> findAll() {
        return adminUserMapper.findAll();
    }

    @Override
    public void update(AdminUser adminUser) {
            adminUserMapper.update(adminUser);
    }

    @Override
    public void delete(Integer id) {
        adminUserMapper.delete(id);
    }
}
