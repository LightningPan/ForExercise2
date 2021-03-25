package com.cloud.news.controller;

import com.cloud.news.entity.SciNews;
import com.cloud.news.service.SciNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class SciNewsController {
    @Autowired
    private SciNewsService sciNewsService;

    @RequestMapping(value = "getNews/{id}", method = RequestMethod.GET)
    public SciNews getNews(@PathVariable String id){
        return sciNewsService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "getAllNews", method = RequestMethod.GET)
    public List<SciNews> getAllNews(){
        return sciNewsService.selectAll();
    }

    @RequestMapping(value = "deleteNews/{id}", method = RequestMethod.DELETE)
    public int deleteNews(@PathVariable String id){
        return sciNewsService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "insert" , method = RequestMethod.POST)
    public int insertNews(@RequestBody SciNews sciNews){
        return sciNewsService.insert(sciNews);
    }

    @RequestMapping(value = "update" , method = RequestMethod.PUT)
    public int updateNews(@RequestBody SciNews sciNews){
        return sciNewsService.updateByPrimaryKey(sciNews);
    }

    @RequestMapping(value = "getByUserId/{id}" , method = RequestMethod.GET)
    public List<SciNews> selectByUserId(@PathVariable String id){
        return sciNewsService.selectByUserId(id);
    }
}