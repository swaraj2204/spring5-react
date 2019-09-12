package com.clari5.entity;

public class DbInfo {

    private String userName;
    private String password;
    private String schema;
    private Integer maxPool;
    private Long timeout;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Integer getMaxPool() {
        return maxPool;
    }

    public void setMaxPool(Integer maxPool) {
        this.maxPool = maxPool;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
