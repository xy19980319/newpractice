package com.xiaoxiao.test;

import com.xiaoxiao.dao.JDBCDao;
import com.xiaoxiao.domain.User;
import org.junit.Test;

/**
 * @author Xiaoyu
 * @date 2019/12/12 - 17:08
 */
public class Test1 {
    @Test
    public void test1() {
        User loginUser = new User("1","zhansan","123");
        User checkuser = JDBCDao.checkuser(loginUser);
        System.out.println(checkuser);
    }
}
