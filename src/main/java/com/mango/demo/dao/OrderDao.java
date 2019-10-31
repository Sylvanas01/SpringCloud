package com.mango.demo.dao;

import com.mango.demo.entity.Order;
import com.mango.demo.entity.Suppiler;

import java.util.List;

public interface OrderDao {
   int addOrder(Order order);
}