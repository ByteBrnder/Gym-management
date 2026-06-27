package com.example.JSF_HYGL.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class Pl {
    Integer id;
    Integer user_id;
    String pl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fabiaotime;
    @TableField(exist = false)
    String username;
}

