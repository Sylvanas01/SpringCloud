package com.hand.hiot.app.service.impl;

import com.hand.hiot.app.service.CustomerService;
import com.hand.hiot.app.service.ItemService;
import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Item;
import com.hand.hiot.domain.entity.OrderVo;
import com.hand.hiot.infra.mapper.CustomerMapper;
import com.hand.hiot.infra.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ExampleServiceImpl
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemMapper itemMapper;
   public Long getIdByCode(String itemCode){
      return itemMapper.getIdByCode(itemCode);
   }
    public  String getCodeById(Long itemId){
        return itemMapper.getCodeById(itemId);
    }
    public  String getDescById(Long itemId){
        return itemMapper.getDescById(itemId);
    }
    public   List<Item> getItems(String itemCode,String itemDescription){
       return itemMapper.getItems(itemCode,itemDescription);
    }

}

