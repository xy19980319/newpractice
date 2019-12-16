package com.xiaoxiao.usersystem.web.Servlet;

import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.service.impl.userServiceImpl;
import com.xiaoxiao.usersystem.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 14:37
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.使用userService将数据进行读取
        userService userService = new userServiceImpl();
        List<User> users = userService.findAll();
        //2.将页面进行转发
        request.setAttribute("users",users);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
