package com.ebay.mappers;

import com.ebay.models.ReCommission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReCommissionMapper {

    ReCommission findById(@Param("id") int id);

    List<ReCommission> getReCommissionList(@Param("userId") Integer userId,
                                           @Param("fromUserId") Integer fromUserId,
                                           @Param("isDelete") Integer isDelete,
                                           @Param("start") Integer start,
                                           @Param("size") Integer size);

    int count(@Param("userId") Integer userId,@Param("fromUserId") Integer fromUserId,@Param("isDelete") Integer isDelete);

    int insert(ReCommission reCommission);

    int update(ReCommission reCommission);

    @Delete("delete from recommission where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

}
