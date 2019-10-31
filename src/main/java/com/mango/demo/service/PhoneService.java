package com.mango.demo.service;

import com.mango.demo.dao.OrderDao;
import com.mango.demo.dao.PhoneDao;
import com.mango.demo.entity.Message;
import com.mango.demo.entity.MessagePhone;
import com.mango.demo.entity.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PhoneService {
    @Resource
    private PhoneDao phoneDao;

    public int addMessagePhone(MessagePhone messagePhone){
        return phoneDao.addMessagePhone(messagePhone);
    }
}
