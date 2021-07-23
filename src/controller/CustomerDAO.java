/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.sql.PreparedStatement;
import model.AddCustomers;
import util.DBConnection;

/**
 *
 * @author Prabhakar
 */
public class CustomerDAO {
    public static int addCustomer(AddCustomers ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="insert into customers(name,email,address,contact,gender) values (?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2,ob.getEmail());
            pst.setString(3, ob.getAddress());
            pst.setString(4, ob.getContact());
            pst.setString(5, ob.getGender());
            count=pst.executeUpdate();
            
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
                    
        }
        return count;
    }
    
}
