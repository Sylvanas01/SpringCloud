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
@Table(name = "hiot_company_25160")
@Entity
public class Customer {

    public static final String CUSTOMER_ID = "customerId";
    public static final String CUSTOMER_NUMBER = "customerNumber";
    public static final String CUSTOMER_NAME = "customerName";
    public static final String CUSTOMER_LOGO = "companyId";
    public static final String ENABLE_FLAG = "enabledFlag";
    public static final String OBJECT_VERSION_NUMBER= "objectVersionNumber";
    public static final String CREATION_DATE = "creationDate";
    public static final String CREATED_BY = "createdBy";
    public static final String LAST_UPDATED_BY = "lastUpdatedBy";
    public static final String LAST_UPDATED_DATE= "lastUpdateDate";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long customerId;

    @ApiModelProperty(value = "客户编号")
    @NotBlank
    @Length(max = 60)
    private String customerNumber;

    @ApiModelProperty(value = "客户名称")
    @NotBlank
    @Length(max = 240)
    private String customerName;

    @ApiModelProperty(value = "客户对应的公司ID")
    @NotBlank




    //TODO
    @LovValue(lovCode = "HIOT-25160-COMPANY_USER")
    @Length(max = 20)
    private Long companyId;

    @ApiModelProperty(value = "启用标志")
    @NotNull
    @Range(max = 1)
    private int enabledFlag;

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public int getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(int enabledFlag) {
        this.enabledFlag = enabledFlag;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", companyId=" + companyId +
                ", enabledFlag=" + enabledFlag +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
