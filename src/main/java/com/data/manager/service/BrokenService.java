package com.data.manager.service;

import com.data.manager.dao.CommonMapper;
import com.data.manager.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    public List<Map<String,Object>> searchData(String star,String day,String money,String home,String car,String baodan,String shebao,String content){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.id,p.name,p.phone,m.content,m.createtime FROM mark m left join people p on m.pid = p.id  WHERE (SELECT COUNT(1) FROM mark WHERE m.pid = pid AND m.createtime < createtime) < 1 ");
        if(!money.isEmpty()){
            sql.append(" and p.money = "+money);
        }
        if(!home.isEmpty()){
            sql.append(" and p.home = "+home);
        }
        if(!car.isEmpty()){
            sql.append(" and p.car = "+car);
        }
        if(!baodan.isEmpty()){
            sql.append(" and p.baodan = "+baodan);
        }
        if(!shebao.isEmpty()){
            sql.append(" and p.shebao = " + shebao);
        }
        if(!star.isEmpty()){
            sql.append(" and p.star = " + star);
        }
        if(!day.isEmpty()){
            sql.append(" and datediff(now(),m.createtime) < "+ day);
        }
        sql.append(" and m.content like '%"+content+"%' ORDER BY pid,m.createtime DESC");
        return commonMapper.queryDataForList(String.valueOf(sql));
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 15:58
      * @description: 客户数据
      */
    public List<Map<String,Object>> peopleData(String id){
        String sql = "select id,name,phone,star,money,home,car,baodan,shebao,save,createtime from people where id = "+id+"";
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 15:58
      * @description: 信息记录详情
      */
    public List<Map<String,Object>> getContent(String pid){
        String sql = "select id,pid,content,createtime from mark where pid = " + pid;
        return commonMapper.queryDataForList(sql);
    }


    /**
      * @author: tianyong
      * @time: 2021/1/16 16:00
      * @description: 增加信息记录
      */
    public List<Map<String,Object>> addContent(String pid,String content){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        String sql = "insert into mark (pid,content,createtime) value ("+pid+",'"+content+"','"+date+"')";
        return commonMapper.queryDataForList(sql);
    }

}
