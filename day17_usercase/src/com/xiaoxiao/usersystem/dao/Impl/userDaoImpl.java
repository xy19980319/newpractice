package com.xiaoxiao.usersystem.dao.Impl;

import com.xiaoxiao.usersystem.dao.userDao;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 15:10
 */
public class userDaoImpl implements userDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }
}
