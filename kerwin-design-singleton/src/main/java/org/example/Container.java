package org.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Container {

    private Container() {}

    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public static Object getInstance(String className){
        if(!ioc.containsKey(className)){
            Object instance = null;
            try {
                synchronized (ioc){
                    if(ioc.containsKey(className)){
                        instance = ioc.get(className);
                    }else{
                        instance = Class.forName(className).newInstance();
                        ioc.put(className,instance);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return instance;
        }else {
            return ioc.get(className);
        }
    }
}
