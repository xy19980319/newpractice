package com.xiaoxiao.cookie;
import java.net.URLDecoder;
import java.net.URLEncoder;
import	java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import	java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Xiaoyu
 * @date 2019/12/9 - 21:09
 * 1. 需求：
 * 1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 */
@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否存在cookie,如果不存在,则将时间存进去
        //首先先控制页面输出的格式
        response.setContentType("text/html;charset=utf-8");
        //获取Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;
                    String value = cookie.getValue();
                    //将cookie的时间重新写入
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
                    String str_date = sdf.format(date);
                    //将格式化后的时间转化为URL编码
                    System.out.println("编码前:" + str_date);//编码前
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后:" + str_date);//编码后
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
                    //将时间写出
                    System.out.println("解码前:" + value);//解码前
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后:" + value);//解码后
                    response.getWriter().write("欢迎回来，您上次访问时间为:" + value);
                    break;
                }
            }
        }
        if (cookies == null || flag == false || cookies.length == 0) {

            //将cookie的时间重新写入
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
            String str_date = sdf.format(date);
            //将格式化后的时间转化为URL编码
            System.out.println("首次编码前:" + str_date);//编码前
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("首次编码后:" + str_date);//编码后
            Cookie cookie = new Cookie("lastTime",str_date);
            //必须要先编码,存到cookie,之后读取的时候在进行解码
            str_date = URLDecoder.decode(str_date, "utf-8");
            response.addCookie(cookie);
            response.getWriter().write("首次欢迎");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
