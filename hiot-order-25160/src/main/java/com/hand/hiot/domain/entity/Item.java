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
@Table(name = "hiot_item_25160")
@Entity
public class Item{

    public static final String ITEM_ID = "itemId";
    public static final String ITEM_CODE = "itemCode";
    public static final String ITEM_UOM = "itemUom";
    public static final String ITEM_DESCRIPTION = "itemDescription";
    public static final String SALEABLE_FLAG = "saleableFlag";
    public static final String START_ACTIVE_DATE = "startActiveDate";
    public static final String END_ACTIVE_DATE = "endActiveDate";
    public static final String ENABLED_FLAG = "enabledFlag";
    public static final String OBJECT_VERSION_NUMBER= "objectVersionNumber";
    public static final String CREATION_DATE = "creationDate";
    public static final String CREATED_BY = "createdBy";
    public static final String LAST_UPDATED_BY = "lastUpdatedBy";
    public static final String LAST_UPDATED_DATE= "lastUpdateDate";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long itemId;

    @ApiModelProperty(value = "物料编码")
    @NotBlank
    @Length(max = 60)
    private String itemCode;

    @ApiModelProperty(value = "物料单位")
    @NotBlank
    @Length(max = 60)
    private String itemUom;

    @ApiModelProperty(value = "物料描述")
    @NotBlank
    @Length(max = 240)
    private String itemDescription;

    @ApiModelProperty(value = "可销售标识")
    @NotNull
    @Range(max = 1)
    private int  saleableFlag;

    @ApiModelProperty(value = "生效起始时间")
    private Date startActiveDate;


    @ApiModelProperty(value = "生效结束时间")
    private Date endActiveDate;

    @ApiModelProperty(value = "启用标识")
    @NotNull
    @Range(max = 1)
    private int  enabledFlag;

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemUom() {
        return itemUom;
    }

    public void setItemUom(String itemUom) {
        this.itemUom = itemUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getSaleableFlag() {
        return saleableFlag;
    }

    public void setSaleableFlag(int saleableFlag) {
        this.saleableFlag = saleableFlag;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
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
        return "Item{" +
                "itemId=" + itemId +
                ", itemCode='" + itemCode + '\'' +
                ", itemUom='" + itemUom + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", saleableFlag=" + saleableFlag +
                ", startActiveDate=" + startActiveDate +
                ", endActiveDate=" + endActiveDate +
                ", enabledFlag=" + enabledFlag +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
