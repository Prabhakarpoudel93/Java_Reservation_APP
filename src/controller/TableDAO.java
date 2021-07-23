/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.AddTables;
import util.DBConnection;

/**
 *
 * @author Prabhakar
 */
public class TableDAO {
    public static int addTable(AddTables ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="insert into tables (tbl_name) values (?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getName());
            count=pst.executeUpdate();
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
    }
    public List<AddTables> getTable()
    {
        List<AddTables> ats=new ArrayList();
        
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="select * from tables";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                AddTables at=new AddTables();
                at.setId(rs.getInt("tbl_id"));
                at.setName(rs.getString("tbl_name"));
                ats.add(at);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return ats;
    }
    public int updateTable(AddTables ob)
    {
       int count=0;
       try
       {
           Connection con=DBConnection.getConnection();
           String sql="update tables set tbl_name=? where tbl_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setString(1, ob.getName());
           pst.setInt(2, ob.getId());
          count=pst.executeUpdate();
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       }
       return count;
    }
    public int deleteTable(int id)
    {
        int count=0;
        try
        {
           Connection con=DBConnection.getConnection();
           String sql="delete from tables where tbl_id=?";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,id);
           count=pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
    }
     public List<AddTables> loadTable()
    {
        List<AddTables> ats=new ArrayList();
        
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="select t.tbl_name,t.tbl_id from tables t left join orders o on t.tbl_id=o.table_id where o.id is null";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                AddTables at=new AddTables();
                at.setId(rs.getInt("tbl_id"));
                at.setName(rs.getString("tbl_name"));
                ats.add(at);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return ats;
    }
}
