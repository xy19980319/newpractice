package com.xiaoxiao.druid;

import com.xiaoxiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Xiaoyu
 * @date 2019/11/29 - 10:06
 */
public class DruidDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into account values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "周七");
            pstmt.setDouble(2, 8000);
            int i = pstmt.executeUpdate();
            System.out.println(i);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt);
        }

    }
}
