package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.HuiyuankaMapper;
import com.example.JSF_HYGL.mapper.JiaolianMapper;
import com.example.JSF_HYGL.pojo.Huiyuanka;
import com.example.JSF_HYGL.pojo.Jiaolian;
import com.example.JSF_HYGL.service.HuiyuankaService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HuiyuankaServiceImpl implements HuiyuankaService {

    @Autowired
    private HuiyuankaMapper huiyuankaMapper;
    @Override
    public List<Huiyuanka> findAll() {
        return huiyuankaMapper.findAll();

    }

    @Override
    public void add(Huiyuanka huiyuanka) {
        huiyuankaMapper.add(huiyuanka);
    }

    @Override
    public void update(Huiyuanka huiyuanka) {
        huiyuankaMapper.update(huiyuanka);
    }

    @Override
    public void delete(Integer id) {
        huiyuankaMapper.delete(id);
    }

    @Override
    public void goumai(Integer id) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        huiyuankaMapper.goumai(id, userId);
    }
}
