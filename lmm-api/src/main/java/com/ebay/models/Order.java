package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


/**
 * Created by xc on 2018/9/5.
 */

@Data

public class Order {
    private Integer id;

    //用户Id
    private Integer userId;
    //所属结算账号Id
    private Integer accountId;
    //订单流水号
    private String orderNo;
    //订单类型,1直接支付
    private Integer orderType;
    //订单金额
    private Float orderAmount;
    //状态,0待支付，1已支付
    private Integer orderStatus;
    //支付时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;
    //交易时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tradeAt;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    //支付方式
    private Integer payType;
    //交易号
    private String tradeNo;
    //外部交易号
    private String outTradeNo;
}
