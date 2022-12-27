package com.jyh.service;

import com.jyh.entity.User;

import java.util.List;

public interface UserService {
    User login(String phone, String password);
    void add(User user);
    List<User> listUsers(Integer id);
}
