package com.ebay.services;

import com.ebay.mappers.ReCommissionMapper;
import com.ebay.models.ReCommission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReCommissionService {
    @Autowired
    private ReCommissionMapper mapper;

    public ReCommission findById(Integer id) {
        return mapper.findById(id);
    }

    public List<ReCommission> getReCommissionList(Integer userId, Integer fromUserId, Integer isDelete, Integer page, Integer size) {
        Integer start = null;
        if (page != null)
            start = (page - 1) * size;
        return mapper.getReCommissionList(userId,fromUserId,isDelete,start,size);
    }

    public int count(Integer userId,Integer fromUserId,Integer isDelete) {
        return mapper.count(userId,fromUserId,isDelete);
    }

    public int insert(ReCommission reCommission) {
        return mapper.insert(reCommission);
    }

    public int update(ReCommission reCommission) {
        return mapper.update(reCommission);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }
}
