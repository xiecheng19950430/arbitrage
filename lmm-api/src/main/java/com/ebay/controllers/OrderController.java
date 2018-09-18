package com.ebay.controllers;

import com.ebay.common.Result;
import com.ebay.models.Order;
import com.ebay.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //列表
    @RequestMapping("/getOrderList")
    @ResponseBody
    public Result getOrderList(String orderNo, Float orderAmount, Integer orderStatus, Integer orderType, Integer payType, String tradeNo,
                               String outTradeNo, Date payTime, String dateFrom, String dateTo, Integer page, Integer size) {
        List<Order> list = orderService.getOrderList(orderNo, orderAmount, orderStatus,orderType, payType, tradeNo, outTradeNo,payTime,
                dateFrom, dateTo, page, size);
        int count = orderService.count(orderNo, orderAmount, orderStatus,orderType, payType, tradeNo, outTradeNo,payTime, dateFrom, dateTo);
        return Result.build().put("list", list).put("count", count).result();
    }

    //创建订单
    @RequestMapping("/createOrder")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Result createOrder(@RequestParam("userId") Integer userId,
                              @RequestParam("orderType") Integer orderType,
                              @RequestParam("orderNo") String orderNo,
                              @RequestParam("orderAmount") Float orderAmount,
                              @RequestParam("payType") Integer payType,
                              @RequestParam("tradeNo") String tradeNo,
                              @RequestParam("outTradeNo") String outTradeNo,
                              @RequestParam("accountId") Integer accountId) {
        //创建订单
        Order order = orderService.createPayOrder(userId, orderType, orderNo, orderAmount, payType, tradeNo,outTradeNo, accountId);
        orderService.insert(order);
        return Result.success(order);
    }

    //统计交易数量
    @RequestMapping("/countOrder")
    @ResponseBody
    public Result countOrder(Integer userId) {
        List<Order> list = orderService.getSUserOrderList(userId);
        return Result.success(list);
    }

}