package com.xiaoxiao.jdbctemplate;

import com.xiaoxiao.util.Emp;
import com.xiaoxiao.util.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author Xiaoyu
 * @date 2019/11/29 - 11:13
 */
public class TemplateDemo2 {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
    /*
    * 1. 修改1号数据的 salary 为 10000
    * */
    @Test
    public void test1() {
        String sql ="update emp1 set salary = ? where id = ?";
        int count = jdbcTemplate.update(sql, 10000, 1001);
        System.out.println(count);
    }
    //2. 添加一条记录
    @Test
    public void test2() {
        String sql ="insert into emp1 (id,dept_id,bonus)values(?,?,?)";
        int count = jdbcTemplate.update(sql, 1015, 10,5000);
        System.out.println(count);
    }
    //3. 删除刚才添加的记录
    @Test
    public void test3() {
        String sql ="delete from emp1 where id = ?";
        int count = jdbcTemplate.update(sql, 1015);
        System.out.println(count);
    }
    //beanpropertyrowmapper
    //4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void test4() {
        String sql ="select * from emp1 where id = ?";
        Map<String, Object> map1 = jdbcTemplate.queryForMap(sql, 1001);
        System.out.println(map1);
    }
//    5. 查询所有记录，将其封装为List
    @Test
    public void test5() {
        String sql ="select * from emp1";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }
//    6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void test6() {
        String sql ="select * from emp1";
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
    }
}
