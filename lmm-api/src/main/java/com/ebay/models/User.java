package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

/**
 * Created by xc on 2018/9/5.
 */

@Data

public class User {
    private Integer id;

    //上级用户Id
    private Integer pUserId;
    //姓名
    private String name;
    //手机号
    private String phone;
    //密码
    private String password;
    //等级Id
    private Integer levelId;
    //佣金
    private Float commission;
    //是否审核，-1未通过，1已审核，0待审核，2未认证
    private Integer status;
    //是否删除，1是，0否
    private Integer isDelete;
    //身份证正面照片
    private String frontCard;
    //身份证反面照片
    private String oppositeCard;
    //审核人
    private String auditName;
    //等级
    private String level;
    //佣金比例
    private Float scale;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    private List<Order> orderList;
}

