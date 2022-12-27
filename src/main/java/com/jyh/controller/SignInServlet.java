package com.jyh.controller;



import com.jyh.common.CommonResult;
import com.jyh.dao.UserDao;
import com.jyh.dao.UserDaoImpl;
import com.jyh.entity.Sign;
import com.jyh.entity.User;
import com.jyh.service.SignService;
import com.jyh.service.SignServiceImpl;
import com.jyh.service.UserService;
import com.jyh.service.UserServiceImpl;
import com.jyh.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet( value = "/sign")
public class SignInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        SignService signService = new SignServiceImpl();
        UserService userService=new UserServiceImpl();
        UserDao userDao=new UserDaoImpl();

        String info=null;
        if(loginUser == null){
            response.getWriter().write("请先登录");
        }else{
           Sign sign = new Sign();
            sign.setId(loginUser.getId());
            sign.setPhone(loginUser.getPhone());
            sign.setArrivetime(new Date());
            int reward = (int) (Math.random()*6)+2;
            sign.setScore(reward);
            userDao.update(reward,loginUser.getId());

           try{
               signService.add(sign);
               info = JsonUtils.bean2json(CommonResult.success());
           }catch (Exception e) {
               e.printStackTrace();
               info = JsonUtils.bean2json(CommonResult.error(e.getMessage()));
           }finally {
               response.getWriter().write(info);
           }



    }}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
