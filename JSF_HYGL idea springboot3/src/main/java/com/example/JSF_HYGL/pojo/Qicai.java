package com.example.JSF_HYGL.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Qicai { //Category 对标文章分类
    Integer id;

    @NotEmpty
    String qcname;
    @NotNull
    Integer jiage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime goumaitime;


}
