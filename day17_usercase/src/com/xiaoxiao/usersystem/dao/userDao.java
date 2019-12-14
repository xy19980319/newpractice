package com.xiaoxiao.usersystem.dao;

import com.xiaoxiao.usersystem.domain.User;

import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 15:08
 */
public interface userDao {
    public List<User> findAll();
}
