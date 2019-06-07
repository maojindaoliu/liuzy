package com.liuy.vip;

/**
 * @auther liuy
 * @description 测试类
 * @date 2019/6/7
 **/
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("request in sayHello :"+ content);
        return "say Hello:"+content;
    }

    @Override
    public void saveUser(User user) {

    }
}
