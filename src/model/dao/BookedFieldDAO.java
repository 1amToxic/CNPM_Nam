/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import model.BookedField;
import model.BookedFieldSingle;
import model.Client;
import model.Field;

/**
 *
 * @author lamit
 */
public class BookedFieldDAO extends DAO{
    private int idBooking;
    private int idBookedField;
    private BookedField bf = new BookedField();
    public int getIdBooking() {
        return idBooking;
    }

    public int getIdBookedField() {
        return idBookedField;
    }
    
    public void updateBooking(Client c, Field f){
        Date date = new Date();
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sql = "insert into tblbooking(bookedDate,total,saleoff,idclient,iduser) values(?,?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, formatter.format(date));
            pre.setInt(2, 0);
            pre.setInt(3, 0);
            pre.setInt(4, c.getId());
            pre.setInt(5, f.getId());
            pre.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        String sql1 = "select id from tblbooking";
        try{
            PreparedStatement pre = con.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                idBooking = rs.getInt("id");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void updateBookedField(BookedField bf){
        this.bf = bf;
        String sql = "insert into tblbookedfield(startmatch,endmatch,starttime,endtime,price,saleoff,idbooking,idfield,total,des)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, bf.getStartmatch());
            pre.setString(2, bf.getEndmatch());
            pre.setString(3, bf.getStarttime().toString());
            pre.setString(4, bf.getEndtime().toString());
            pre.setInt(5, bf.getPrice());
            pre.setInt(6, 0);
            pre.setInt(7, idBooking);
            pre.setInt(8, bf.getField().getId());
            pre.setInt(9, 0);
            pre.setString(10,bf.getDes());
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        String sql1 = "select id from tblbookedfield";
        try{
            PreparedStatement pre = con.prepareStatement(sql1);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                idBookedField = rs.getInt("id");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void updateBookedFieldSingle(LocalDate date){
        String sql = "insert into tblbookedfieldsingle(idbookedfield,playdate,checkin,checkout,total,penalty)"
                + " values(?,?,?,?,?,?)";
        BookedFieldSingle bfs = new BookedFieldSingle(idBookedField, date.toString(), bf.getStartmatch(),
                bf.getEndmatch(), 0, 0);
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, idBookedField);
            pre.setString(2, bfs.getPlayDate());
            pre.setString(3, bfs.getCheckin());
            pre.setString(4, bfs.getCheckout());
            pre.setInt(5, bfs.getTotal());
            pre.setInt(6, bfs.getPenalty());
            pre.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
