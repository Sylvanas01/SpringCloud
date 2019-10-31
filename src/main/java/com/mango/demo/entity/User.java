package com.mango.demo.entity;

public class User {

    private int id;
    private String address;
    private String phone;
    private String telephone;
    private String mz;
    private String xl;
    private String time;
    private int delFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mz='" + mz + '\'' +
                ", xl='" + xl + '\'' +
                ", time='" + time + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
