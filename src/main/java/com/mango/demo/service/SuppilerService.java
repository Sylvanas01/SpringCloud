package com.mango.demo.service;

import com.mango.demo.dao.SuppilerDao;
import com.mango.demo.dao.TypeDao;
import com.mango.demo.entity.Suppiler;
import com.mango.demo.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuppilerService {

    @Resource
    private SuppilerDao suppilerDao;
   public List<Suppiler> getSuppiler (){
       return suppilerDao.getSuppiler();
   }

}
