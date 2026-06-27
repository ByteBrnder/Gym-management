package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.Myhyk;

import java.time.LocalDateTime;

public interface MyhykService
{

    Object findAll();

    void update(LocalDateTime time,Integer id);

    void delete(Integer id);
}
