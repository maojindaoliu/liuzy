package com.liuy.vip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther liuy
 * @description 代理类
 * @date 2019/6/7
 **/
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();
    public void publisher(Object service,int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true) //接受请求
            {
                Socket socket = serverSocket.accept();
                //每一个socket
                executorService.execute(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null)
            {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
