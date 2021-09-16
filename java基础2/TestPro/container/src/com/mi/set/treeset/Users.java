package com.mi.set.treeset;

public class Users implements Comparable<Users>{
    // alt+insert -> 自动生成getter/setter
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

    // 通过元素自身实现：元素需实现Comparable接口的compareTo方法 -> 聚焦返回值：正数，位置不变； 负数，移动前面; 0: 位置不变
    @Override
    public int compareTo(Users o) {
        if(this.age > o.getAge()) {
            return 1;
        }
        if(this.age == o.getAge()) {
            return this.username.compareTo(o.getUsername());
        }
        return -1;
    }
}