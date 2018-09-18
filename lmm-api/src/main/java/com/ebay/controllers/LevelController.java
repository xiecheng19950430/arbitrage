package com.ebay.controllers;

import com.ebay.common.Result;
import com.ebay.common.utils.BeanUtil;
import com.ebay.models.Level;
import com.ebay.services.LevelService;
import com.ebay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by xc on 2018/9/5.
 */
@Controller
@RequestMapping("/level")
public class LevelController {

    @Autowired
    private LevelService levelService;
    @Autowired
    private UserService userService;


    //列表
    @RequestMapping("/list")
    @ResponseBody
    public Result getLevelList(Integer isDelete, String level, Float scale, Integer page, Integer size) {
        List<Level> list = levelService.getLevelList(isDelete,level,scale,page,size);
        int count=levelService.count(isDelete,level,scale);
        return Result.build().put("list", list).put("count", count).result();
    }

    //新增
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(Level level) {
        levelService.insert(level);
        return Result.success();
    }

    //更新基础信息
    @RequestMapping("/update")
    @ResponseBody
    public Result update(Level level) {
        Level old = levelService.findById(level.getId());
        BeanUtil.copyNotNullBean(level, old);
        int r = levelService.update(old);
        return Result.success();
    }

    //主键查询
    @RequestMapping("/findById")
    @ResponseBody
    public Result findById(int id) {
        Level level = levelService.findById(id);
        return Result.success(level);
    }

    //逻辑删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id, Integer flag) {
        if (flag != null && flag == 1) {
            levelService.deleteById(id);
        } else {
            Level old = levelService.findById(id);
            //初始状态为删除
            old.setIsDelete(1);
            int r = levelService.update(old);
        }
        return Result.success();
    }

    //级别升级
    @RequestMapping("/upgrade")
    @ResponseBody
    public Result upgrade(Integer pUserId) {
        int count = userService.countUser(pUserId);
        return Result.success();
    }

}
