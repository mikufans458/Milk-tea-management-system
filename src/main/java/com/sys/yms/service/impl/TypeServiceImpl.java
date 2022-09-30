package com.sys.yms.service.impl;

import com.sys.yms.entity.Type;
import com.sys.yms.mapper.TypeMapper;
import com.sys.yms.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    TypeMapper typeMapper;
    @Override
    public List<Type> getAllType() {
        return typeMapper.findAllType();
    }

    @Override
    public List<Type> getTypesByPage(String typeName, Integer cPage, Integer pSize) {
        int  startIndex;
        startIndex=(cPage-1)*pSize;
        return typeMapper.findTypesByPage(typeName,startIndex,pSize);
    }

    @Override
    public Integer addType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public Integer updateStateById(Integer id, Integer typeState) {
        return typeMapper.updateStateById(id,typeState);
    }

    @Override
    public Integer updateType(Type type) {
        return typeMapper.updateTypeById(type);
    }

    @Override
    public Integer deleteTypeById(Integer id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public Integer getCount(String typeName) {
        return typeMapper.findCount(typeName);
    }


}
