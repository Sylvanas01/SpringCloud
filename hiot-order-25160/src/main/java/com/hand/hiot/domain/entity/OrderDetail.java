package com.hand.hiot.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体
 */
@ModifyAudit
@VersionAudit
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "hiot_so_line_25160")
@Entity
public class OrderDetail {

    public static final String SO_LINE_ID = "soLineId";
    public static final String SO_HEADER_ID = "soHeaderId";
    public static final String LINE_NUMBER = "lineNumber";
    public static final String ITEM_ID = "itemId";
    public static final String ORDER_QUANTITY = "orderQuantity";
    public static final String ORDER_QUANTITY_UOM = "orderQuantityUom";
    public static final String UNIT_SELLING_PRICE= "unitSellingPrice";
    public static final String DESCRIPTION = "description";
    public static final String ADDITION1= "addition1";
    public static final String ADDITION2 = "addition2";
    public static final String ADDITION3= "addition3";
    public static final String ADDITION4 = "addition4";
    public static final String ADDITION5= "addition5";
    public static final String OBJECT_VERSION_NUMBER= "objectVersionNumber";
    public static final String CREATION_DATE = "creationDate";
    public static final String CREATED_BY = "createdBy";
    public static final String LAST_UPDATED_BY = "lastUpdatedBy";
    public static final String LAST_UPDATED_DATE= "lastUpdateDate";

    @ApiModelProperty("表ID，主键，供其他表做外键")
    @Id
    @GeneratedValue
    private Long soLineId;

    @ApiModelProperty(value = "订单头")
    @NotNull
    @Length(max = 20)
    private Long soHeaderId;


    @ApiModelProperty(value = "行号")
    @NotNull
    @Length(max = 10)
    private int lineNumber;

    @ApiModelProperty(value = "产品ID")
    @NotNull
    @Length(max = 20)
    private Long itemId;


    @ApiModelProperty(value = "数量")
    @NotNull
    @Length(max = 20)
    private BigDecimal orderQuantity;

    @ApiModelProperty(value = "产品单位")
    @NotBlank
    @Length(max = 60)
    private String orderQuantityUom;

    @ApiModelProperty(value = "销售单价")
    @NotNull
    @Length(max = 20)
    private BigDecimal unitSellingPrice;

    @ApiModelProperty(value = "备注")
    @Length(max = 240)
    private String description;

    @ApiModelProperty(value = "附加信息1")
    @Length(max = 150)
    private String addition1;

    @ApiModelProperty(value = "附加信息2")
    @Length(max = 150)
    private String addition2;

    @ApiModelProperty(value = "附加信息3")
    @Length(max = 150)
    private String addition3;

    @ApiModelProperty(value = "附加信息4")
    @Length(max = 150)
    private String addition4;

    @ApiModelProperty(value = "附加信息5")
    @Length(max = 150)
    private String addition5;


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

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
        return "OrderDetail{" +
                "soLineId=" + soLineId +
                ", soHeaderId=" + soHeaderId +
                ", lineNumber=" + lineNumber +
                ", itemId=" + itemId +
                ", orderQuantity=" + orderQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", description='" + description + '\'' +
                ", addition1='" + addition1 + '\'' +
                ", addition2='" + addition2 + '\'' +
                ", addition3='" + addition3 + '\'' +
                ", addition4='" + addition4 + '\'' +
                ", addition5='" + addition5 + '\'' +
                ", objectVersionNumber=" + objectVersionNumber +
                ", creationDate=" + creationDate +
                ", createdBy=" + createdBy +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}
