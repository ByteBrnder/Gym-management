package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.MyScoreMapper;
import com.example.JSF_HYGL.mapper.PlMapper;
import com.example.JSF_HYGL.pojo.Pl;
import com.example.JSF_HYGL.service.PlService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlServiceImpl implements PlService {
    @Autowired
    private PlMapper plMapper;

    @Override
    public void add(Pl pl) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        //System.out.println(userId);
        plMapper.add(pl.getPl(),userId);
    }

    @Override
    public List<Pl> findAll() {

        return  plMapper.findAll();
    }
}
