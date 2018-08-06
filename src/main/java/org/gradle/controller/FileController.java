package org.gradle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/upload", produces = { "application/json" }, method =RequestMethod.POST )
    public  String upload(
    @RequestParam(value = "logo", required = true) MultipartFile logo,HttpServletRequest request){
    //这里的logo就是接受的文件了
    if(logo!=null){
       //进行操作吧
        System.out.println(logo.getOriginalFilename());
    }
    return "success";
}
}
