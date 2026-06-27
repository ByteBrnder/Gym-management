package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.Score;
import com.example.JSF_HYGL.service.ScoreService;
import com.example.JSF_HYGL.service.TuanKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")//网址
@Validated
public class ScoreController
{
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(scoreService.findAll());
    }

    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated Score score) {
        scoreService.add(score);
        return Result.success();

    }

    @PutMapping("/update")
    public  Result update( @RequestBody Score score) {
        scoreService.update(score);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        scoreService.delete(id);
        return Result.success();
    }

    //预约课程
    @PostMapping("/yuyue")
    public Result yuyue(Integer id) {

        scoreService.yuyue(id);
        return Result.success();

    }
}
