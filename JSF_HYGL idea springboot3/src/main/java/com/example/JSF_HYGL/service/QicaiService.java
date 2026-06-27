package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.Qicai;

import java.util.List;

public interface QicaiService {
    //新增器材

    void add(Qicai qicai);
    //器材显示

    List<Qicai> findAll();

    void update(Qicai qicai);

    void delete(Integer id);
}
