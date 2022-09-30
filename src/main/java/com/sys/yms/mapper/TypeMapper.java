package com.sys.yms.mapper;

import com.sys.yms.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypeMapper {
    //查询所有商品类型
    List<Type> findAllType();

    /**
     * 带条件的分页查询
     * @param typeName 类型名称：若为null，则为不带条件的分页查询
     * @param startIndex 起始记录的索引
     * @param limit 每页的数据量（起始索引的偏移量）
     * @return
     */
    List<Type> findTypesByPage(@Param("n") String typeName,
                               @Param("s") Integer startIndex,
                               @Param("l") Integer limit
                               );


    /**
     * 向type数据表插入数据
     * @param type 封装了要被插入到数据库当中的值
     * @return
     */
    Integer insertType(Type type);
    //修改状态
    Integer updateStateById(@Param("id") Integer id,@Param("typeState") Integer typeState);

    //修改整行数据
    Integer updateTypeById(Type type);

    //删除数据
    Integer deleteTypeById(Integer id);

    //查询数据量
    Integer findCount(String typeName);
}
