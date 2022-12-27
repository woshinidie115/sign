package com.jyh.controller;

import com.jyh.common.CommonResult;
import com.jyh.entity.User;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String info=null;
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String otherid = request.getParameter("otherid");

        Date date=new Date();
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setOtherid(Integer.parseInt(otherid));
     user.setSigntime(date);
        UserService userService=new UserServiceImpl();

        try {
            userService.add(user);
            info = JsonUtils.bean2json(CommonResult.success());
        } catch (Exception e) {
            e.printStackTrace();
            info = JsonUtils.bean2json(CommonResult.error(e.getMessage()));
        }finally {
            response.getWriter().write(info);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
