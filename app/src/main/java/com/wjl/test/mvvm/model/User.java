package com.wjl.test.mvvm.model;

/**
 * author: WuJinLi
 * time  : 2018/12/19
 * desc  :
 */
public class User {
    private String name;
    private String age;


    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
