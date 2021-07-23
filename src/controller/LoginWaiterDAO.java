/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.LoginWaiters;
import util.DBConnection;

/**
 *
 * @author Prabhakar
 */
public class LoginWaiterDAO {
    public int login(LoginWaiters lws)
    {
      int count=0;
      try
      {
          Connection con=DBConnection.getConnection();
          String sql="select * from waiter where username=? and password=?";
          PreparedStatement pst=con.prepareStatement(sql);
          pst.setString(1, lws.getUsername());
          pst.setString(2, lws.getPassword());
          ResultSet rs=pst.executeQuery();
          while(rs.next())
          {
              count=rs.getInt("waiter_id");
          }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return count;
    }
    
}
