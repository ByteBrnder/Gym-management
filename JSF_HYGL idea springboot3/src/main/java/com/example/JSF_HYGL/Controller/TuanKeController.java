package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.Score;
import com.example.JSF_HYGL.pojo.TuanKe;
import com.example.JSF_HYGL.service.QicaiService;
import com.example.JSF_HYGL.service.TuanKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tuanke")//网址
@Validated//参数校验
public class TuanKeController {
    @Autowired
    private TuanKeService tuanKeService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(tuanKeService.findAll());
    }

    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated TuanKe tuanKe) {
        tuanKeService.add(tuanKe);
        return Result.success();

    }

    @PutMapping("/update")
    public  Result update( @RequestBody TuanKe tuanKe) {
        tuanKeService.update(tuanKe);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        tuanKeService.delete(id);
        return Result.success();
    }

    //预约课程
    @PostMapping("/yuyue")
    public Result yuyue(Integer id) {
//        System.out.println(id);
        tuanKeService.yuyue(id);
        return Result.success();

    }


}
