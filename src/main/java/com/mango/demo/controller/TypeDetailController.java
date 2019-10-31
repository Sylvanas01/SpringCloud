package com.mango.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mango.demo.entity.TypeDetail;
import com.mango.demo.service.TypeDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("typeDetail")
public class TypeDetailController {
    @Resource
    private TypeDetailService typeDetailService;

    @RequestMapping(value = "getDetailBytypeId")
    @ResponseBody
    public List<TypeDetail> getDetailBytypeId(String typeId) {
        return typeDetailService.getDetailBytypeId(typeId);
    }

    @RequestMapping(value = "getDetailById")
    @ResponseBody
    public TypeDetail getDetailById(String id) {
        return typeDetailService.getDetailById(id);
    }

    @RequestMapping("updateDetail")
    @ResponseBody
    public String updateDetail(TypeDetail typeDetail) {
        if (typeDetailService.updateDetail(typeDetail) > 0) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }

    @RequestMapping("findDetail")
    @ResponseBody
    public List<TypeDetail> findDetail(){
        return typeDetailService.findDetail();
    }

    @RequestMapping("addDetail")
    @ResponseBody
    public String addDetail(String objs) {

        JSONObject json = JSONObject.parseObject(objs);
        String typeId = json.getString("typeId");
        String detailCode = json.getString("detailCode");
        String detailValue = json.getString("detailValue");
        String a = JSONArray.toJSONString(detailCode);
        TypeDetail typeDetail = new TypeDetail();
        try {
            JSONArray detailCodes = json.getJSONArray("detailCode");
            JSONArray detailValues = json.getJSONArray("detailValue");

            for (int i = 0; i < detailCodes.size(); i++) {
                typeDetail.setDetailCode(detailCodes.getString(i));
                typeDetail.setDetailValue(detailValues.getString(i));
                typeDetail.setTypeId(Integer.valueOf(typeId));
                typeDetail.setDelFlag(0);
                typeDetailService.addDetail(typeDetail);
            }
        } catch (Exception e) {
            System.out.println("只有一行数据");
            typeDetail.setDetailCode(detailCode);
            typeDetail.setDetailValue(detailValue);
            typeDetail.setTypeId(Integer.valueOf(typeId));
            typeDetailService.addDetail(typeDetail);
        }
        return "成功";
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
