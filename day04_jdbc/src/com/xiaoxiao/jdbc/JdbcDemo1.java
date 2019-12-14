package com.xiaoxiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Xiaoyu
 * @date 2019/11/26 - 17:13
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
        String sql = "update student3 set age = 18 where id =1 ";
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);
        System.out.println(i);
        stmt.close();
        conn.close();

    }

}
