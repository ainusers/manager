package com.data.manager.entity;

import java.io.Serializable;

/**
 * @author: tianyong
 * @time: 2021/1/16 16:05
 * @description: 记录信息表
 */
public class Mark implements Serializable {

    private Integer id;
    private Integer pid;
    private String content;
    private String createtime;

    public Mark() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
