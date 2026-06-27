package com.example.JSF_HYGL.Controller;

import com.example.JSF_HYGL.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        //把文件内容存储到本地磁盘上
        String originalFilename=file.getOriginalFilename();
        //保证文件的名字是唯有的，防止文件覆盖
        String filename= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("E:\\vue3\\jsf\\src\\assets\\touxiang\\"+filename));
        return Result.success("url访问地址...");


    }
}
