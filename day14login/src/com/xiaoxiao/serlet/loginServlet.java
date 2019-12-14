package com.xiaoxiao.serlet;

import com.xiaoxiao.dao.userDao;
import com.xiaoxiao.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Xiaoyu
 * @date 2019/12/8 - 10:49
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码形式
        request.setCharacterEncoding("utf-8");
        //拿到页面的账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装账号和密码
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //使用login的方法进行登入
        userDao dao = new userDao();
        User user = dao.login(loginUser);
        System.out.println(user);//到这里都是没有问题的
        if (user == null) {
            System.out.println("失败" + user);
            request.getRequestDispatcher("/failServlet").forward(request,response);

        }else {
            System.out.println("成功" + user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet" ).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //和post方法一样
        doPost(request, response);
    }
}
