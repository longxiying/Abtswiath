package com.abtswiath.bean;

import java.io.Serializable;

/**
 * Created by longx on 2017/10/17.
 */

public class Result1<T> implements Serializable {

    private String msg;

    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
