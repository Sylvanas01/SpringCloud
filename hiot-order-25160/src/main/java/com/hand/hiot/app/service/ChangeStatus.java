package com.hand.hiot.app.service;

import com.hand.hiot.domain.entity.OrderVo;
import com.hand.hiot.infra.mapper.OrderMapper;
import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@JobHandler("HIOT-ORDER-25160")
public class ChangeStatus implements IJobHandler {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
         List<OrderVo> orderVoList=orderMapper.getOrders(
                 null,"已审核",
                 null,null,null);
         for(OrderVo orderVo: orderVoList){
             orderMapper.updateOrder(orderVo.getSoHeaderId(),"已关闭");
         }
         System.out.println("********************关闭订单**************************");
        return ReturnT.SUCCESS;
    }
}
