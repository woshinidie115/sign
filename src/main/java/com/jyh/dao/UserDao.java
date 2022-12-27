package com.jyh.dao;

import com.jyh.entity.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    User selectByPhone(String phone);
    List<User> selectList(Integer id);
    void update(Integer score, Integer id);
}
