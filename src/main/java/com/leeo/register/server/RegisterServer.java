package com.leeo.register.server;

import java.util.HashMap;
import java.util.Map;

public class RegisterServer {

    private Map<String,Map<String, ServiceInstance>> registory = new HashMap<String,Map<String, ServiceInstance>>();

    private static final RegisterServer server = new RegisterServer();

    private RegisterServer(){}

    private RegisterServer getInstance(){
        return server;
    }


    /**
     * 注册服务类后台线程
     */
    private class Deamon extends  Thread{
        @Override
        public void run() {
        }
    }
}
