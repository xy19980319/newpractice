package com.xiaoxiao.usersystem.service;

import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;

import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 14:58
 */
public interface userService {
    public List<User> findAll();
    public Manager login(Manager LoginManager);
    public int add(User user);
    public int delete(String id);
    public User findById(String id);
    public int update(User user);
    void delSelected(String[] uids);
}
