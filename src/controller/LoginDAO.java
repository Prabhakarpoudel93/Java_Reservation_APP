/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Login;
import util.DBConnection;

/**
 *
 * @author Prabhakar
 */
public class LoginDAO {
    public static int verifyAdmin(Login ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql= "select * from login where username=? and password=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getUsername());
            pst.setString(2,ob.getPassword());
            ResultSet rs=pst.executeQuery();//execute query kina halyeko as we need data from db
            while(rs.next())
            {
                count=rs.getInt("id");
            }
            
            
        }
        catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                return count;
    }
    
}
