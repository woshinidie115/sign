package com.jyh.dao;

import com.jyh.entity.User;
import com.jyh.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {
        QueryRunner queryRunner = DruidUtils.getQueryRunner();
        String sql = "insert into user(phone,password,otherid,signtime) values(?,?,?,?)";
        try {
            queryRunner.update(sql, user.getPhone(),user.getPassword(),user.getOtherid(),user.getSigntime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectByPhone(String phone) {
        QueryRunner queryRunner = DruidUtils.getQueryRunner();
        String sql = "select * from user where phone=?";
        try {
            return queryRunner.query(sql, new BeanHandler<User>(User.class), phone);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询用户信息异常");
        }
    }

    @Override
    public List<User> selectList(Integer id) {
        QueryRunner queryRunner = DruidUtils.getQueryRunner();
        String sql = "select * from user where otherid=?";
        try {
            return queryRunner.query(sql, new BeanListHandler<User>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Integer score, Integer id) {
        QueryRunner queryRunner= DruidUtils.getQueryRunner();
        String sql= "update user set score=? where id=?";
        try {
            queryRunner.update(sql,score,id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}


