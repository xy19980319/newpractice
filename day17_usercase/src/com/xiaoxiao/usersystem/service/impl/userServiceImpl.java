package com.xiaoxiao.usersystem.service.impl;

import com.xiaoxiao.usersystem.dao.Impl.userDaoImpl;
import com.xiaoxiao.usersystem.dao.userDao;
import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.domain.pageBean;
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
     *
     * @param user
     */
    @Override
    public int add(User user) {
        return dao.add(user);
    }

    /**
     * 删除一位用户的信息
     *
     * @param id
     * @return
     */
    @Override
    public int delete(String id) {
        return dao.delete(id);
    }

    /**
     * 通过拿到一个ID值来删除一个user对象
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        return dao.findById(id);
    }

    /**
     * 修改数据
     *
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

    @Override
    public pageBean getPageBean(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        if (currentPage <= 0) {
            currentPage = 1;
        }
        int rows = 0;
        if (_rows != null && "".equalsIgnoreCase(_rows)) {
            rows = Integer.parseInt(_rows);
        }else {
            rows = 5;
        }
        //拿到总记录条数数
        int totalCounts = dao.getTotalCounts();
        //拿到总页码数
        int totalPages = (totalCounts % rows) == 0 ? (totalCounts / rows) : (totalCounts / rows) + 1;
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }
        //拿到List集合
        List<User> users = dao.findByPage(currentPage, rows);
        pageBean pageBean = new pageBean();
        pageBean.setTotalCounts(totalCounts);
        pageBean.setTotalPages(totalPages);
        pageBean.setList(users);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        return pageBean;
    }


}
