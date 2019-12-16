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
 * @date 2019/12/15 - 16:25
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //将提交的数据进行封装成类,然后进行修改
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //使用update方法进行修改
        userService service = new userServiceImpl();
        int update = service.update(user);
        if (update == 0) {
            System.out.println("修改失败");
            return;
        }
        response.sendRedirect(request.getContextPath() +"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
