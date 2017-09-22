package com.abtswiath.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by longx on 2017/9/22.
 */

public class User1 implements Parcelable {

    private int id;

    private String name;

    private boolean isMan;

    public User1(int id, String name, boolean isMan) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(isMan ? 1 : 0);
    }

    private User1(Parcel in) {
        id = in.readInt();
        name = in.readString();
        isMan = in.readInt() == 1;
    }

    public static final Parcelable.Creator<User1> CREATOR = new Parcelable.Creator<User1>() {
        @Override
        public User1 createFromParcel(Parcel in) {
            return new User1(in);
        }

        @Override
        public User1[] newArray(int size) {
            return new User1[size];
        }
    };
}
