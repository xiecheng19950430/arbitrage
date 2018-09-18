package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xc on 2018/9/5.
 */
@Data

public class Account {
    private Integer id;

    //用户Id
    private Integer userId;
    //银行卡号
    private String bankcardNum;
    //身份证号
    private String cardId;
    //姓名
    private String name;
    //预留手机号
    private String reservedPhone;
    //是否删除，1是，0否
    private Integer isDelete;

    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}
