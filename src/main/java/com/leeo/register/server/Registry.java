package com.leeo.register.server;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Registry  implements Serializable {

    /**
     * 保存注册表信息
     */

    private Map<String,Map<String,ServiceInstance>> registry = new HashMap<String, Map<String, ServiceInstance>>();


    private static Registry instance = new Registry();


    private Registry(){}

    public static Registry getInstance(){ return instance;}


    public void register(String serviceName,ServiceInstance serviceInstance){

        Map<String, ServiceInstance> serviceInstanceMap = registry.get(serviceName);

        if(null == serviceInstanceMap){
            serviceInstanceMap = new HashMap<String, ServiceInstance>();
        }

        serviceInstanceMap.put(serviceInstance.getServiceInstanceId(),serviceInstance);

    }

    public void heartbeat(String serviceName,String serviceInstanceId){
        ServiceInstance serviceInstance = getServiceInstance(serviceName, serviceInstanceId);
        serviceInstance.renew();
    }

    public void offline(String serviceName,String serviceInstanceId){
        Map<String, ServiceInstance> serviceInstanceMap = registry.get(serviceName);
        serviceInstanceMap.remove(serviceInstanceId);
    }

    public void offline(String serviceName, ServiceInstance instance){
        Map<String, ServiceInstance> serviceInstanceMap = registry.get(serviceName);
        serviceInstanceMap.remove(instance.getServiceInstanceId());
    }

    public ServiceInstance getServiceInstance(String serviceName,String serviceInstanceId){
        Map<String, ServiceInstance> serviceInstanceMap = registry.get(serviceName);
        return serviceInstanceMap.get(serviceInstanceId);
    }


    public Map<String,Map<String,ServiceInstance>> getRegistry(){
        return registry;
    }

}
