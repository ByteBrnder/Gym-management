package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.JiaolianMapper;
import com.example.JSF_HYGL.mapper.MyScoreMapper;
import com.example.JSF_HYGL.pojo.MyScore;
import com.example.JSF_HYGL.service.MyScoreService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class MyScoreServiceImpl implements MyScoreService {

    @Autowired
    private MyScoreMapper myScoreMapper;
    @Override
    public Object findAll() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return  myScoreMapper.findAll(id);
    }

    @Override
    public void delete(Integer id) {
        myScoreMapper.delete(id);
    }


}
