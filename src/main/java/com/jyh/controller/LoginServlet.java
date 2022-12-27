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

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        UserService userService=new UserServiceImpl();
       String info=null;
        try {
            User user1=userService.login(phone,password);
            request.getSession().setAttribute("loginUser", user1);
            if (user1 != null) {

                info = JsonUtils.bean2json(CommonResult.success(user1));
            } else {
                info = JsonUtils.bean2json(CommonResult.success());
            }
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
