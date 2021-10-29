package com.tt.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc1 {
    // @Test注解仅在方法上有效，只要添加了该注解的方法，便可直接执行
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        System.out.println("Hello");

        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        Connection connection = null;

        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 连接数据库
            connection = DriverManager.getConnection(url, username, password);

            // 3. 通知数据库开启事务
            connection.setAutoCommit(false);
            String sql1 = "update account set money= money-100 where name = 'A'";
            connection.prepareStatement(sql1).executeUpdate();

            // 制造错误
            int i = 1/0;
            String sql2 = "update account set money= money-100 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();//sql均执行成功，则提交事务
        } catch (Exception e) {
            try {
                // 若出现异常，则回滚事务
                connection.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}