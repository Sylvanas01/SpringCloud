package com.hand.hiot.app.service;


import com.hand.hiot.domain.entity.Customer;
import com.hand.hiot.domain.entity.Item;

import java.util.List;

/**
 * ExampleService
 */
public interface ItemService {

    Long getIdByCode(String itemCode);
    String getCodeById(Long itemId);
    String getDescById(Long itemId);
    List<Item> getItems(String itemCode,String itemDescription);
}
