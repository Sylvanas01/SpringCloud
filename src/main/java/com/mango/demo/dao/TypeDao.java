package com.mango.demo.dao;

import com.mango.demo.entity.Type;

import java.util.List;

public interface TypeDao {
    List<Type> findType(Type type);

    int addType(Type type);

}