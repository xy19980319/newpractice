package com.xiaoxiao.usersystem.web.Servlet;

import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.service.impl.userServiceImpl;
import com.xiaoxiao.usersystem.service.userService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Xiaoyu
 * @date 2019/12/15 - 14:22
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取选中的所有信息
        User user = new User();
        Map<String, String[]> maps = request.getParameterMap();
        try {
            BeanUtils.populate(user,maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService server = new userServiceImpl();
        int add = server.add(user);
        if (add == 0) {
            request.setAttribute("adderr", "添加失败");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
