package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.User;
import com.example.JSF_HYGL.service.AdminUserService;
import com.example.JSF_HYGL.service.QicaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminuser")//网址
@Validated//参数校验
public class AdminUser {
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/tianjia")
    public Result add(@RequestBody @Validated com.example.JSF_HYGL.pojo.AdminUser adminUser) {
        adminUserService.add(adminUser);
        return Result.success();

    }

    @GetMapping("/chakan")
    public Result findAll() {
        return Result.success(adminUserService.findAll());
    }

    @PutMapping("/update")
    public  Result update(@RequestBody com.example.JSF_HYGL.pojo.AdminUser adminUser) {
        adminUserService.update(adminUser);
        return Result.success();

    }
    @DeleteMapping("/delete")
    public Result delete( Integer id) {
        adminUserService.delete(id);
        return Result.success();
    }
}
