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
import model.AddItemWaiter;

import util.DBConnection;

/**
 *
 * @author Prabhakar
 */
public class OrderDAO {
    public int addOrder(List<AddItemWaiter> aiw)
    {
        int count=0;
        try
        {
           Connection con= DBConnection.getConnection();
           con.setAutoCommit(false);
           String sql="insert into orders (qty,menu_id,table_id,waiter_id) values (?,?,?,?)";
           for(int i=0;i<aiw.size();i++)
            {
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1, aiw.get(i).getQty());
                    pst.setInt(2, aiw.get(i).getId());
                    pst.setInt(3, aiw.get(i).getTable_id());
                    pst.setInt(4, aiw.get(i).getWaiter_id());
                    pst.execute();
                    con.commit();
            }
           count++;
        }
        catch(Exception ex)
        {
            System.out.println(ex);   
        }
        return count;
    }
    public List<AddItemWaiter> viewOrder(int id)
    {
        List<AddItemWaiter>  laiw=new ArrayList();
        try
        {
            Connection con=DBConnection.getConnection();
            String sql="SELECT menu.name,menu.price,orders.id,orders.qty,orders.qty*menu.price as total from menu INNER JOIN orders on orders.menu_id=menu.menu_id where orders.table_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                AddItemWaiter aiw=new AddItemWaiter();
                aiw.setName(rs.getString("name"));
                aiw.setPrice(rs.getString("price"));
                aiw.setQty(rs.getString("qty"));
                aiw.setTotal(rs.getDouble("total"));
                aiw.setOrder_id(rs.getInt("id"));
                laiw.add(aiw);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return laiw;
    }
    
}
