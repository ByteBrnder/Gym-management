package com.example.JSF_HYGL.Controller;


import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.User;
import com.example.JSF_HYGL.service.QicaiService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/qicai")//网址
@Validated
public class QicaiController {
    @Autowired
    private QicaiService qicaiService;

        @PostMapping("/tianjia")
        public Result add(@RequestBody @Validated Qicai qicai) {
            qicaiService.add(qicai);
            return Result.success();

        }

       @GetMapping("/chakan")
        public Result findAll() {
            return Result.success(qicaiService.findAll());
       }

     @PutMapping("/update")
     public  Result update( @RequestBody Qicai qicai) {
        qicaiService.update(qicai);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
          qicaiService.delete(id);
          return Result.success();
    }


}
