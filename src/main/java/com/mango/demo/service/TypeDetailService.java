package com.mango.demo.service;

import com.mango.demo.dao.TypeDetailDao;
import com.mango.demo.entity.TypeDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeDetailService {
    @Resource
    private TypeDetailDao typeDetailDao;

    public List<TypeDetail> getDetailBytypeId(String typeId) {
        return typeDetailDao.getDetailBytypeId(typeId);
    }

    public TypeDetail getDetailById(String id) {
        return typeDetailDao.getDetailById(id);
    }

    public int updateDetail(TypeDetail typeDetail) {
        return typeDetailDao.updateDetail(typeDetail);
    }

    public int addDetail(TypeDetail typeDetail){
        return typeDetailDao.addDetail(typeDetail);
    }

    public List<TypeDetail> findDetail(){return typeDetailDao.findDetail();}
}
