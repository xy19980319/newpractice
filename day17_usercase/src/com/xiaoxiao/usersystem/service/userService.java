package com.xiaoxiao.usersystem.service;

import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.domain.pageBean;

import java.util.List;
import java.util.Map;

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

    pageBean getPageBean(String currentPage, String rows, Map<String, String[]> condition);

}
