package com.hand.hiot.infra.mapper;

import com.hand.hiot.domain.entity.Item;
import com.hand.hiot.domain.entity.OrderVo;
import io.choerodon.mybatis.common.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Mapper
 */

@Component
public interface ItemMapper extends BaseMapper<Item> {

     Long getIdByCode(String itemCode);
     String getCodeById(Long itemId);
     String getDescById(Long itemId);
    List<Item> getItems(@Param("itemCode") String itemCode, @Param("itemDescription") String itemDescription);
}
