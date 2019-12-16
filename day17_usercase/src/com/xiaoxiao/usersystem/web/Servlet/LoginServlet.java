package com.xiaoxiao.usersystem.web.Servlet;

import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.service.impl.userServiceImpl;
import com.xiaoxiao.usersystem.service.userService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 20:55
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码表
        request.setCharacterEncoding("utf-8");
        String verifycode = request.getParameter("verifycode");
        //校验验证码
        HttpSession session = request.getSession();
        String checkcode = (String) session.getAttribute("CHECKCODE_SERVER");
        //删除session中的验证码,使得后退也能更改
        session.removeAttribute("CHECKCODE_SERVER");
        //如果验证码错误,直接回到页面弹出失败
        if (!(checkcode.equalsIgnoreCase(verifycode))) {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //封装对象
        Manager manager = new Manager();
        //从request中获取数据
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(manager,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service
        userService service = new userServiceImpl();
        if (service.login(manager) == null) {
            request.setAttribute("error", "账号或密码有误,请重新输入!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            System.out.println(manager);
            session.setAttribute("manager",manager.getUsername());
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
