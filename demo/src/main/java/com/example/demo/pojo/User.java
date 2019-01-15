package com.example.demo.pojo;

import java.util.Date;

public class User {
    private  String name;
    private  String password;
    private  String age;
    private  String desc ;
    private Date birthday;
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {

        return birthday;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getDesc() {
        return desc;
    }
}
