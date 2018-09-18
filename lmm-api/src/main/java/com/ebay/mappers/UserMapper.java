package com.ebay.mappers;

import com.ebay.models.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xc on 2018/9/7.
 */
@Mapper
public interface UserMapper {

    User findById(@Param("id") int id);

    User findByName(@Param("name") String name);

    List<User> getSUserList(@Param("pUserId") Integer pUserId);

    List<User> getUserList(@Param("status") Integer status,
                           @Param("isDelete") Integer isDelete,
                           @Param("start") Integer start,
                           @Param("size") Integer size);

    List<User> getAuditUserList(@Param("status") Integer status);

    int count(@Param("status") Integer status,@Param("isDelete") Integer isDelete);

    int countUser(@Param("pUserId") Integer pUserId);

    int insert(User user);

    int update(User user);

    @Delete("delete from user where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

}
