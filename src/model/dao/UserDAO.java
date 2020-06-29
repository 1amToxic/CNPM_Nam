/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author lamit
 */
public class UserDAO extends DAO{
    public boolean checkLogin(User user){
        boolean result;
        String sql = "select name,position from tbluser where username = ? and password = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                if(rs.getString("position").equals("employee")){
                    user.setPos(rs.getString("position"));
                    user.setName(rs.getString("name"));
                    result = true;
                }
                else result = false;
            }
            else result = true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
}
