package com.service.util;
import java.util.*;


import java.sql.*;
public class ShoppingCartDAO {
	public ArrayList<ShoppingCart> getItemsByState(String s,int i)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from course natural join buy where buy.buy_state = "+i+" and buy.stu_email = '"+s+"';";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				ShoppingCart shoppingcart = new ShoppingCart();
				shoppingcart.setStu_email(rs.getString("stu_email"));
				shoppingcart.setCou_id(rs.getString("cou_id"));
				shoppingcart.setCou_price(rs.getDouble("cou_price"));
				shoppingcart.setCou_name(rs.getString("cou_name"));
				shoppingcart.setCou_grade(rs.getString("cou_grade"));
				shoppingcart.setCou_subject(rs.getString("cou_subject"));
				list.add(shoppingcart);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			if(rs!=null)
			{
				try{
				rs.close();
				rs=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try{
				stmt.close();
				stmt=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	public void change_state(String s)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "update buy set buy_state=1 where cou_id='"+s+"'";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();

		}
		finally
		{
			if(rs!=null)
			{
				try{
				rs.close();
				rs=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try{
				stmt.close();
				stmt=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	public void delete(String s)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "delete from buy where cou_id='"+s+"'";
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();

		}
		finally
		{
			if(rs!=null)
			{
				try{
				rs.close();
				rs=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try{
				stmt.close();
				stmt=null;}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}
