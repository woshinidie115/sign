package com.jyh.service;

import com.jyh.dao.UserDao;
import com.jyh.dao.UserDaoImpl;
import com.jyh.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String phone, String password) {
        User user = userDao.selectByPhone(phone);
        if (user == null) {
            throw new RuntimeException("用户名错误");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public void add(User user) {
        if(userDao.selectByPhone(user.getPhone())==null){
            userDao.insert(user);
        }

    }

    @Override
    public List<User> listUsers(Integer id) {
        return userDao.selectList(id);
    }
}
