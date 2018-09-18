package com.ebay.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xc on 2018/9/5.
 */

@Data

public class Level {
    private Integer id;

    //等级
    private String level;
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

