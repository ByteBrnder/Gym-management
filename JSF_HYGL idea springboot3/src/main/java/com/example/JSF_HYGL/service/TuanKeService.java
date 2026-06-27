package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.TuanKe;

public interface TuanKeService {
    Object findAll();

    void add(TuanKe tuanKe);


    void update(TuanKe tuanKe);

    void delete(Integer id);

    void yuyue(Integer id);
}
