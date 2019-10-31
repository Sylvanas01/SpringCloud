package com.mango.demo.controller;


import ch.qos.logback.core.joran.spi.ElementSelector;
import com.alibaba.fastjson.JSONObject;
import com.mango.demo.entity.*;
import com.mango.demo.service.OrderService;
import com.mango.demo.service.PhoneService;
import com.mango.demo.service.SuppilerService;
import com.mango.demo.service.TypeDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    private TypeDetailService typeDetailService;

    @Resource
    private SuppilerService suppilerService;

    @Resource
    private OrderService orderService;

    @Resource
    private PhoneService phoneService;

    @RequestMapping(value = "messageSubmit")
    @ResponseBody
    public String messageSubmit(OrderVo orderVo) {
        String nodeMessageStr = orderVo.getNodeMessageStr();
        JSONObject nodeMessage = JSONObject.parseObject(nodeMessageStr);
        //查询所有供应商
        List<Suppiler> suppilerList = suppilerService.getSuppiler();
        //查询所有typeDetail
        List<TypeDetail> typeDetailList = typeDetailService.findDetail();

        //存入order表
        Order order = new Order();
        order.setName(orderVo.getName());
        order.setAddress(orderVo.getAddress());
        order.setPhone(orderVo.getPhone());
        order.setTelephone(orderVo.getTelephone());
        order.setCommitTime(new Date());
        order.setSetmealType(orderVo.getSetmealType());
        try {
            int orderId = orderService.addOrder(order);
            //存入messagePhone表
            for (TypeDetail typeDetail : typeDetailList) {
                //取得当前行的值
                String node = nodeMessage.getString(String.valueOf(typeDetail.getId()));
                if (node != null && node.length() != 0) {
                    //phone;newPhone-typeDetailCode
                    //phone;
                    String[] nodeMsg = node.split(";");
                    String phone = nodeMsg[0];
                    for (Suppiler suppiler : suppilerList) {
                        String selfNumber = phone;
                        for (String str : nodeMsg) {
                            String[] phoneMsg = str.split("-");
                            //判断有没有个性化设置
                            if (phoneMsg.length > 1) {
                                if (phoneMsg[1].equals(suppiler.getSuppilerCode())) {
                                    //selfNumber=newPhone
                                    selfNumber = phoneMsg[0];
                                }
                            }
                        }
                        MessagePhone messagePhone = new MessagePhone();
                        messagePhone.setOrderId(orderId);
                        messagePhone.setSuppilerName(suppiler.getSuppilerName());
                        messagePhone.setPhones(selfNumber);
                        messagePhone.setTypeDetailId(typeDetail.getId());
                        phoneService.addMessagePhone(messagePhone);
                    }
                }

            }
            return "提交成功";
        } catch (Exception e) {
            return "提交失败" + e;
        }
    }
}


