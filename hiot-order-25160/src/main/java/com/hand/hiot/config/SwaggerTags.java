package com.hand.hiot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerTags {

    public static final String EXAMPLE = "Example";
    public static final String COMPANY = "Company";
    public static final String CUSTOMER = "Customer";
    public static final String ITEM = "Item";
    public static final String ORDER = "Order";
    public static final String ORDERDETAIL = "OrderDetail";
    public static final String ORDERLEAD = "OrderLead";

    @Autowired
    public SwaggerTags(Docket docket) {
        docket.tags(
                new Tag(EXAMPLE, "EXAMPLE 案例"),
                new Tag(COMPANY,"公司信息"),
                new Tag(CUSTOMER,"客户信息"),
                new Tag(ORDER,"订单汇总信息"),
                new Tag(ORDERDETAIL,"订单明细信息"),
                new Tag(ORDERLEAD,"录入订单信息"),
                new Tag(ITEM,"物料信息")
        );
    }

    }


