/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lamit
 */
public class DAO {
    public static Connection con;
	
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/field";
			String dbClass = "com.mysql.cj.jdbc.Driver";

			try {
//                            System.out.println("Success");
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "lam@2020");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} 
}
