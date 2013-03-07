package com.xyhsoft.loganalyst.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Appinfo {
    private String name;
    private String version;
    private Date createDate;
    private String contact;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "["+name+","+version+"]";
    }
}
