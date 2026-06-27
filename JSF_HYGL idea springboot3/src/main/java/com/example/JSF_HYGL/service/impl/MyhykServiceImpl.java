package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.MyScoreMapper;
import com.example.JSF_HYGL.mapper.MyhykMapper;
import com.example.JSF_HYGL.pojo.Myhyk;
import com.example.JSF_HYGL.service.MyhykService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class MyhykServiceImpl implements MyhykService {

    @Autowired
    private MyhykMapper myhykMapper;
    @Override
    public Object findAll() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        return myhykMapper.findAll(id);
    }

    @Override
    public void update(LocalDateTime time,Integer id) {
        myhykMapper.update(time,id);
    }

    @Override
    public void delete(Integer id) {
        myhykMapper.delete(id);
    }
}
