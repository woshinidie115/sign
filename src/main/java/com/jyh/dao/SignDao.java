package com.jyh.dao;

import com.jyh.entity.Sign;

import java.util.List;

public interface SignDao {
    void insert(Sign sign);
    List<Sign> selectList();
}
