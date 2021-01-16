package com.data.manager.service;

import com.data.manager.dao.CommonMapper;
import com.data.manager.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: tianyong
 * @time: 2021/1/16 15:56
 * @description: 数据处理业务层
 */
@Service
public class BrokenService {

    @Autowired
    private CommonMapper commonMapper;


    /**
      * @author: tianyong
      * @time: 2021/1/16 15:57
      * @description: 首页数据
      */
    public List<Map<String,Object>> PageData(){
        String sql = "SELECT p.id,p.name,p.phone,m.content,m.createtime " +
                "FROM mark m left join people p on m.pid = p.id " +
                "WHERE (SELECT COUNT(1) FROM mark WHERE m.pid = pid AND m.createtime < createtime) < 1 " +
                "ORDER BY pid,m.createtime DESC";
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 16:14
      * @description: 查询数据
      */
    public List<Map<String,Object>> searchData(String star,String day,String content){
        String sql = "SELECT p.id,p.name,p.phone,m.content,m.createtime " +
                "FROM mark m left join people p on m.pid = p.id " +
                "WHERE (SELECT COUNT(1) FROM mark WHERE m.pid = pid AND m.createtime < createtime) < 1 " +
                "and p.star = "+star+" and m.content like '%"+content+"%' and datediff(now(),m.createtime) < "+day+
                " ORDER BY pid,m.createtime DESC";
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 15:58
      * @description: 客户数据
      */
    public List<Map<String,Object>> peopleData(String id){
        String sql = "select id,name,phone,star,gongjijin,home,car,baodan,shebao,save,createtime from people where id = "+id+"";
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 15:58
      * @description: 信息记录详情
      */
    public List<Map<String,Object>> getContent(){
        String sql = "select id,pid,content,createtime from mark";
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 16:00
      * @description: 增加信息记录
      */
    public List<Map<String,Object>> addContent(Mark mark){
        String sql = "insert into mark (pid,content,createtime) value ("+mark.getPid()+","+mark.getContent()+","+new Date()+")";
        return commonMapper.queryDataForList(sql);
    }

}
