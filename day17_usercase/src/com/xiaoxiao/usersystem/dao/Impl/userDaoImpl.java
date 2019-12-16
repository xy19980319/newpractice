package com.xiaoxiao.usersystem.dao.Impl;

import com.xiaoxiao.usersystem.dao.userDao;
import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
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

    @Override
    public Manager login(Manager loginManager) {
        try {
            String sql = "select * from manager where username = ? and password = ? ";
            Manager manager = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Manager>(Manager.class), loginManager.getUsername(), loginManager.getPassword());
            return manager;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int add(User user) {
        try {
            String sql = "insert into user values(null,?,?,?,?,?,?);";
            int count = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
            return count;
        } catch (DataAccessException e) {
            return 0;
        }


    }

    @Override
    public int delete(String id) {
        try {
            String sql = "delete from user where id = ?";
            int del = jdbcTemplate.update(sql, id);
            return del;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    @Override
    public User findById(String id) {
        try {
            String sql = "select * from user where id = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }

    @Override
    public int update(User user) {
        try {
            String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
            int update = jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
            return update;
        } catch (DataAccessException e) {
            return 0;
        }

    }

    @Override
    public void delSelected(String[] uids) {
        for (String uid : uids) {
            delete(uid);
        }
    }

    @Override
    public int getTotalCounts() {
        String sql = "select count(*) from user";
        int totalCounts = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalCounts;
    }

    @Override
    public List<User> findByPage(int currentPage, int rows) {
        String sql = "select * from user limit ? , ?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), (currentPage - 1) * rows, rows);
        return list;
    }
}
