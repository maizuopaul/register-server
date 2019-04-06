package com.leeo.register.server;


import java.io.Serializable;

/**
 * 服务注册响应信息
 */
public class RegisterResponse implements Serializable {
    
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
