package com.mango.demo.service;

import com.mango.demo.dao.OrderDao;
import com.mango.demo.dao.TypeDetailDao;
import com.mango.demo.entity.Order;
import com.mango.demo.entity.TypeDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    public int addOrder(Order order){
       orderDao.addOrder(order);
        return order.getId();
    }
}
