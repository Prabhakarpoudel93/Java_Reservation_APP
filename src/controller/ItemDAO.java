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

import model.AddItem;
import util.*;

/**
 *
 * @author Prabhakar
 */
public class ItemDAO {
    public static int addMenu(AddItem ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="insert into menu(name,price,description) values (?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, ob.getItemName());
            pst.setDouble(2, ob.getPrice());
            pst.setString(3, ob.getDescription());
            count = pst.executeUpdate();
            
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return count;
    }
    public List<AddItem> getMenu()
    {
        List<AddItem> addItemList=new ArrayList();
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="select * from menu";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                AddItem ai=new AddItem();
                ai.setId(rs.getInt("menu_id"));
                ai.setItemName(rs.getString("name"));
                ai.setPrice(rs.getDouble("price"));
                ai.setDescription(rs.getString("description"));
                addItemList.add(ai);
            }
        }
        catch(Exception ex)
        {
            System.out.println();
        }
        return addItemList;
    }
    public int updateItem(AddItem ob)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="update menu set name=?,price=?,description=? where menu_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ob.getItemName());
            pst.setDouble(2,ob.getPrice());
            pst.setString(3,ob.getDescription());
            pst.setInt(4,ob.getId());
            count=pst.executeUpdate();
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return count;
    }
    public int deleteItem(int id)
    {
        int count=0;
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="delete from menu where menu_id=?";
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
