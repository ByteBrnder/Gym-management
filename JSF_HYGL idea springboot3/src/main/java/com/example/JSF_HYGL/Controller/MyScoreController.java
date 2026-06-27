package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.MyScore;
import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.service.MyScoreService;
import com.example.JSF_HYGL.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myscore")//网址
@Validated
public class MyScoreController {
    @Autowired
    private MyScoreService myScoreService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(myScoreService.findAll());
    }

    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        myScoreService.delete(id);
        return Result.success();
    }

}

