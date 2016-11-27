package com.ifreedom.beauty.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eavawu on 4/28/16.
 */
public class HttpResult<T> {
    private int resultCode;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    private Map<String, T> data = new HashMap<>();

    @Override
    public String toString() {
        return "HttpResult{" +
                "resultCode=" + resultCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
