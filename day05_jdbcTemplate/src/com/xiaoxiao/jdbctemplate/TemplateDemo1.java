package com.xiaoxiao.jdbctemplate;

import com.xiaoxiao.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Xiaoyu
 * @date 2019/11/29 - 10:31
 */
public class TemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
        String sql = "update account set salary = ? where id = ?";
        int update = jdbcTemplate.update(sql, 3000, 1);
        System.out.println(update);
    }
}
