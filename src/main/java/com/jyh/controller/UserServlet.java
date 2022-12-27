package com.jyh.controller;

import com.jyh.entity.User;
import com.jyh.service.UserService;
import com.jyh.service.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",value = "/userlist")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserService userService = new UserServiceImpl();

        ServletContext servletContext = this.getServletContext();
        User user = (User)servletContext.getAttribute("user");

        List<User> userList = userService.listUsers(user.getId());

        request.setAttribute("userList",userList);
        request.setAttribute("user",user);

        request.getRequestDispatcher("userlist.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
