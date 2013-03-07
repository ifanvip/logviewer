package com.xyhsoft.loganalyst.domain;

import org.springframework.data.mongodb.core.mapping.Field;

@Field
public class HostInfo {
    private String process;
    private String name;
    private String ip;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
