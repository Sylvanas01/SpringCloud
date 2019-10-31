package com.hand.hiot.app.service.impl;


import com.hand.hiot.app.service.OrderService;
import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Order;
import com.hand.hiot.domain.entity.OrderVo;
import com.hand.hiot.infra.mapper.CustomerMapper;
import com.hand.hiot.infra.mapper.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExampleServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    public  List<OrderVo> getOrders(String orderNumber, String orderStatus, Long companyId, Long customerId, Long itemId){

        return  orderMapper.getOrders(orderNumber,orderStatus,companyId,customerId,itemId);
    }

    public int addOrders(Order order){

        return orderMapper.addOrders(order);
    }

    public Long findHeadId(String OrderNumber){
        return orderMapper.findHeadId(OrderNumber);
    }

    public int ifHaveHeadId(String orderNumber){
        return orderMapper.ifHaveHeadId(orderNumber);
    }

    public int  updateOrder(Long soHeaderId,String orderStatus){
        return orderMapper.updateOrder(soHeaderId,orderStatus);
    }
    }

