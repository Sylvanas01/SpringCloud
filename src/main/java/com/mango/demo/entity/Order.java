package com.mango.demo.entity;

import java.util.Date;

public class Order {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String telephone;
    private Date commitTime;
    private String setmealType;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getSetmealType() {
        return setmealType;
    }

    public void setSetmealType(String setmealType) {
        this.setmealType = setmealType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", commitTime='" + commitTime + '\'' +
                ", setmealType='" + setmealType + '\'' +
                '}';
    }
}
