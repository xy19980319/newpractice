package com.xiaoxiao.dao;

import com.xiaoxiao.domain.User;
import com.xiaoxiao.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author Xiaoyu
 * @date 2019/12/8 - 10:46
 * 用户登录案例需求：
 * 	1.编写login.html登录页面
 * 		username & password 两个输入框
 * 	2.使用Druid数据库连接池技术,操作mysql，day14数据库中user表
 * 	3.使用JdbcTemplate技术封装JDBC
 * 	4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
 * 	5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误
 */
public class userDao {
    //创建公用的jdbctemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
