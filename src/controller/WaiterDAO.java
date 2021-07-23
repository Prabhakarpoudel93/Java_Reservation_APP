/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.AddWaiters;
import util.DBConnection;
import view.AddWaiter;

/**
 *
 * @author Prabhakar
 */
public class WaiterDAO {
    public static int addWaiter(AddWaiters ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="insert into waiter (name,username,password,contact,email,address,gender) values (?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getUsername());
            pst.setString(3, ob.getPassword());
            pst.setString(4, ob.getContact());
            pst.setString(5, ob.getEmail());
            pst.setString(6, ob.getAddress());
            pst.setString(7, ob.getGender());
            count=pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
        
    }
    public List<AddWaiters> getWaiter()
    {
        List<AddWaiters> law=new ArrayList();
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="select * from waiter";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                AddWaiters adw=new AddWaiters();
                adw.setId(rs.getInt("waiter_id"));
                adw.setName(rs.getString("name"));
                adw.setUsername(rs.getString("username"));
                adw.setPassword(rs.getString("password"));
                adw.setAddress(rs.getString("address"));
                adw.setGender(rs.getString("gender"));
                adw.setEmail(rs.getString("email"));
                adw.setContact(rs.getString("contact"));
                law.add(adw);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return law;
    }
    
    public int updateWaiter(AddWaiters ob)
    {
        int count=0;
        
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="update waiter set name=?,username=?,password=?,address=?,contact=?,email=?,gender=? where waiter_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            pst.setString(2, ob.getUsername());
            pst.setString(3, ob.getPassword());
            pst.setString(4, ob.getAddress());
            pst.setString(5, ob.getContact());
            pst.setString(6, ob.getEmail());
            pst.setString(7, ob.getGender());
            pst.setInt(8, ob.getId());
            count = pst.executeUpdate();
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
        
    }
    public int deleteWaiter(int id)
    {
        int count=0;
        
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="delete from waiter where waiter_id=? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            count=pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
    }
    
}
