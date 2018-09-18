package com.ebay.mappers;

import com.ebay.models.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {

    Account findById(@Param("id") int id);

    List<Account> getAccountList(@Param("userId") Integer userId,
                                 @Param("isDelete") Integer isDelete,
                                 @Param("start") Integer start,
                                 @Param("size") Integer size);

    int count(@Param("userId") Integer userId, @Param("isDelete") Integer isDelete);

    int insert(Account account);

    int update(Account account);

    @Delete("delete from account where id=#{id}")
    Integer deleteById(@Param("id") Integer id);
}