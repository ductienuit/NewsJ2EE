/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.mapper;

import com.halo.thuchanh3.model.RoleModel;
import com.halo.thuchanh3.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DucTien
 */
public class UserMapper implements RowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet rs) {
        UserModel user = new UserModel();
        try {
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setFullName(rs.getString("fullname"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getInt("status"));
            user.setRoleId(rs.getLong("roleid"));
            RoleModel role = new RoleModel();
            role.setCode(rs.getString("code"));
            role.setNameRole(rs.getString("name"));
            user.setRole(role);
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}