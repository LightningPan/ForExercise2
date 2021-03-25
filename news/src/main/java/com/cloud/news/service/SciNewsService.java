package com.cloud.news.service;

import com.cloud.news.entity.SciNews;
import com.cloud.news.mapper.SciNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SciNewsService {
    @Autowired
    SciNewsMapper snMapper;

    public int deleteByPrimaryKey(String id){
        return snMapper.deleteByPrimaryKey(id);
    }

    public int insert(SciNews sciNews){
        return snMapper.insert(sciNews);
    }

    public SciNews selectByPrimaryKey(String id){
        return snMapper.selectByPrimaryKey(id);
    }

    public List<SciNews> selectAll(){
        return snMapper.selectAll();
    }

    public int updateByPrimaryKey(SciNews sciNews){
        return snMapper.updateByPrimaryKey(sciNews);
    }

    public List<SciNews> selectByUserId(String id){
        return snMapper.selectByUserId(id);
    }
}