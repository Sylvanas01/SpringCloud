package com.hand.hiot.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.hiot.domain.entity.Order;
import com.hand.hiot.domain.entity.OrderDetail;
import com.hand.hiot.domain.entity.OrderDetailVo;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.boot.platform.lov.annotation.ProcessLovValue;
import org.hzero.core.base.BaseConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@ImportService(templateCode = "HIOT-ORDER-25160")
public class ImportOrder implements IDoImportService {

    @Autowired
    private ObjectMapper objectMapper;
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

    @Override
    public Boolean doImport(String data) {
        OrderDetailVo orderDetailVo;

        try {
            orderDetailVo = objectMapper.readValue(data, OrderDetailVo.class);
        } catch (IOException e) {
            return false;
        }

        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();

        if (orderService.ifHaveHeadId(orderDetailVo.getOrderNumber())==0) {
            order.setOrderNumber(orderDetailVo.getOrderNumber());
            order.setCompanyId(companyService.getIdByNumber(orderDetailVo.getCompanyNumber()));
            order.setOrderDate(orderDetailVo.getOrderDate());
            order.setOrderStatus(orderDetailVo.getOrderStatus());
            order.setCustomerId(customerService.getIdByNumber(orderDetailVo.getCustomerNumber()));
            orderService.addOrders(order);
       //     order.getOrderStatusMeaning();
        }

            Long soHeaderId=orderService.findHeadId(orderDetailVo.getOrderNumber());
            orderDetail.setLineNumber(orderDetailVo.getLineNumber());
            orderDetail.setSoHeaderId(soHeaderId);
            orderDetail.setItemId(itemService.getIdByCode(orderDetailVo.getItemCode()));
            orderDetail.setOrderQuantity(orderDetailVo.getOrderQuantity());
            orderDetail.setOrderQuantityUom(orderDetailVo.getOrderQuantityUom());
            orderDetail.setUnitSellingPrice(orderDetailVo.getUnitSellingPrice());
            orderDetail.setDescription(orderDetailVo.getDescription());
            orderDetail.setAddition1(orderDetailVo.getAddition1());
            orderDetail.setAddition2(orderDetailVo.getAddition2());
            orderDetail.setAddition3(orderDetailVo.getAddition3());
            orderDetail.setAddition4(orderDetailVo.getAddition4());
            orderDetail.setAddition5(orderDetailVo.getAddition5());
            orderDetailService.addorderDetails(orderDetail);

            return true;

                    }
                    }