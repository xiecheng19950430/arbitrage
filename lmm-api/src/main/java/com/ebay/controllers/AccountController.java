package com.ebay.controllers;

import com.ebay.common.Result;
import com.ebay.common.utils.BeanUtil;
import com.ebay.models.Account;
import com.ebay.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xc on 2018/9/8.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //列表
    @RequestMapping("/list")
    @ResponseBody
    public Result getAccountList(Integer userId, Integer isDelete, Integer page, Integer size) {
        List<Account> list = accountService.getAccountList(userId,isDelete,page,size);
        int count=accountService.count(userId,isDelete);
        return Result.build().put("list", list).put("count", count).result();
    }

    //新增
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(Account account) {
        accountService.insert(account);
        return Result.success();
    }

    //更新基础信息
    @RequestMapping("/update")
    @ResponseBody
    public Result update(Account account) {
        Account old = accountService.findById(account.getId());
        BeanUtil.copyNotNullBean(account, old);
        int r = accountService.update(old);
        return Result.success();
    }

    //主键查询
    @RequestMapping("/findById")
    @ResponseBody
    public Result findById(int id) {
        Account account = accountService.findById(id);
        return Result.success(account);
    }

    //逻辑删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id, Integer flag) {
        if (flag != null && flag == 1) {
            accountService.deleteById(id);
        } else {
            Account old = accountService.findById(id);
            //初始状态为删除
            old.setIsDelete(1);
            int r = accountService.update(old);
        }
        return Result.success();
    }
}
