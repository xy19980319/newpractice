package com.xiaoxiao.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Xiaoyu
 * @date 2019/11/28 - 18:07
 */
public class C3p0 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = ds.getConnection();
        //打印
        System.out.println(conn);
    }
}
