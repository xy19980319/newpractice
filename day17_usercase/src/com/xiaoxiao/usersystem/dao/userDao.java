package com.xiaoxiao.usersystem.dao;

import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;

import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 15:08
 */
public interface userDao {
    public List<User> findAll();
    public Manager login(Manager loginManager);
    public int add(User user);
    public int delete(String id);
    public User findById(String id);
    public int update(User user);

    void delSelected(String[] uids);

    int getTotalCounts();

    List<User> findByPage(int currentPage, int rows);
}
