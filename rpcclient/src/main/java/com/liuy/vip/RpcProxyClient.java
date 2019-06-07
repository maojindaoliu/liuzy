package com.liuy.vip;

import java.lang.reflect.Proxy;

/**
 * @auther liuy
 * @description 客户端代理
 * @date 2019/6/7
 **/
public class RpcProxyClient {
    public <T>  T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},
                new RemoteInvocationHandler(host,port));
    }
}
