package com.ebay.services;

import com.ebay.mappers.UserMapper;
import com.ebay.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public User findById(Integer id) {
        return mapper.findById(id);
    }

    public User findByName(String name) {
        return mapper.findByName(name);
    }

    public List<User> getUserList(Integer status,Integer isDelete,Integer page,Integer size) {
        Integer start = null;
        if (page != null)
            start = (page - 1) * size;
        return mapper.getUserList(status,isDelete,start,size);
    }

    public List<User> getAuditUserList(Integer status) {
        return mapper.getAuditUserList(status);
    }

    public List<User> getSUserList(Integer pUserId) {
        return mapper.getSUserList(pUserId);
    }

    public int count(Integer status,Integer isDelete) {
        return mapper.count(status,isDelete);
    }

    public int countUser(Integer pUserId) {
        return mapper.countUser(pUserId);
    }

    public int insert(User user) {
        return mapper.insert(user);
    }

    public int update(User user) {
        return mapper.update(user);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }
}
