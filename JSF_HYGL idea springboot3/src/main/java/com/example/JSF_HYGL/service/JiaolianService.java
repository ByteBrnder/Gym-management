package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.Jiaolian;

public interface JiaolianService {

    Object findAll();

    void add(Jiaolian jiaolian);

    void update(Jiaolian jiaolian);

    void delete(Integer id);

}
