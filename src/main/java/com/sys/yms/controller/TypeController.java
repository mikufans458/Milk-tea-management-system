package com.sys.yms.controller;

import com.sys.yms.entity.Type;
import com.sys.yms.service.TypeService;
import com.sys.yms.util.ResponseCode;
import com.sys.yms.util.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Resource
    TypeService typeService;

    @GetMapping("/getByPage")
    @ResponseBody
    //page和limit是layui发送的分页参数
    public ResponseData showTypesByPage(String typeName,Integer page,Integer limit)
    {
        //分页获取数据
        List<Type> typesByPage = typeService.getTypesByPage(typeName, page, limit);
        //获取数据量
        Integer count= typeService.getCount(typeName);
        //返回响应数据
        return new ResponseData(ResponseCode.SUCCESS,typesByPage,count);
    }

    @PostMapping("/addType")
    @ResponseBody
    public ResponseData addType(String typeName,String imageName)
    {
        //拼接路径
        String tImageUrl="/images/typeImg/"+imageName+".png";
        Type type=new Type();
        type.setTypeName(typeName);
        type.settImageUrl(tImageUrl);
        Integer rows= typeService.addType(type);
        //判断返回值
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_2);
        }
    }

    @PostMapping("/updateState")
    @ResponseBody
    //Integer会自动将字符串装换成int类型。前端传回的数据都是字符串
    public ResponseData updateState(Integer id,Integer typeState)
    {
        Integer rows=typeService.updateStateById(id,typeState);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }

    @RequestMapping("/updateType")
    @ResponseBody
    public ResponseData updateTypeById(Integer id,String typeName,String imageName)
    {
        //拼接路径
        String tImageUrl="/images/typeImg/"+imageName+".png";
        Type type=new Type();
        type.setId(id);
        type.setTypeName(typeName);
        type.settImageUrl(tImageUrl);
        Integer rows= typeService.updateType(type);
        //判断返回值
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_3);
        }
    }

    @PostMapping("/delType")
    @ResponseBody
    public ResponseData deleteTypeById(Integer id)
    {
        Integer rows= typeService.deleteTypeById(id);
        if(rows>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        else {
            return new ResponseData(ResponseCode.ERROR_4);
        }
    }

    @PostMapping("/getAllType")
    @ResponseBody
    public ResponseData getAllTypeName()
    {
        List<Type> allType = typeService.getAllType();
        return new ResponseData(ResponseCode.SUCCESS,allType);
    }
}
