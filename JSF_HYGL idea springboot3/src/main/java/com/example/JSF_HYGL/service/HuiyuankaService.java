package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.Huiyuanka;

public interface HuiyuankaService {

    Object findAll();

    void add(Huiyuanka huiyuanka);

    void update(Huiyuanka huiyuanka);

    void delete(Integer id);

    void goumai(Integer id);
}
