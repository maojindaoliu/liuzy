package com.liuy.vip;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @auther liuy
 * @description 网络传输类
 * @date 2019/6/7
 **/
public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest rpcRequest) throws IOException {
        Socket socket = null;

        Object result = null;

        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            socket = new Socket(host,port);//建立连接

            outputStream = new ObjectOutputStream(socket.getOutputStream());//网络socket
            outputStream.writeObject(rpcRequest);
            outputStream.flush();

            inputStream  = new ObjectInputStream(socket.getInputStream());
            result = inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if ( inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
        return result;
    }

}
