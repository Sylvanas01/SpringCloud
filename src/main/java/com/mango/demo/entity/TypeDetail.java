package com.mango.demo.entity;

public class TypeDetail {

    private int id;
    private int typeId;
    private String detailCode;
    private String detailValue;
    private int delFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public String getDetailValue() {
        return detailValue;
    }

    public void setDetailValue(String detailValue) {
        this.detailValue = detailValue;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "TypeDetail{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", detailCode='" + detailCode + '\'' +
                ", detailValue='" + detailValue + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
