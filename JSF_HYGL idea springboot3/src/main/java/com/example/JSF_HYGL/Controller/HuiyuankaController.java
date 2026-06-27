package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Huiyuanka;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.Score;
import com.example.JSF_HYGL.service.HuiyuankaService;
import com.example.JSF_HYGL.service.JiaolianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/huiyuanka")//网址
@Validated
public class HuiyuankaController {

    @Autowired
    private HuiyuankaService huiyuankaService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(huiyuankaService.findAll());
    }


    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated Huiyuanka huiyuanka) {
        huiyuankaService.add(huiyuanka);
        return Result.success();

    }

    @PutMapping("/update")
    public  Result update( @RequestBody Huiyuanka huiyuanka) {
        huiyuankaService.update(huiyuanka);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        huiyuankaService.delete(id);
        return Result.success();
    }
    //购买
    @PostMapping("/goumai")
    public Result goumai(Integer id) {
        // System.out.println(id);
        huiyuankaService.goumai(id);
        return Result.success();

    }
}
