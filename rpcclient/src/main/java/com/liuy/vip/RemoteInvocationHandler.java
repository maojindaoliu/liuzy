package com.liuy.vip;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther liuy
 * @description 被代理类
 * @date 2019/6/7
 **/
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in ");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethosName(method.getName());
        rpcRequest.setParameters(args);

        //调用实际的网络传输类
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host,port);
        Object result= rpcNetTransport.send(rpcRequest);
        return result;
    }
}
