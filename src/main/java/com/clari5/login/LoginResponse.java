package com.clari5.login;

public class LoginResponse {

    private String userName;
    private String tenant;

    public LoginResponse(){}

    public LoginResponse(String userName, String tenant) {
        this.userName = userName;
        this.tenant = tenant;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
