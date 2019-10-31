package com.mango.demo.dao;

import com.mango.demo.entity.Type;
import com.mango.demo.entity.TypeDetail;

import java.util.List;

public interface TypeDetailDao {
    List<TypeDetail> getDetailBytypeId(String typeId);
    TypeDetail getDetailById(String id);
    int updateDetail(TypeDetail typeDetail);
    int addDetail(TypeDetail typeDetail);
    List<TypeDetail> findDetail();
}
