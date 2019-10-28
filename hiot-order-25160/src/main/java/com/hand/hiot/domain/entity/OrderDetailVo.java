package com.hand.hiot.domain.entity;


import io.swagger.annotations.ApiModelProperty;
import org.hzero.boot.platform.lov.annotation.LovValue;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 */
@Entity
public class OrderDetailVo<OrderStatus> {
    public static final String ORDER_NUMBER = "orderNumber";
    public static final String COMPANY_NUMBER = "companyNumber";
    public static final String ORDER_DATE = "orderDate";
    public static final String ORDER_STATUS = "orderStatus";
    public static final String CUSTOMER_NUMBER = "customerNumber";
    public static final String LINE_NUMBER = "lineNumber";
    public static final String ITEM_CODE = "itemCode";
    public static final String ORDER_QUANTITY = "orderQuantity";
    public static final String ORDER_QUANTITY_UOM = "orderQuantityUom";
    public static final String UNIT_SELLING_PRICE= "unitSellingPrice";
    public static final String DESCRIPTION = "description";
    public static final String ADDITION1= "addition1";
    public static final String ADDITION2 = "addition2";
    public static final String ADDITION3= "addition3";
    public static final String ADDITION4 = "addition4";
    public static final String ADDITION5= "addition5";


    private String orderNumber;
    private String companyNumber;
    private Date orderDate;


    private String orderStatus;
    private String customerNumber;
    private int lineNumber;
    private String itemCode;
    private BigDecimal orderQuantity;
    private String orderQuantityUom;
    private BigDecimal unitSellingPrice;
    private String description;
    private String addition1;
    private String addition2;
    private String addition3;
    private String addition4;
    private String addition5;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(BigDecimal unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "orderNumber='" + orderNumber + '\'' +
                ", companyNumber='" + companyNumber + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", lineNumber=" + lineNumber +
                ", itemCode='" + itemCode + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", description='" + description + '\'' +
                ", addition1='" + addition1 + '\'' +
                ", addition2='" + addition2 + '\'' +
                ", addition3='" + addition3 + '\'' +
                ", addition4='" + addition4 + '\'' +
                ", addition5='" + addition5 + '\'' +
                '}';
    }
}
