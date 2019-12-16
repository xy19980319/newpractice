package com.xiaoxiao.usersystem.test;

import com.xiaoxiao.usersystem.domain.Manager;
import com.xiaoxiao.usersystem.domain.User;
import com.xiaoxiao.usersystem.service.impl.userServiceImpl;
import com.xiaoxiao.usersystem.service.userService;
import com.xiaoxiao.usersystem.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Xiaoyu
 * @date 2019/12/15 - 10:17
 */
public class Test1 {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test() {
        //封装对象
      /*  Manager manager = new Manager();
        BeanUtils.copyProperties(manager, map);*/
        Manager manager = new Manager();
        manager.setUsername("root");
        manager.setPassword("root");
        //调用service
        userService service = new userServiceImpl();
        if (service.login(manager) == null) {
            System.out.println("空的" + manager);

        }else {
            System.out.println(manager);

        }
    }
    @Test
    public void test2() {
        User user = new User();
        user.setName("zhangsan");
        user.setGender("女");
        user.setAge(23);
        user.setAddress("广东");
        user.setQq("123456");
        user.setEmail("123456@qq.com");
        userService service = new userServiceImpl();
        int add = service.add(user);
        System.out.println(add);
        for (int i = 0; i <12 ; i++) {

            //1.定义sql
            String sql = "insert into user values(null,?,?,?,?,?,?)";
            //2.执行sql
            jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        }


    }
    @Test
    public void test3() {
        String id = "3";
        userService service = new userServiceImpl();
        User user = service.findById(id);
        System.out.println(user);
    }
    @Test
    public void test4() {
        User user = new User();
        user.setName("zhangsan");
        user.setGender("女");
        user.setAge(23);
        user.setAddress("湖南");
        user.setQq("123456");
        user.setEmail("123456@qq.com");
        try {
            String sql ="update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = 15";
            int update = jdbcTemplate.update(sql,user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
}
