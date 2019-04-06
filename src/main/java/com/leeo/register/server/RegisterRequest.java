package com.leeo.register.server;


import java.io.Serializable;

public class RegisterRequest implements Serializable {


    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务id
     */
    private String serviceId;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getServicePort() {
        return servicePort;
    }

    public void setServicePort(String servicePort) {
        this.servicePort = servicePort;
    }

    public String getServiceHostname() {
        return serviceHostname;
    }

    public void setServiceHostname(String serviceHostname) {
        this.serviceHostname = serviceHostname;
    }

    /**
     * 服务的IP
     */
    private String serviceIp;

    /**
     * 服务的端口
     */
    private String servicePort;

    /**
     * 服务的主机名
     */
    private String serviceHostname;


}
