package com.leeo.register.server;

import java.util.Map;
import java.util.Set;

public class RegistryMonitor {

    private static final RegistryMonitor moniter = new RegistryMonitor();

    private Registry registry = Registry.getInstance();

    private RegistryMonitor(){}

    public static RegistryMonitor getMoniter(){return moniter;}


    /**
     * 启动注册表监听线程
     */
    public void startMonitor(){
        startCheckServiceInstanceIsAliveThread();
    }

    private void startCheckServiceInstanceIsAliveThread(){
        Deamon deamon = new Deamon();
        deamon.setDaemon(true);
        deamon.start();
    }

    private class Deamon extends Thread{
        @Override
        public void run() {

            while (true){
                try{
                    Map<String, Map<String, ServiceInstance>> registry2 = registry.getRegistry();

                    if(null != registry2){

                        Set<Map.Entry<String, Map<String, ServiceInstance>>> entries = registry2.entrySet();

                        for (Map.Entry<String, Map<String, ServiceInstance>> entry:entries ) {

                            String serviceName = entry.getKey();
                            Map<String, ServiceInstance> serviceInstanceMap = entry.getValue();
                            Set<String> serviceInstanceIds = serviceInstanceMap.keySet();

                            for (String serviceInstanceId: serviceInstanceIds){
                                ServiceInstance serviceInstance = serviceInstanceMap.get(serviceInstanceId);

                                if (!serviceInstance.isAlive()){
                                    registry.offline(serviceName, serviceInstanceId);
                                }
                            }
                        }

                    }

                    Thread.sleep(30000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        }
    }
}
