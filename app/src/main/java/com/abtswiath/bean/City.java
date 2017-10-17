package com.abtswiath.bean;


import java.io.Serializable;

/**
 * Created by longx on 2017/10/17.
 */

public class City implements Serializable {

    private String citycode;//":"101291006",
    private String city;//":"巧家县",
    private String cityid;//":"3219",
    private String parentid;//":"381"

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
