package com.leeo.register.server;

public class RegisterServerController {

    Registry registry = Registry.getInstance();


    /**
     * 请求服务注册
     * @param request
     */
    public RegisterResponse register(RegisterRequest request){
        ServiceInstance serviceInstance = new ServiceInstance();
        serviceInstance.setServiceInstanceId(request.getServiceId());
        serviceInstance.setServiceInstanceIp(request.getServiceIp());
        serviceInstance.setServiceInstanceHostname(request.getServiceName());
        serviceInstance.setServiceInstanceHostname(request.getServiceHostname());

        RegisterResponse response= new RegisterResponse();

        registry.register(request.getServiceName(),serviceInstance);
        response.setCode(RegisterResponse.SUCCESS);

        return response;
    }


    /**
     * 请求心跳，更新契约
     * @param serviceName
     * @param serviceInstanceId
     */
    public void heartbeat(String serviceName,String serviceInstanceId){
        registry.heartbeat(serviceName,serviceInstanceId);
    }
}
