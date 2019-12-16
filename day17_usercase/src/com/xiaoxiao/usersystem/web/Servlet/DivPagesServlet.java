package com.xiaoxiao.usersystem.web.Servlet;

import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.domain.pageBean;
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
 * @date 2019/12/16 - 17:10
 */
@WebServlet("/divPagesServlet")
public class DivPagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取currentpage和rows
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            currentPage = "5";
        }

        //创建服务层
        userService service = new userServiceImpl();
        //获取总数据条数
        // int totalCounts = service.getToatalCounts();
        pageBean pageBean = service.getPageBean(currentPage,rows);
        List<User> users = pageBean.getList();
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("users",users);
        request.getRequestDispatcher("list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
