package com.jyh.controller;



import com.jyh.common.CommonResult;
import com.jyh.entity.Sign;
import com.jyh.service.SignService;
import com.jyh.service.SignServiceImpl;
import com.jyh.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignListServlet", value = "/signList")
public class SignListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SignService signService = new SignServiceImpl();



      String info=null;
       try { List<Sign> signList = signService.listSign();
        if (signList != null) {
            info = JsonUtils.bean2json(CommonResult.success(signList));
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
