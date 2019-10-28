package com.hand.hiot.api.controller.v1;

import com.hand.hiot.app.service.OrderDetailService;
import com.hand.hiot.config.SwaggerTags;
import com.hand.hiot.domain.entity.Order;
import com.hand.hiot.domain.entity.OrderDetail;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

/**
 * API接口
 */
@Api(tags = SwaggerTags.ORDERDETAIL)
@RestController("orderDetailController.v1")
@RequestMapping
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @ApiOperation(value = "查询订单详细信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)

    @GetMapping("/v1/orderDetail")
    public ResponseEntity<List<OrderDetail>> getOrderDetail(
            @ApiParam(value = "订单头ID") @RequestParam(value = "soHeaderId", required = false) Long soHeaderId){
      return  Results.success(orderDetailService.getLineById(soHeaderId));
    }


    @ApiOperation(value = "录入订单详情信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @PostMapping("/v1/AddorderDetails")
    public ResponseEntity addorderDetails(
            @ApiParam(value = "订单详情信息", required = true) @RequestBody List<OrderDetail> orderDetailList){
        for ( OrderDetail orderDetail : orderDetailList) {

            orderDetailService.addorderDetails(orderDetail);
        }
        return Results.success();
    }

    @ApiOperation(value = "修改订单详情信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @PutMapping("/v1/UpdateDetails")
    public ResponseEntity updateDetails(
            @ApiParam(value = "订单行id", required = true)  @RequestParam(value = "soLineId", required = false) Long soLineId,
            @ApiParam(value = "物料id") @RequestParam(value = "itemId", required = false) Long itemId,
            @ApiParam(value = "数量") @RequestParam(value = "orderQuantity", required = false) BigDecimal orderQuantity,
            @ApiParam(value = "销售单价") @RequestParam(value = "orderQuantityUom", required = false) String orderQuantityUom,
            @ApiParam(value = "金额") @RequestParam(value = "unitSellingPrice", required = false) Long unitSellingPrice){
        orderDetailService.updateDetails(soLineId,itemId,orderQuantity,orderQuantityUom,unitSellingPrice);
        return Results.success();
    }




}

