package com.lzh.firstboot.domain;

import org.springframework.data.annotation.Id;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/26 ${Time}.
 * Customer的描述：${DESCRIPTION}
 */

public class Customer {

    @Id
    private String cid;
    private String firstname;
    private String secondname;

    public Customer() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}
