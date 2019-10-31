package com.hand.hiot.infra.mapper;

import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Order;
import com.hand.hiot.domain.entity.OrderVo;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper
 */

@Component
public interface OrderMapper extends BaseMapper<OrderVo> {
    List<OrderVo> getOrders(@Param("orderNumber") String orderNumber, @Param("orderStatus") String orderStatus,
                          @Param("companyId") Long companyId, @Param("customerId") Long customerId,
                          @Param("itemId") Long itemId);

    int addOrders(Order order);

    Long findHeadId(String orderNumber);
    int ifHaveHeadId(String orderNumber);
    int updateOrder(Long soHeaderId,String orderStatus);
}
