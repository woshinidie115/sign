package com.jyh.service;

import com.jyh.entity.Sign;

import java.util.List;

public interface SignService {
    void add(Sign sign);
    List<Sign> listSign();
}
