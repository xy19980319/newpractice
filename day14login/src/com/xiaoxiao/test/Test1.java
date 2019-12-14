package com.xiaoxiao.test;

import com.xiaoxiao.dao.userDao;
import com.xiaoxiao.domain.User;
import org.junit.Test;

/**
 * @author Xiaoyu
 * @date 2019/12/8 - 15:13
 */
public class Test1 {
    @Test
    public void test() {
        //封装账号和密码
        User loginUser = new User(1,"123","123");
        //使用login的方法进行登入
        userDao dao = new userDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
