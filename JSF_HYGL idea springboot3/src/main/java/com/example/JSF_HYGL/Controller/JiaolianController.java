package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Huiyuanka;
import com.example.JSF_HYGL.pojo.Jiaolian;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.service.JiaolianService;
import com.example.JSF_HYGL.service.TuanKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jiaolian")//网址
@Validated//参数校验
public class JiaolianController {

    @Autowired
    private JiaolianService jiaolianService;

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(jiaolianService.findAll());
    }
    //@RequestBody 自动读取请求头json格式数据
    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated Jiaolian jiaolian) {
        jiaolianService.add(jiaolian);
        return Result.success();

    }

    @PutMapping("/update")
    public  Result update( @RequestBody Jiaolian jiaolian) {
        jiaolianService.update(jiaolian);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        jiaolianService.delete(id);
        return Result.success();
    }
}
