/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Field;

/**
 *
 * @author lamit
 */
public class SearchFieldDAO extends DAO{
    public ArrayList<Field> searchFreeField(String key){
        ArrayList<Field> list = new ArrayList<>();
        String sql = "select * from tblfield where des = ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, key);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add(new Field(rs.getInt("id"),rs.getString("quality"), rs.getString("name"), rs.getInt("price"), rs.getString("des")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
