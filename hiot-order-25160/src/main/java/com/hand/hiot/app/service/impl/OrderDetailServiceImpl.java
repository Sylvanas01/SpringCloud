package com.hand.hiot.app.service.impl;

import com.hand.hiot.app.service.OrderDetailService;
import com.hand.hiot.app.service.OrderService;
import com.hand.hiot.domain.entity.OrderDetail;
import com.hand.hiot.domain.entity.OrderVo;
import com.hand.hiot.infra.mapper.OrderDetailMapper;
import com.hand.hiot.infra.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * ExampleServiceImpl
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public List<OrderDetail> getLineById( Long soHeaderId){
        return orderDetailMapper.getLineById(soHeaderId);
    }

    public int addorderDetails(OrderDetail orderDetail){

        int lineNumber= orderDetailMapper.getLine()+1;
        orderDetail.setLineNumber(lineNumber);
        return orderDetailMapper.addorderDetails(orderDetail);
    }

    public int getLine(){
        return orderDetailMapper.getLine();
    }

    public  void updateDetails(Long soLineId, Long itemId, BigDecimal orderQuantity, String orderQuantityUom, Long unitSellingPrice){
      orderDetailMapper.updateDetails(soLineId,itemId,orderQuantity,orderQuantityUom,unitSellingPrice);
    }
}


