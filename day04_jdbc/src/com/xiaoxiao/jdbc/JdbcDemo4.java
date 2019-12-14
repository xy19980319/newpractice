package com.xiaoxiao.jdbc;

import com.xiaoxiao.domain.Emp;
import com.xiaoxiao.jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/11/28 - 11:22
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        List<Emp> emps = findAll();
        System.out.println(emps);
        System.out.println(emps.size());
    }

    public static List<Emp> findAll() {
        Emp emp = new Emp();
        List<Emp> emps = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try {
            /*//注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "root");*/
            conn = JDBCUtil.getConnection();
            //创建sql语句
            String sql = "select * from emp";
            //创建statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setDate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                emps.add(emp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           /* if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
           JDBCUtil.close(rs,conn,stmt);
        }
        return emps;
    }
}
