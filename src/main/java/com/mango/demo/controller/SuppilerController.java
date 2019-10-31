package com.mango.demo.controller;


import com.mango.demo.entity.*;
import com.mango.demo.service.SuppilerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("suppiler")
public class SuppilerController {
    @Resource
    private SuppilerService suppilerService;
    @RequestMapping(value = "getSuppiler")
    @ResponseBody
    public List<Suppiler> getSuppiler() {
        return suppilerService.getSuppiler();
    }

}
