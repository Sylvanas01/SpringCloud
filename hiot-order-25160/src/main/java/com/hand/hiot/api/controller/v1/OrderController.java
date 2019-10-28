package com.hand.hiot.api.controller.v1;

import com.hand.hiot.app.service.*;
import com.hand.hiot.config.SwaggerTags;
import com.hand.hiot.domain.entity.*;
import com.hand.hiot.infra.mapper.OrderDetailMapper;
import com.netflix.discovery.converters.Auto;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hzero.boot.platform.lov.dto.LovValueDTO;
import org.hzero.core.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.boot.platform.lov.adapter.LovAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.hzero.boot.platform.code.builder.CodeRuleBuilder;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * API接口
 */
@Api(tags = SwaggerTags.ORDER)
@RestController("orderController.v1")
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private CodeRuleBuilder codeRuleBuilder;

    @ApiOperation(value = "查询订单汇总信息")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)

    @GetMapping("/v1/orders")
    public ResponseEntity<List<OrderVo>> getOrders(
            @ApiParam(value = "订单编号") @RequestParam(value = "orderNumber", required = false) String orderNumber,
            @ApiParam(value = "订单状态") @RequestParam(value = "orderStatus", required = false) String orderStatus,
            @ApiParam(value = "下订单的客户所在公司ID") @RequestParam(value = "companyId", required = false) Long companyId,
            @ApiParam(value = "下订单的客户ID") @RequestParam(value = "customerId", required = false) Long customerId,
            @ApiParam(value = "包含的物料ID") @RequestParam(value = "itemId", required = false) Long itemId) {
        List<OrderVo> orderVoList = orderService.getOrders(orderNumber, orderStatus, companyId, customerId, itemId);
        for (OrderVo orderVo : orderVoList) {
            BigDecimal sumAmount = new BigDecimal(0);
            List<OrderDetail> orderDetailList = orderDetailService.getLineById(orderVo.getSoHeaderId());
            for (OrderDetail orderDetail : orderDetailList) {
                //保留两位小数
                sumAmount = orderDetail.getOrderQuantity().multiply(orderDetail.getUnitSellingPrice()).add(sumAmount)
                        .setScale(2,BigDecimal.ROUND_HALF_UP);
            }
            orderVo.setOrderAmount(sumAmount);
        }
        return Results.success(orderVoList);
    }


    @ApiOperation(value = "录入订单信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @PostMapping("/v1/Addorders")
    public ResponseEntity addOrders(
            @ApiParam(value = "订单信息", required = true) @RequestBody List<Order> orderList) {
        for (Order order : orderList) {
            order.setOrderNumber(codeRuleBuilder.generateCode((long) 127,"HIOT-ORDER-25160",
                    "GLOBAL","GLOBAL",null));
            orderService.addOrders(order);
        }
        return Results.success();
    }

    @ApiOperation(value = "修改订单状态")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @PutMapping("/v1/updateorders")
    public ResponseEntity updateOrder(
            @ApiParam(value = "订单头id",required = true) @RequestParam(value = "soHeaderId", required = false) Long soHeaderId,
            @ApiParam(value = "订单状态",required = true) @RequestParam(value = "orderStatus", required = false) String orderStatus){
        orderService.updateOrder(soHeaderId,orderStatus);
        return Results.success();
    }

    @ApiOperation(value = "导出订单信息")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @GetMapping(value = "/v1/ExportOrders", consumes = "application/octet-stream;charset=utf-8")
    public ModelAndView exportOrders(
            @ApiParam(value = "订单编号") @RequestParam(value = "orderNumber", required = false) String orderNumber,
            @ApiParam(value = "订单状态") @RequestParam(value = "orderStatus", required = false) String orderStatus,
            @ApiParam(value = "下订单的客户所在公司ID") @RequestParam(value = "companyId", required = false) Long companyId,
            @ApiParam(value = "下订单的客户ID") @RequestParam(value = "customerId", required = false) Long customerId,
            @ApiParam(value = "包含的物料ID") @RequestParam(value = "itemId", required = false) Long itemId) {
        List<OrderVo> orderVoList = orderService.getOrders(orderNumber, orderStatus, companyId, customerId, itemId);
        //导出的数据
        List<OrderExport> orderExportList = new ArrayList<>();
        //遍历查出来的订单汇总信息
        for (OrderVo orderVo : orderVoList) {
            BigDecimal orderAmount = new BigDecimal(0);
            List<OrderDetail> orderDetailList = orderDetailService.getLineById(orderVo.getSoHeaderId());
            String nameById = companyService.getNameById(orderVo.getCompanyId());
            String nameById1 = customerService.getNameById(orderVo.getCustomerId());

            //获取每一个订单的总金额
            for(OrderDetail orderDetail1 : orderDetailList) {
                orderAmount = orderDetail1.getOrderQuantity().multiply(orderDetail1.getUnitSellingPrice()).add(orderAmount)
                        .setScale(2,BigDecimal.ROUND_HALF_UP);
            }

            //遍历订单详细信息
            for (OrderDetail orderDetail : orderDetailList) {
                OrderExport orderExport = new OrderExport();
                //开始把数据往导出里插入
                orderExport.setOrderNumber(orderVo.getOrderNumber());
                orderExport.setCompanyName(nameById);
                orderExport.setCustomerName(nameById1);
                orderExport.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").format(orderVo.getOrderDate()));
                //meaning
                String o=orderVo.getOrderStatus().toString();
                orderExport.setOrderStatus(orderVo.getOrderStatus());
                //继续插入
                orderExport.setLineAmount(orderDetail.getOrderQuantity().multiply(orderDetail.getUnitSellingPrice())
                        .setScale(2,BigDecimal.ROUND_HALF_UP));
                orderExport.setLineNumber(orderDetail.getLineNumber());
                orderExport.setItemCode(itemService.getCodeById(orderDetail.getItemId()));
                orderExport.setDescription(orderDetail.getDescription());
                orderExport.setOrderQuantity(orderDetail.getOrderQuantity());
                orderExport.setOrderQuantityUom(orderDetail.getOrderQuantityUom());
                orderExport.setUnitSellingPrice(orderDetail.getUnitSellingPrice());
                orderExport.setOrderAmount(orderAmount);

                orderExportList.add(orderExport);
            }
        }

        ExportOrder exportOrder = new ExportOrder();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hiot-order-25160", orderExportList);
        return new ModelAndView(exportOrder,map);
    }

}

