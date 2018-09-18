package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xc on 2018/9/5.
 */

@Data

public class ReCommission {
    private Integer id;

    //订单流水号
    private String orderNo;
    //获取返佣用户Id
    private Integer userId;
    //订单用户Id,即哪个用户产生的订单
    private Integer fromUserId;
    //当前返佣金额
    private Float reAmount;
    //订单金额
    private Float orderAmount;
    //佣金比例
    private Float scale;
    //是否删除，1是，0否
    private Integer isDelete;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}

