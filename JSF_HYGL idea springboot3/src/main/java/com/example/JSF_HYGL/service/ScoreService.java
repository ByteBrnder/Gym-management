package com.example.JSF_HYGL.service;

import com.example.JSF_HYGL.pojo.Score;

public interface ScoreService {
    Object findAll();

    void add(Score score);

    void update(Score score);

    void delete(Integer id);

    void yuyue(Integer id);
}
