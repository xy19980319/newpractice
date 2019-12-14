package com.xiaoxiao.usersystem.service.impl;

import com.xiaoxiao.usersystem.dao.Impl.userDaoImpl;
import com.xiaoxiao.usersystem.dao.userDao;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.service.userService;

import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/14 - 15:01
 */
public class userServiceImpl implements userService {
    private userDao dao = new userDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
