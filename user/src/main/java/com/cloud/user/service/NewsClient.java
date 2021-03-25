package com.cloud.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("news")
@RequestMapping("/news")
public interface NewsClient {
    @RequestMapping("/getByUserId/{id}")
    List<Object> getAllNews(@PathVariable String id);
}
