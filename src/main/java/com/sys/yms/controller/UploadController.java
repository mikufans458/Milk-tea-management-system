package com.sys.yms.controller;

import com.sys.yms.util.ResponseCode;
import com.sys.yms.util.ResponseData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

@Controller
public class UploadController {
    @PostMapping("/upload")
    @ResponseBody
    public ResponseData uploadFile(@RequestParam("file") MultipartFile multi)
    {
        //默认为上传失败
        ResponseData rd=new ResponseData(ResponseCode.ERROR_5);
        //1、指定存储目录
        String relativeDirPath="/static/images/productImg";//相对路径
        try {
            String classesPath= ResourceUtils.getURL("classpath:").getPath();//classes目录的路径(就是编译之后的文件夹，方便浏览器拿)
            File dir = new File(classesPath + relativeDirPath);//获取存储目录的绝对路径
            if(!dir.exists()){
                dir.mkdir();//不存在则创建
            }
        //2、文件存储路径
            String fileName= UUID.randomUUID()+"_"+multi.getOriginalFilename();//获取文件名
            File file = new File(dir, fileName);
        //3、存储
            multi.transferTo(file);
        //4、将数据存入数据库
            if(file.exists())
            {
                //将文件的路径存入
                String filePathToStatic="/images/productImg/"+fileName;

                //存入数据
                rd=new ResponseData(ResponseCode.SUCCESS,filePathToStatic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rd;
    }
}
