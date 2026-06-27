package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.JiaolianMapper;
import com.example.JSF_HYGL.mapper.TuankeMapper;
import com.example.JSF_HYGL.pojo.Jiaolian;
import com.example.JSF_HYGL.pojo.TuanKe;
import com.example.JSF_HYGL.service.JiaolianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiaolianServiceImpl implements JiaolianService {
    @Autowired
    private JiaolianMapper jiaolianMapper;
    @Override
    public List<Jiaolian> findAll() {
        return jiaolianMapper.findAll();

    }

    @Override
    public void add(Jiaolian jiaolian) {
        jiaolianMapper.add(jiaolian);
    }

    @Override
    public void update(Jiaolian jiaolian) {
        jiaolianMapper.update(jiaolian);
    }

    @Override
    public void delete(Integer id) {
        jiaolianMapper.delete(id);
    }
}
