package com.xiaoxiao.servlet;

import com.xiaoxiao.dao.JDBCDao;
import com.xiaoxiao.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Xiaoyu
 * @date 2019/12/11 - 22:21
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取网页中的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkBox = request.getParameter("checkBox");
        //拿到session
        HttpSession session = request.getSession();
        //先对验证码进行检查
        String check = (String) request.getSession().getAttribute("checkBox");
        session.removeAttribute("checkBox");
        //封装对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //忽略大小写.如果验证码正确,就进入检查界面,如果错误,则直接在页面上显示验证码错误
        if (checkBox.equalsIgnoreCase(check)) {
            //调用dao方法查询数据库
            User checkuser = JDBCDao.checkuser(loginUser);
            if (checkuser != null) {
                String username1 = checkuser.getUsername();
                session.setAttribute("username",username1);
                response.sendRedirect("/day16/success.jsp");
            }else {
                request.setAttribute("up_error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("c_error", "验证码输入错误!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
