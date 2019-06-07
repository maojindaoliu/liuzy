package com.liuy.vip;

import java.io.Serializable;

/**
 * @auther liuy
 * @description 请求参数
 * @date 2019/6/7
 **/
public class RpcRequest implements Serializable {

    private String className;

    private String methosName;

    private Object[] parameters;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethosName() {
        return methosName;
    }

    public void setMethosName(String methosName) {
        this.methosName = methosName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
