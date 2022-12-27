package com.jyh.dao;

import com.jyh.entity.Sign;
import com.jyh.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SignDaoImpl implements SignDao {
    @Override
    public void insert(Sign sign) {
        QueryRunner queryRunner = DruidUtils.getQueryRunner();
        String sql = "insert into sign(id,phone,arrivetime,score) values(?,?,?,?)";
        try {
            queryRunner.update(sql, sign.getId(),sign.getPhone(),sign.getArrivetime(),sign.getScore());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Sign> selectList() {
        QueryRunner queryRunner = DruidUtils.getQueryRunner();
        String sql = "select * from sign";
        try {
            return queryRunner.query(sql, new BeanListHandler<Sign>(Sign.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
