package com.mango.demo.service;

import com.mango.demo.dao.IndexDao;
import com.mango.demo.dao.TypeDao;
import com.mango.demo.entity.Type;
import com.mango.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexService {

    @Resource
    private IndexDao indexDao;
   public int addUser(User user){
       return indexDao.addUser(user);
   }

}
