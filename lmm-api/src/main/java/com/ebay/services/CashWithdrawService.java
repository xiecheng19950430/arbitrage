package com.ebay.services;

import com.ebay.mappers.CashWithdrawMapper;
import com.ebay.models.CashWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashWithdrawService {

    @Autowired
    private CashWithdrawMapper mapper;

    public CashWithdraw findById(Integer id) {
        return mapper.findById(id);
    }

    public List<CashWithdraw> getCashWithdrawList(Integer userId,Integer accountId,Integer status, Integer isDelete, Integer page, Integer size) {
        Integer start = null;
        if (page != null)
            start = (page - 1) * size;
        return mapper.getCashWithdrawList(userId,accountId,status,isDelete,start,size);
    }

    public List<CashWithdraw> getWithdrawUserList(Integer userId) {
        return mapper.getWithdrawUserList(userId);
    }

    public int count(Integer userId,Integer accountId,Integer status, Integer isDelete) {
        return mapper.count(userId,accountId,status,isDelete);
    }

    public int insert(CashWithdraw cashWithdraw) {
        return mapper.insert(cashWithdraw);
    }

    public int update(CashWithdraw cashWithdraw) {
        return mapper.update(cashWithdraw);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }
}
