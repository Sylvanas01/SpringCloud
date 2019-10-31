package com.mango.demo.controller;


import com.mango.demo.entity.Type;
import com.mango.demo.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("type")
public class TypeController {
    @Resource
    private TypeService typeService;

    @RequestMapping(value = "index")
    public String index() {
        return "type";
    }
    @RequestMapping(value = "findType")
    @ResponseBody
    public List<Type> findType(Type type, HttpServletRequest request) {
        return typeService.findType(type);
    }
    @RequestMapping(value = "addType")
    @ResponseBody
    public String addType(Type type) {
         type.setDelFlag(0);
        if (typeService.addType(type)>0)
            return "添加成功";
        else
            return "添加失败";
    }

//    @RequestMapping(value = "getBaobiaoById")
//    @ResponseBody
//    public Map<String, Object> getBaobiaoId(String id){
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Baobiao> baobiao = new ArrayList<Baobiao>();
//        baobiao = baobiaoService.getBaobiaoById(id);
//        System.out.println(baobiao);
//        map.put("Baobiao", baobiao);
//        return map;
//    }map
}
