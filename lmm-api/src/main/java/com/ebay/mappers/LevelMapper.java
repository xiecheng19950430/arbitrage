package com.ebay.mappers;

import com.ebay.models.Level;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LevelMapper {

    Level findById(@Param("id") int id);

    List<Level> getLevelList(@Param("isDelete") Integer isDelete,
                           @Param("level") String level,
                           @Param("scale") Float scale,
                           @Param("start") Integer start,
                           @Param("size") Integer size);

    int count(@Param("isDelete") Integer isDelete,@Param("level") String level,@Param("scale") Float scale);

    int insert(Level level);

    int update(Level level);

    @Delete("delete from level where id=#{id}")
    Integer deleteById(@Param("id") Integer id);


}
