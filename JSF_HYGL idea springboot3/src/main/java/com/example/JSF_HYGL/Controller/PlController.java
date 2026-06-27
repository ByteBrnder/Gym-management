package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Pl;
import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.service.MyScoreService;
import com.example.JSF_HYGL.service.PlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pl")//网址
@Validated//参数校验
public class PlController {
    @Autowired
    private PlService plService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(plService.findAll());
    }
    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated Pl pl) {
        plService.add(pl);
        return Result.success();

    }

}
