package com.xiaoxiao.druid;

import com.xiaoxiao.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Xiaoyu
 * @date 2019/11/29 - 9:58
 */
public class DruidDemo2 {
    public static void main(String[] args) throws SQLException {
        for(int i = 0; i < 11; i++) {
            Connection conn = JDBCUtil.getConnection();
            System.out.println(conn);
            if(i ==5) {
                conn.close();
            }
        }

    }
}
