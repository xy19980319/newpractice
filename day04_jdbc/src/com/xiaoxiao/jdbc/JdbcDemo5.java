package com.xiaoxiao.jdbc;

import java.sql.ResultSet;
import java.util.Scanner;

import com.xiaoxiao.jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Xiaoyu
 * @date 2019/11/28 - 14:32
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账号:");
        String username = sc.nextLine();
        System.out.println("请输入您的密码:");
        String password = sc.nextLine();
        if (new JdbcDemo5().login(username, password)) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("登录失败,请重新输入");
        }

    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from user where user =? and password =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);//给第一个问号赋值
            pstmt.setString(2, password);//给第二个问号赋值
            rs = pstmt.executeQuery();
       /*     if (rs.next()) {
                return true;
            } else {
                return false;
            }*///这里太麻烦了,其实直接将rs.next()作为返回值返回就好了
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, conn, pstmt);
        }
        return false;
    }
}
