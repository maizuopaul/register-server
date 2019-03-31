package com.leeo.register.server;

public class ServiceInstance {

    /**
     * 服务实例id
     */
    private String serviceInstanceId;

    /**
     * 服务实例ip
     */
    private String serviceInstanceIp;

    /**
     * 服务实例端口号
     */
    private String serviceInstancePort;

    /**
     * 服务实例主机名
     */
    private String serviceInstanceHostname;

    /**
     * 最近更新时间
     */
    private String lasttime;

    public String getServiceInstanceId() {
        return serviceInstanceId;
    }

    public void setServiceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
    }

    public String getServiceInstanceIp() {
        return serviceInstanceIp;
    }

    public void setServiceInstanceIp(String serviceInstanceIp) {
        this.serviceInstanceIp = serviceInstanceIp;
    }

    public String getServiceInstancePort() {
        return serviceInstancePort;
    }

    public void setServiceInstancePort(String serviceInstancePort) {
        this.serviceInstancePort = serviceInstancePort;
    }

    public String getServiceInstanceHostname() {
        return serviceInstanceHostname;
    }

    public void setServiceInstanceHostname(String serviceInstanceHostname) {
        this.serviceInstanceHostname = serviceInstanceHostname;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}
