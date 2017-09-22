package com.abtswiath.bean;

import java.io.Serializable;

/**
 * Created by longx on 2017/9/22.
 */

public class User implements Serializable {

    private static final long serialVersionUID = 241241L;

    private int id;

    private String name;

    private boolean isMan;

    public User(){

    }

    public User(int id, String name, boolean isMan) {
        this.id = id;
        this.name = name;
        this.isMan = isMan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }
}
