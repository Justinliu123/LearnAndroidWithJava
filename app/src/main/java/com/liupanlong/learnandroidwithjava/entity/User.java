package com.liupanlong.learnandroidwithjava.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Parcelable, Serializable {
    private String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User(Parcel source) {
        name = source.readString();
        sex = source.readString();
        age = source.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(sex);
        parcel.writeInt(age);
    }
    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {
        @Override
        // 解构的参数顺序必须和writeToParcel的设置顺序一致
        public User createFromParcel(Parcel source){
            return new User(source);
        }
        @Override
        public User[] newArray(int size){
            return new User[size];
        }

    };
}
