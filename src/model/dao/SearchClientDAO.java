/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;

/**
 *
 * @author lamit
 */
public class SearchClientDAO extends DAO{
    public ArrayList<Client> searchClient(String key){
        ArrayList<Client> list = new ArrayList<>();
        String sql = "select * from tblclient where name like ?";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%"+key+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                list.add(new Client(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("idcard"),rs.getString("telephone"),rs.getString("des")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    public void addClient(Client c){
        String sql = "insert into tblclient(name,address,idcard,telephone,email,des) values(?,?,?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, c.getName());
            pre.setString(2, c.getAddress());
            pre.setString(3, c.getIdcard());
            pre.setString(4, c.getTelephone());
            pre.setString(5, c.getEmail());
            pre.setString(6, c.getDes());
            pre.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        String sql1 = "select id from tblclient";
        try{
            PreparedStatement pre = con.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt("id"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
