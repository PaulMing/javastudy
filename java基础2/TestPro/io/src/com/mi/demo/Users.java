package com.mi.demo;

import java.io.Serializable;
// Serializable接口：空接口
public class Users implements Serializable {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Users(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // toString()
    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}