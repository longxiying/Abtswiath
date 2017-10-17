package com.abtswiath.bean;

import java.io.Serializable;

/**
 * Created by longx on 2017/10/17.
 */

public class Result<T> implements Serializable {

    private String code;
    private boolean charge;
    private String msg;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

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

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", charge=" + charge +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
