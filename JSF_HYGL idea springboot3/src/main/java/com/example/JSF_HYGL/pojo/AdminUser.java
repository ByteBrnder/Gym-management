package com.example.JSF_HYGL.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminUser {
    @NotNull//id不为空 需在使用加@Validate
    Integer id;
    String username;
    String password;
    Integer old;
    String xinbie;
    Integer phone;
    LocalDateTime ruhuirq;
    Boolean isadmin=false;

}
