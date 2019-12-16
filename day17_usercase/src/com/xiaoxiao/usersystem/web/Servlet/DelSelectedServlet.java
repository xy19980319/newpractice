package com.xiaoxiao.usersystem.web.Servlet;

import com.xiaoxiao.usersystem.service.impl.userServiceImpl;
import com.xiaoxiao.usersystem.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xiaoyu
 * @date 2019/12/16 - 15:11
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.将所有选中的ID进行接收
        String[] uids = request.getParameterValues("uid");
        //将id数组进行传递到Del方法中进行删除
        userService userService = new userServiceImpl();
        userService.delSelected(uids);
        //转发到Userlistservlet
        request.getRequestDispatcher("/userListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
