package com.woniu.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName: com.woniu.pojo
 * @ClassName: Customer
 * @Author: liuchen
 * @Date: 2020/1/15 11:14
 * @Description: //TODO
 */
public class Customer implements Serializable {
    private Integer id;
    private String name;
    private String linkman;
    private Integer phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
