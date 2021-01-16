package com.data.manager.controller;

import com.data.manager.entity.Mark;
import com.data.manager.service.BrokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/*
 * @Author: tianyong
 * @Date: 2020/7/13 16:47
 * @Description: 生成license接口
 */
@Controller
public class BrokenApi {


    @Autowired
    private BrokenService brokenService;


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
    public List<Map<String,Object>> PageData(){
        return brokenService.PageData();
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/searchData")
    public List<Map<String,Object>> searchData(String star,String day,String content){
        return brokenService.searchData(star,day,content);
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
    public List<Map<String,Object>> getContent(){
        return brokenService.getContent();
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/addContent")
    public List<Map<String,Object>> addContent(Mark mark){
        return brokenService.addContent(mark);
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
