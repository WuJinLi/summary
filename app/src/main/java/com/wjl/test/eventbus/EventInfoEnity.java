package com.wjl.test.eventbus;

/**
 * author: WuJinLi
 * time  : 2018/12/17
 * desc  : 事件总成实体信息类
 */
public class EventInfoEnity {
    private String name;
    private int age;
    private String male;
    private String address;


    public EventInfoEnity() {
    }

    public EventInfoEnity(String name, int age, String male, String address) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "name"+this.name+"   age"+this.age+" male"+this.male+"    address"+this.address;
    }
}
