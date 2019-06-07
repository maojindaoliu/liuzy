package com.liuy.vip;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService helloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String liu_zhouyu = helloService.sayHello("liu zhouyu");

        System.out.println(liu_zhouyu);
    }
}
