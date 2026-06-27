package com.example.JSF_HYGL.service.impl;

import com.example.JSF_HYGL.mapper.ScoreMapper;
import com.example.JSF_HYGL.mapper.TuankeMapper;
import com.example.JSF_HYGL.pojo.Score;
import com.example.JSF_HYGL.pojo.TuanKe;
import com.example.JSF_HYGL.service.ScoreService;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public List<Score> findAll() {
        return scoreMapper.findAll();

    }

    @Override
    public void add(Score score) {
        scoreMapper.add(score);
    }

    @Override
    public void update(Score score) {
        scoreMapper.update(score);
    }

    @Override
    public void delete(Integer id) {
        scoreMapper.delete(id);
    }

    @Override
    public void yuyue(Integer id) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("id");
        scoreMapper.yuyue(id, userId);
    }
}
