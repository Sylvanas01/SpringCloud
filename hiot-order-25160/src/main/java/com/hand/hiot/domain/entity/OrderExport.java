package com.hand.hiot.domain.entity;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hzero.boot.platform.lov.annotation.LovValue;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 */
@Entity
public class OrderExport<OrderStatus> {
    public static final String ORDER_NUMBER = "orderNumber";
    public static final String COMPANY_NAME = "companyName";
    public static final String CUSTOMER_NAME = "customerName";
    public static final String ORDER_DATE = "orderDate";
    public static final String ORDER_STATUS = "orderStatus";
    public static final String ORDER_AMOUNT = "orderAmount";
    public static final String LINE_NUMBER = "lineNumber";
    public static final String ITEM_CODE = "itemCode";
    public static final String ITEM_DESCRIPTION ="itemDescription";
    public static final String ORDER_QUANTITY = "orderQuantity";
    public static final String ORDER_QUANTITY_UOM = "orderQuantityUom";
    public static final String UNIT_SELLING_PRICE= "unitSellingPrice";
    public static final String LINE_AMOUNT = "lineAmount";
    public static final String DESCRIPTION = "description";

    private String orderNumber;
    private String companyName;
    private String customerName;
    private String orderDate;


    private String orderStatus;
    private BigDecimal orderAmount;
    private int lineNumber;
    private String itemCode;
    private BigDecimal orderQuantity;
    private String orderQuantityUom;
    private BigDecimal unitSellingPrice;
    private BigDecimal lineAmount;
    private String description;
    private String itemDescription;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
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

    public BigDecimal getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(BigDecimal lineAmount) {
        this.lineAmount = lineAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }


    @Override
    public String toString() {
        return "OrderExport{" +
                "orderNumber='" + orderNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", orderAmount=" + orderAmount +
                ", lineNumber=" + lineNumber +
                ", itemCode='" + itemCode + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", lineAmount=" + lineAmount +
                ", description='" + description + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
