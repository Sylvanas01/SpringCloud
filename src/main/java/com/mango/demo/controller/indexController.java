package com.mango.demo.controller;
import com.mango.demo.entity.User;
import com.mango.demo.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("index")
public class indexController {
    @Resource
    private IndexService indexService;

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "message")
    public String message() {
        return "message";
    }
    @RequestMapping(value = "addUser")
    @ResponseBody
    public String addUser(User user) {
         user.setDelFlag(0);
        if (indexService.addUser(user)>0)
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
