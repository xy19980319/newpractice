package com.xiaoxiao.jdbc;

import com.xiaoxiao.jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Xiaoyu
 * @date 2019/11/28 - 15:24
 */
public class JdbcDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "update  account set salary = salary - ? where id = ?";
            String sql2 = "update  account set salary = salary + ? where id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setDouble(1, 500);
            pstmt2.setInt(1, 500);
            pstmt1.setDouble(2, 1);
            pstmt2.setInt(2, 2);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, pstmt1);
            JDBCUtil.close(null, pstmt2);
        }
    }

}
