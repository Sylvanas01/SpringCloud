package com.hand.hiot.infra.mapper;

import com.hand.hiot.domain.entity.OrderDetail;
import com.hand.hiot.domain.entity.OrderVo;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Mapper
 */

@Component
public interface OrderDetailMapper extends BaseMapper<OrderVo> {
    List<OrderDetail> getLineById(@Param("soHeaderId") Long soHeaderId);

    int addorderDetails(OrderDetail orderDetail);

    int getLine();
    void updateDetails(Long soLineId, Long itemId, BigDecimal orderQuantity, String orderQuantityUom, Long unitSellingPrice);
}
