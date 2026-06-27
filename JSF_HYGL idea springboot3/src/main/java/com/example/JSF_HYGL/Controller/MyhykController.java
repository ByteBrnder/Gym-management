package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Jiaolian;
import com.example.JSF_HYGL.pojo.Myhyk;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.service.MyScoreService;
import com.example.JSF_HYGL.service.MyhykService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/myhyk")//网址
@Validated
public class MyhykController {
    @Autowired
    private MyhykService myhykService;

    @GetMapping("/chakan")
    public Result findAll() {

        return Result.success(myhykService.findAll());
    }

    @PutMapping("/update")
    public  Result update(@RequestBody LocalDateTime time,Integer id) {
        //System.out.println(time);
        myhykService.update(time,id);
        return Result.success();

    }

    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        myhykService.delete(id);
        return Result.success();
    }


}
