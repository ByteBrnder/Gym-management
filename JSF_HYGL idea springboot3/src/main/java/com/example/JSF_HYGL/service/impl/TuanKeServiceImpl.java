package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.QicaiMapper;
import com.example.JSF_HYGL.mapper.TuankeMapper;
import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.TuanKe;
import com.example.JSF_HYGL.service.TuanKeService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TuanKeServiceImpl implements TuanKeService {


    @Autowired
    private TuankeMapper tuankeMapper;
    @Override
    public List<TuanKe> findAll() {
        return tuankeMapper.findAll();

    }

    @Override
    public void add(TuanKe tuanKe) {
        tuankeMapper.add(tuanKe);
    }

    @Override
    public void update(TuanKe tuanKe) {
        tuankeMapper.update(tuanKe);
    }

    @Override
    public void delete(Integer id) {
        tuankeMapper.delete(id);
    }

    @Override
    public void yuyue(Integer id) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        tuankeMapper.yuyue(id, userId);
    }
}
