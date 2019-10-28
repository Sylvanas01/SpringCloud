package com.hand.hiot.app.service;


import com.hand.hiot.domain.entity.OrderDetail;
import com.hand.hiot.domain.entity.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * ExampleService
 */
public interface OrderDetailService {
    List<OrderDetail> getLineById( Long soHeaderId);

    int addorderDetails(OrderDetail orderDetail);
    int getLine();
    void updateDetails(Long soLineId, Long itemId, BigDecimal orderQuantity, String orderQuantityUom, Long unitSellingPrice);
}
