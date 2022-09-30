package com.sys.yms.service;

import com.sys.yms.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeService {
    List<Type> getAllType();

    /**
     *
     * @param typeName
     * @param cPage 当前页
     * @param pSize 数据量
     * @return
     */
    //带条件的分页查询
    List<Type> getTypesByPage( String typeName, Integer cPage, Integer pSize);

    //添加数据
    Integer addType(Type type);

    /**
     * 根据id修改状态
     * @param id
     * @param typeState
     * @return
     */
    Integer updateStateById(Integer id,Integer typeState);

    Integer updateType(Type type);

    Integer deleteTypeById(Integer id);
    Integer getCount(String typeName);
}
