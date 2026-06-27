package com.example.JSF_HYGL.service.impl;


import com.example.JSF_HYGL.mapper.QicaiMapper;
import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.service.QicaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class QicaiServiceImpl implements QicaiService {

    @Autowired
    private QicaiMapper qicaiMapper;
    @Override
    public void add(Qicai qicai) {
        //补充属性值
        qicai.setGoumaitime(LocalDateTime.now());
        qicaiMapper.add(qicai);
    }

    @Override
    public List<Qicai> findAll() {
       return qicaiMapper.findAll();

    }

    @Override
    public void update(Qicai qicai) {
        qicaiMapper.update(qicai);
    }

    @Override
    public void delete(Integer id) {
        qicaiMapper.delete(id);
    }


}
