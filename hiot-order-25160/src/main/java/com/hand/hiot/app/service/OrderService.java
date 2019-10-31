package com.hand.hiot.app.service;


import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Order;
import com.hand.hiot.domain.entity.OrderVo;

import java.util.List;

/**
 * ExampleService
 */
public interface OrderService {

   List<OrderVo> getOrders(String orderNumber, String orderStatus, Long companyId, Long customerId, Long itemId);

   int addOrders(Order order);
   Long findHeadId(String OrderNumber);
   int ifHaveHeadId(String orderNumber);
   int  updateOrder(Long soHeaderId,String orderStatus);
}
