package com.xiaoxiao.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Xiaoyuz
 * @date 2019/11/28 - 22:27
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties"));;
        //创建dataresource
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
