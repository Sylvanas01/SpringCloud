package com.hand.hiot.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hzero.boot.platform.lov.annotation.LovValue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 实体
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "hiot_so_header_25160")
@Entity
public class Order {

    public static final String SO_HEADER_ID = "soHeaderId";
    public static final String ORDER_NUMBER = "orderNumber";
    public static final String COMPANY_ID = "companyId";
    public static final String ORDER_DATE = "orderDate";
    public static final String ORDER_STATUS = "orderStatus";
    public static final String CUSTOMER_ID = "customerId";
    public static final String OBJECT_VERSION_NUMBER= "objectVersionNumber";
    public static final String CREATION_DATE = "creationDate";
    public static final String CREATED_BY = "createdBy";
    public static final String LAST_UPDATED_BY = "lastUpdatedBy";
    public static final String LAST_UPDATED_DATE= "lastUpdateDate";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long soHeaderId;

    @ApiModelProperty(value = "订单编号")
    @NotBlank
    @Length(max = 60)
    private String orderNumber;

    @ApiModelProperty(value = "公司ID")
    @NotNull
    @Length(max = 20)
    private Long companyId;

    @ApiModelProperty(value = "订单日期")
    @NotBlank
    @Length(max = 20)
    private Date orderDate;



    @LovValue(lovCode = "HIOT-ORDER_STATUS-25160-2")
    @ApiModelProperty(value = "订单状态")
    @NotBlank
    @Length(max = 30)
    private String orderStatus;
    private String orderStatusMeaning;

    @ApiModelProperty(value = "订单人")
    @NotNull
    @Length(max = 30)
    private Long  customerId;

    @ApiModelProperty(value = "版本号")
    @NotNull
    @Range(max = 20)
    private Long objectVersionNumber;

    @ApiModelProperty(value = "创建时间")
    @NotBlank
    private Date creationDate;

    @ApiModelProperty(value = "创建人ID")
    @NotNull
    @Length(max = 20)
    private Long createdBy;

    @ApiModelProperty(value = "最后更新人ID")
    @NotNull
    @Length(max = 20)
    private Long lastUpdatedBy;


    @ApiModelProperty(value = "最后更新时间")
    @NotBlank
    private Date lastUpdateDate;

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getOrderStatusMeaning() {
        return orderStatusMeaning;
    }

    public void setOrderStatusMeaning(String orderStatusMeaning) {
        this.orderStatusMeaning = orderStatusMeaning;
    }

    @Override
    public String toString() {
        return "Order{" +
                "soHeaderId=" + soHeaderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", customerId=" + customerId +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
