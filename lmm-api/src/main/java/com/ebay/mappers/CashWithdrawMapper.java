package com.ebay.mappers;

import com.ebay.models.CashWithdraw;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CashWithdrawMapper {


    CashWithdraw findById(@Param("id") int id);

    List<CashWithdraw> getCashWithdrawList(@Param("userId") Integer userId,
                                           @Param("status") Integer status,
                                           @Param("accountId") Integer accountId,
                                           @Param("isDelete") Integer isDelete,
                                           @Param("start") Integer start,
                                           @Param("size") Integer size);

    List<CashWithdraw> getWithdrawUserList(@Param("userId") Integer userId);

    int count(@Param("userId") Integer userId,
              @Param("status") Integer status,
              @Param("accountId") Integer accountId,
              @Param("isDelete") Integer isDelete);

    int insert(CashWithdraw cashWithdraw);

    int update(CashWithdraw cashWithdraw);

    @Delete("delete from cashwithdraw where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}
