package com.ebay.services;

import com.ebay.mappers.AccountMapper;
import com.ebay.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper mapper;

    public Account findById(Integer id) {
        return mapper.findById(id);
    }

    public List<Account> getAccountList(Integer userId, Integer isDelete, Integer page, Integer size) {
        Integer start = null;
        if (page != null)
            start = (page - 1) * size;
        return mapper.getAccountList(userId,isDelete,start,size);
    }

    public int count(Integer userId, Integer isDelete) {
        return mapper.count(userId,isDelete);
    }

    public int insert(Account account) {
        return mapper.insert(account);
    }

    public int update(Account account) {
        return mapper.update(account);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }

}
