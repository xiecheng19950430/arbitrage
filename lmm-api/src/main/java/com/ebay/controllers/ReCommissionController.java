package com.ebay.controllers;

import com.ebay.common.Result;
import com.ebay.common.utils.BeanUtil;
import com.ebay.models.*;
import com.ebay.services.LevelService;
import com.ebay.services.OrderService;
import com.ebay.services.ReCommissionService;
import com.ebay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xc on 2018/9/10.
 */
@Controller
@RequestMapping("/recommission")
public class ReCommissionController {
    @Autowired
    private ReCommissionService reCommissionService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private LevelService levelService;

    //列表
    @RequestMapping("/list")
    @ResponseBody
    public Result getReCommissionList(Integer userId, Integer fromUserId, Integer isDelete, Integer page, Integer size) {
        List<ReCommission> list = reCommissionService.getReCommissionList(userId,fromUserId,isDelete,page,size);
        int count=reCommissionService.count(userId,fromUserId,isDelete);
        return Result.build().put("list", list).put("count", count).result();
    }

    //新增
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(ReCommission reCommission) {
        reCommissionService.insert(reCommission);
        return Result.success();
    }

    //更新基础信息
    @RequestMapping("/update")
    @ResponseBody
    public Result update(ReCommission reCommission) {
        ReCommission old = reCommissionService.findById(reCommission.getId());
        BeanUtil.copyNotNullBean(reCommission, old);
        int r = reCommissionService.update(old);
        return Result.success();
    }

    //主键查询
    @RequestMapping("/findById")
    @ResponseBody
    public Result findById(int id) {
        ReCommission reCommission = reCommissionService.findById(id);
        return Result.success(reCommission);
    }

    //逻辑删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id, Integer flag) {
        if (flag != null && flag == 1) {
            reCommissionService.deleteById(id);
        } else {
            ReCommission old = reCommissionService.findById(id);
            //初始状态为删除
            old.setIsDelete(1);
            int r = reCommissionService.update(old);
        }
        return Result.success();
    }

    //返佣账单计算
    @RequestMapping("/count")
    @ResponseBody
    public Result count(Integer id) {
        Order order = orderService.findUserById(id);
        User user = userService.findById(order.getUserId());
        User pUser = userService.findById(user.getPUserId());
        Level level = levelService.findById(pUser.getLevelId());
        float reAmount = level.getScale()*order.getOrderAmount();
        return Result.success(reAmount);
    }


}
