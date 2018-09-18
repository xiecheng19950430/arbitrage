package com.ebay.services;

import com.ebay.mappers.OrderMapper;
import com.ebay.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderMapper mapper;

    public int insert(Order order){
        return mapper.insert(order);
    }

    public List<Order> getOrderList(String orderNo, Float orderAmount, Integer orderStatus, Integer orderType, Integer payType, String tradeNo,
                                    String outTradeNo, Date payTime, String dateFrom, String dateTo, Integer page, Integer size){
        return mapper.getOrderList(orderNo,orderAmount,orderStatus,orderType,payType,tradeNo,outTradeNo,payTime,
                dateFrom,dateTo,(page - 1) * size,size);
    }

    public List<Order> getSUserOrderList(Integer userId) {
        return mapper.getSUserOrderList(userId);
    }

    public int count(String orderNo, Float orderAmount,Integer orderStatus, Integer orderType, Integer payType, String tradeNo,
                     String outTradeNo,Date payTime, String dateFrom, String dateTo){
        return mapper.count(orderNo,orderAmount,orderStatus,orderType,payType,tradeNo,outTradeNo,payTime,dateFrom,dateTo);
    }

   public Order findById(int id){
        return mapper.findById(id);
    }

    public Order findUserById(int id){
        return mapper.findUserById(id);
    }

    //用于直接支付的订单
    public Order createPayOrder(Integer userId,Integer orderType, String orderNo,
                                Float orderAmount, Integer payType, String tradeNo, String outTradeNo, Integer accountId){
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setOrderStatus(1);
        order.setOrderType(orderType);
        order.setOrderAmount(orderAmount);
        order.setPayType(payType);
        order.setTradeNo(tradeNo);
        order.setOutTradeNo(outTradeNo);
        order.setAccountId(accountId);
        return order;
    }

    public int countOrder(Integer userId) {
        return mapper.countOrder(userId);
    }
}
