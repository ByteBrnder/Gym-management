package com.example.JSF_HYGL.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data //lombok 自动生成set get toString 注解
public class User {
    @NotNull//id不为空 需在使用加@Validate
    Integer id;
    String username;
    @JsonIgnore//让springmvc把当前对象转换为Jason字符串的时候，忽略password,个人中心返回值时忽略password
    String password;
    Integer old;
    String xinbie;
    Integer phone;
    LocalDateTime ruhuirq;
    Boolean isadmin=false;
    String touxiang;//用户头像地址

}
