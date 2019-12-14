package com.xiaoxiao.dao;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Xiaoyu
 * @date 2019/12/12 - 15:48
 */
public class JDBCDao {
    //创建一个公用的JDBCTemplate
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static User checkuser(User loginUser) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }

}
