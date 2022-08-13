package com.iweb.DAO.impl;

import com.iweb.DAO.UserDAO;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 17:57
 * @description 类的描述与介绍
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public boolean login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
