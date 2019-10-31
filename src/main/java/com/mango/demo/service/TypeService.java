package com.mango.demo.service;

import com.mango.demo.dao.TypeDao;
import com.mango.demo.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeDao typeDao;
   public List<Type> findType (Type type){
       return typeDao.findType(type);
   }
   public int addType(Type type){
       return typeDao.addType(type);
   }

}
