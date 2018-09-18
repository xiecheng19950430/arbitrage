package com.ebay.controllers;


import com.ebay.common.Result;
import com.ebay.common.utils.BeanUtil;
import com.ebay.models.CashWithdraw;
import com.ebay.services.CashWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xc on 2018/9/11.
 */
@Controller
@RequestMapping("/cashwithdraw")
public class CashWithdrawController {
    @Autowired
    private CashWithdrawService service;

    //列表
    @RequestMapping("/list")
    @ResponseBody
    public Result getCashWithdrawList(Integer userId,
                                      Integer accountId,
                                      Integer status,
                                      Integer isDelete,
                                      Integer page,
                                      Integer size) {
        //默认非删除
        if(isDelete==null)
            isDelete=0;
        //默认待提现
        if(status==null)
            status=0;
        List<CashWithdraw> list=service.getCashWithdrawList(userId,accountId,status,isDelete,page,size);
        int count=service.count(userId,accountId,status,isDelete);
        return Result.build().put("list", list).put("count", count).result();
    }

    //新增
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(CashWithdraw cashWithdraw) {
        cashWithdraw.setIsDelete(0);
        cashWithdraw.setStatus(0);
        service.insert(cashWithdraw);
        return Result.success();
    }

    //逻辑删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(int id,Integer flag) {
        if(flag!=null&&flag==1){
            service.deleteById(id);
        }else{
            CashWithdraw old = service.findById(id);
            //初始状态为删除
            old.setIsDelete(1);
            int r = service.update(old);
        }
        return Result.success();
    }


    //更新基础信息
    @RequestMapping("/update")
    @ResponseBody
    public Result update(CashWithdraw cashWithdraw) {
        CashWithdraw old = service.findById(cashWithdraw.getId());
        BeanUtil.copyNotNullBean(cashWithdraw, old);
        int r = service.update(old);
        return Result.success();
    }

    //提现
    @RequestMapping("/withdrawCash")
    @ResponseBody
    public Result withdrawCash(Integer userId) {
        List<CashWithdraw> cashWithdrawList = service.getWithdrawUserList(userId);

        return Result.success();
    }
}
