package com.xiaoxiao.usersystem.service.impl;

import com.xiaoxiao.usersystem.dao.Impl.userDaoImpl;
import com.xiaoxiao.usersystem.dao.userDao;
import com.xiaoxiao.usersystem.domain.Manager;
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

    @Override
    public Manager login(Manager LoginManager) {
        return dao.login(LoginManager);
    }

    /**
     * 添加联系人数据到数据库
     * @param user
     */
    @Override
    public int add(User user) {
        return dao.add(user);
    }

    /**
     * 删除一位用户的信息
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    /**
     * 通过拿到一个ID值来删除一个user对象
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        return dao.findById(id);
    }

    /**
     * 修改数据
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public void delSelected(String[] uids) {
        dao.delSelected(uids);
    }


}
