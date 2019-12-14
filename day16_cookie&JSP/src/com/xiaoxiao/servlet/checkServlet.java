package com.xiaoxiao.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Xiaoyu
 * @date 2019/12/8 - 19:25
 */
@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.新建一个图片对象
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);
        //2.2画一个边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);
        //往验证码内部写字
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        String strs = "";
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(string.length());
            char str = string.charAt(index);
            g.drawString(str + "", 20 * i, 30);
            strs += str;
        }
        //将字符放入session中
        HttpSession session = req.getSession();
        session.setAttribute("checkBox",strs);
        //生成干扰先
        g.setColor(Color.green);
        for (int i = 0 ;i < 10 ;i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //3.将图片对象进行输出
        ImageIO.write(img, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
