package com.xiaoxiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Xiaoyu
 * @date 2019/11/27 - 9:08
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement stm = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接Connection
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            //sql命令
            String sql = "insert into account values(null,'赵六',5000);";
            //创建statement对象
            stm = cnn.createStatement();
            //执行sql语句
            int i = stm.executeUpdate(sql);
            System.out.println(i);
            if (i >0) {
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
            //关流
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (cnn != null) {
                try {
                    cnn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
