package com.ebay.controllers;

import com.ebay.common.Result;
import com.ebay.common.utils.BeanUtil;
import com.ebay.models.User;
import com.ebay.services.UserService;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xc on 2018/9/5.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String name, String password){
        User user = null;
        String message = "";
        String success = "";
        if(StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)){
            success = "failed";
            message = "用户名和密码不能为空";
            }else{
            user = service.findByName(name);
            if(null == user){
                success = "failed";
                message = "用户不存在";
            }else{
                if(password.equals(user.getPassword())){
                    success = "success";
                    message = "登录成功";
                }else{
                    success = "failed";
                    message = "密码有误";
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", message);
        return Result.success();
    }

    //列表
    @RequestMapping("/list")
    @ResponseBody
    public Result getUserList(Integer status,Integer isDelete,Integer page,Integer size) {
        List<User> list = service.getUserList(status,isDelete,page,size);
        int count=service.count(status,isDelete);
        return Result.build().put("list", list).put("count", count).result();
    }

    //前端奖励金明细用户列表
    @RequestMapping("/getAuditList")
    @ResponseBody
    public Result getAuditList(Integer status,Integer isDelete) {
        List<User> userList = service.getAuditUserList(status);
        int count = service.count(status,isDelete);
        return Result.build().put("userList", userList).put("count", count).result();
    }

    //新增
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(User user) {
        service.insert(user);
        return Result.success();
    }

    //更新基础信息
    @RequestMapping("/update")
    @ResponseBody
    public Result update(User user) {
        User old = service.findById(user.getId());
        BeanUtil.copyNotNullBean(user, old);
        int r = service.update(old);
        return Result.success();
    }

    //主键查询
    @RequestMapping("/findById")
    @ResponseBody
    public Result findById(int id) {
        User user = service.findById(id);
        return Result.success(user);
    }

    //逻辑删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id, Integer flag) {
        if (flag != null && flag == 1) {
            service.deleteById(id);
        } else {
            User old = service.findById(id);
            //初始状态为删除
            old.setIsDelete(1);
            int r = service.update(old);
        }
        return Result.success();
    }

    //用户审核
    @RequestMapping("/audit")
    @ResponseBody
    public Result audit(int id,int status) {
        User user = service.findById(id);
        user.setStatus(status);
        int r = service.update(user);
        return Result.success();
    }

    //每个上级的下级用户列表
    @RequestMapping("/countSUser")
    @ResponseBody
    public Result countSUser(Integer pUserId) {
        List<User> userList = service.getSUserList(pUserId);
        return Result.success(userList);
    }


}
