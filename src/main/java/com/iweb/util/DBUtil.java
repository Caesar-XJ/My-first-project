package com.iweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/11 8:52
 * @description 类的描述与介绍
 */
public class DBUtil {
    private static Connection connection;
    private static final String url="jdbc:mysql://localhost:3306/caesar?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static final String username="root";
    private static final String password="123456";
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 返回jdbc所需要的数据库连接
     */
    public static Connection getConnection(){
        Connection c=null;
        try {
            c= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}
