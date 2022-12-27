package com.jyh.service;

import com.jyh.dao.SignDao;
import com.jyh.dao.SignDaoImpl;
import com.jyh.entity.Sign;

import java.util.List;

public class SignServiceImpl implements SignService {
    private SignDao signDao=new SignDaoImpl();
    @Override
    public void add(Sign sign) {

        signDao.insert(sign);
    }
    public List<Sign> listSign() {
        return signDao.selectList();
    }

}
