package com.xyhsoft.loganalyst.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Record {
    @Indexed
    private String level;
    @Indexed
    private Long timestamp;
    private String main;
    private String message;
    private JavaClassInfo loggerName;
    private String fileName;
    private String method;
    private Integer lineNumber;
    @Field("class")
    private JavaClassInfo clazz;
    private HostInfo host;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JavaClassInfo getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(JavaClassInfo loggerName) {
        this.loggerName = loggerName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public JavaClassInfo getClazz() {
        return clazz;
    }

    public void setClazz(JavaClassInfo clazz) {
        this.clazz = clazz;
    }

    public HostInfo getHost() {
        return host;
    }

    public void setHost(HostInfo host) {
        this.host = host;
    }
}
