package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Qicai;
import com.example.JSF_HYGL.pojo.Result;
import com.example.JSF_HYGL.pojo.User;
import com.example.JSF_HYGL.service.UserService;
import com.example.JSF_HYGL.utils.JwtUtil;
import com.example.JSF_HYGL.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")//网址
@Validated//参数校验
public class UserController {
    @Autowired
    private  UserService userService;



    @PostMapping("/register")//post方法
public Result register(String username,String password,Integer old,String xinbie,Integer phone,Boolean isadmin) {
    //查询用户
      User u= userService.findByUserName(username);
      if(u==null) {
          //没有被占用
          //注册

         userService.register(username,password,old,xinbie,isadmin);
          return Result.success();
      }else {
          //占用
          return  Result.error("用户名已被占用");

      }

 }

    //登录
    @PostMapping("/login")
    public  Result<String> login(String username,String password) {
        //根据用户名查询用户
        User loginUser=userService.findByUserName(username);
        //判断改用户是否存在
        if(loginUser==null) {
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if(password.equals(loginUser.getPassword())){
            //登录成功
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token=JwtUtil.genToken(claims);
            Map<String, Object> a = new HashMap<>();
            a.put("token",token);
            a.put("user",loginUser);
            return Result.success(a);
        }
        return Result.error("密码错误！");
    }
    //个人中心
    @GetMapping("/userInfo")
    public  Result<User> userInfo() {
        //根据用户名查询用户

        Map<String,Object> map= ThreadLocalUtil.get();
      String  username=(String)map.get("username");

     User user = userService.findByUserName(username);
     return Result.success(user);
    }

    @PutMapping("/update")
    public  Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();

    }

    @PatchMapping("updateAvater")
    //修改头像
    public Result updateAvater(@RequestParam  String avatarUrl){
        userService.updateAvater(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    //修改密码
    //@RequestBody 自动读取请求头json格式数据 转换成map集合对象
    public  Result updatePwd(@RequestBody Map<String,String> params){
        //校验参数
       String oldPwd=params.get("old_pwd");
       String newPwd=params.get("new_pwd");
       String rePwd=params.get("re_pwd");

       if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
           return Result.error("缺少必要的参数");

       }

       //原密码是否正确
       Map<String,Object> map= ThreadLocalUtil.get();
      String username=(String) map.get("username");
      User loginUser=userService.findByUserName(username);
      loginUser.getPassword();
      if(!loginUser.getPassword().equals(oldPwd)){
          return Result.error("原密码填写不正确");
      }

      if(!rePwd.equals(newPwd)){
          return Result.error("两次填写的新密码不一样");
      }


        //更新
        userService.updatePwd(newPwd);
      return Result.success();

    }
}
