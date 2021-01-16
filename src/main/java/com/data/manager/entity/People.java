package com.data.manager.entity;

import java.io.Serializable;

/**
 * @author: tianyong
 * @time: 2021/1/16 16:05
 * @description: 记录信息表
 */
public class People implements Serializable {

    private Integer id;
    private String name;
    private String phone;
    private String star;
    private String gongjijin;
    private String home;
    private String car;
    private String baodan;
    private String shebao;
    private String save;
    private String createtime;

    public People() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getGongjijin() {
        return gongjijin;
    }

    public void setGongjijin(String gongjijin) {
        this.gongjijin = gongjijin;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getBaodan() {
        return baodan;
    }

    public void setBaodan(String baodan) {
        this.baodan = baodan;
    }

    public String getShebao() {
        return shebao;
    }

    public void setShebao(String shebao) {
        this.shebao = shebao;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
