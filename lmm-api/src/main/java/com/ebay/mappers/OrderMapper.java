package com.ebay.mappers;

import com.ebay.models.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by xc on 2018/9/7.
 */
@Mapper
public interface OrderMapper {
    int insert(Order order);

    @Select("select * from order where id=#{id}")
    @ResultMap("baseResultMap")
    Order findById(@Param("id") int id);

    @Select("select * from order where orderNo=#{orderNo}")
    @ResultMap("baseResultMap")
    Order findByOrderNo(@Param("orderNo") String orderNo);

    @Update("update order set orderStatus=1, payTime=now() where id=#{id}")
    int updateOrderSuccess(@Param("id") Integer id);

    List<Order> getOrderList(@Param("orderNo") String orderNo,
                             @Param("orderAmount") Float orderAmount,
                             @Param("orderStatus") Integer orderStatus,
                             @Param("orderType") Integer orderType,
                             @Param("payType") Integer payType,
                             @Param("tradeNo") String tradeNo,
                             @Param("outTradeNo") String outTradeNo,
                             @Param("payTime") Date payTime,
                             @Param("dateFrom") String dateFrom,
                             @Param("dateTo") String dateTo,
                             @Param("start") Integer start,
                             @Param("size") Integer size);

    List<Order> getSUserOrderList(@Param("userId") Integer UserId);

    int count(@Param("orderNo") String orderNo,
              @Param("orderAmount") Float orderAmount,
              @Param("orderStatus") Integer orderStatus,
              @Param("orderType") Integer orderType,
              @Param("payType") Integer payType,
              @Param("tradeNo") String tradeNo,
              @Param("outTradeNo") String outTradeNo,
              @Param("payTime") Date payTime,
              @Param("dateFrom") String dateFrom,
              @Param("dateTo") String dateTo);

    int countOrder(@Param("userId") Integer userId);

    Order findUserById(@Param("id") Integer id);
}
