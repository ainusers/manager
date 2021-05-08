package com.data.manager.controller;

import com.data.manager.dao.CustomMapper;
import com.data.manager.entity.Mark;
import com.data.manager.service.BrokenService;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: tianyong
 * @Date: 2020/bootstrap-3.3.4/13 16:47
 * @Description: 生成license接口
 */
@Controller
public class BrokenApi {


    @Autowired
    private BrokenService brokenService;
    @Autowired
    private CustomMapper customMapper;


    /* 变量 */
    private static Logger log = LogManager.getLogger(BrokenApi.class);


    /**
      * @author: tianyong
      * @time: 2021/1/16 17:03
      * @description:
      */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/pageData")
    public Map<String,Object> PageData(int page,int limit){
        Map<String,Object> res = new HashMap(1);
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> list = brokenService.PageData();
        res.put("code",0);
        res.put("count",list.size());
        res.put("data",list);
        return res;
    }
    /**
     * @author: tianyong
     * @time: 2021/1/16 17:03
     * @description:
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/commonData")
    public Map<String,Object> CommonData(int page,int limit,String content){
        Map<String,Object> res = new HashMap(1);
        PageHelper.startPage(page,limit);
        List<LinkedHashMap<String, Object>> list = customMapper.queryDataForSortList(content);
        res.put("code",0);
        res.put("count",list.size());
        res.put("data",list);
        return res;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/searchData")
    public Map<String,Object> searchData(int page,int limit,String star,String day,String money,String home,String car,String baodan,String shebao,String content){
        Map<String,Object> res = new HashMap(1);
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> list = brokenService.searchData(star, day, money, home, car, baodan, shebao, content);
        res.put("code",0);
        res.put("count",list.size());
        res.put("data",list);
        return res;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/peopleData")
    public List<Map<String,Object>> peopleData(String id){
        return brokenService.peopleData(id);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getContent")
    public List<Map<String,Object>> getContent(String pid){
        return brokenService.getContent(pid);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addContent")
    public List<Map<String,Object>> addContent(String pid,String content){
        return brokenService.addContent(pid,content);
    }



    /*
     * @Author: tianyong
     * @Date: 2020/12/29 15:08
     * @Description: 动态请求页面
     */
    @CrossOrigin
    @GetMapping("/{page}")
    public String goPage(@PathVariable("page") String page){
        return page;
    }


}
