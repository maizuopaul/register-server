package com.leeo.register.server;

public class ServiceInstance {

    private static final long ALIVE_TIME_BEHIND = 3000;

    public ServiceInstance(){
        this.lease = new Lease();
    }

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
     * 契约 维护服务和注册表的关系
     */
    private Lease lease;

    private class Lease{

        private long lastUpdateTime = System.currentTimeMillis();

        public void renew(){
            lastUpdateTime = System.currentTimeMillis();
        }

    }



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


    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public void renew(){
        this.lease.renew();
    }
    public long getLastUpdateTime(){
        return this.lease.lastUpdateTime;
    }

    /**
     * 判断服务是否存活
     * @return
     */
    public boolean isAlive(){
        return System.currentTimeMillis() - this.getLastUpdateTime() < ALIVE_TIME_BEHIND;
    }

}
