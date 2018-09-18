package com.ebay.services;

import com.ebay.mappers.LevelMapper;
import com.ebay.models.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    private LevelMapper mapper;

    public Level findById(Integer id) {
        return mapper.findById(id);
    }

    public List<Level> getLevelList(Integer isDelete,String level, Float scale, Integer page, Integer size) {
        Integer start = null;
        if (page != null)
            start = (page - 1) * size;
        return mapper.getLevelList(isDelete,level,scale,start,size);
    }

    public int count(Integer isDelete,String level, Float scale) {
        return mapper.count(isDelete,level,scale);
    }

    public int insert(Level level) {
        return mapper.insert(level);
    }

    public int update(Level level) {
        return mapper.update(level);
    }

    public int deleteById(int id){
        return mapper.deleteById(id);
    }


}
