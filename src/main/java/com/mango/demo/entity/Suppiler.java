package com.mango.demo.entity;

public class Suppiler {

    private int id;
    private String suppilerName;
    private String suppilerCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuppilerName() {
        return suppilerName;
    }

    public void setSuppilerName(String suppilerName) {
        this.suppilerName = suppilerName;
    }

    public String getSuppilerCode() {
        return suppilerCode;
    }

    public void setSuppilerCode(String suppilerCode) {
        this.suppilerCode = suppilerCode;
    }

    @Override
    public String toString() {
        return "Suppiler{" +
                "id=" + id +
                ", suppilerName='" + suppilerName + '\'' +
                ", suppilerCode='" + suppilerCode + '\'' +
                '}';
    }
}
