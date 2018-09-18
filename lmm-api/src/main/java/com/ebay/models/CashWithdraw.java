package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xc on 2018/9/5.
 */

@Data

public class CashWithdraw {
    private Integer id;

    //所属结算账号Id
    private Integer accountId;
    //用户Id
    private Integer userId;
    //提现流水号
    private String serialNo;
    //提现金额
    private Float amount;
    //状态，1已提现，0待提现
    private Integer status;
    //是否删除,1是，0否
    private Integer isDelete;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;
}
