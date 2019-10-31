package com.mango.demo.entity;

public class MessagePhone {

    private int id;
    private int orderId;
    private int typeDetailId;
    private String phones;
    private String suppilerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTypeDetailId() {
        return typeDetailId;
    }

    public void setTypeDetailId(int typeDetailId) {
        this.typeDetailId = typeDetailId;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getSuppilerName() {
        return suppilerName;
    }

    public void setSuppilerName(String suppilerName) {
        this.suppilerName = suppilerName;
    }

    @Override
    public String toString() {
        return "MessagePhone{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", typeDetailId=" + typeDetailId +
                ", phones='" + phones + '\'' +
                ", suppilerName='" + suppilerName + '\'' +
                '}';
    }
}
