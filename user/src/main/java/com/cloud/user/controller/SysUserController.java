package com.cloud.user.controller;

import com.cloud.user.entity.SysUser;
import com.cloud.user.service.NewsClient;
import com.cloud.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private NewsClient newsClient;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public int insertUser(@RequestBody SysUser sysUser){
        return sysUserService.insert(sysUser);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable String id){
        return sysUserService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "update" , method = RequestMethod.PUT)
    public int updateUser(@RequestBody SysUser sysUser){
        return sysUserService.updateByPrimaryKey(sysUser);
    }

    @RequestMapping(value = "getUser/{id}" , method = RequestMethod.GET)
    public SysUser selectByPrimaryKey(@PathVariable String id){
        SysUser ans=sysUserService.selectByPrimaryKey(id);
        ans.setSciNews(newsClient.getAllNews(id));
        return ans;
    }

    @RequestMapping(value = "getAllUsers" , method = RequestMethod.GET)
    public List<SysUser> selectAll(){
        return sysUserService.selectAll();
    }
}
