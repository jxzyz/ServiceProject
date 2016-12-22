package com.service.util;
//商品业务逻辑
import java.util.*;
import java.util.Date;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class ItemsDAO {

	public ArrayList<Items> getAllItems()//显示所有商品简单信息
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from course;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Items item = new Items();
				item.setId(rs.getString("cou_id"));
				item.setName(rs.getString("cou_name"));
				item.setGrade(rs.getString("cou_grade"));
				item.setSubject(rs.getString("cou_subject"));
				item.setPrice(rs.getDouble("cou_price"));
				item.setUpdate(rs.getDate("cou_up_date"));
				item.setIntro(rs.getString("cou_intro"));
				item.setTime(rs.getDate("cou_time"));
				item.setTeach_way(rs.getString("cou_teach_way"));
				item.setTea_email(rs.getString("tea_email"));
				list.add(item);
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
	public ArrayList<Items> getIdItem(String id)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from course where cou_id = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Items item = new Items();
				item.setId(rs.getString("cou_id"));
				item.setName(rs.getString("cou_name"));
				item.setGrade(rs.getString("cou_grade"));
				item.setSubject(rs.getString("cou_subject"));
				item.setPrice(rs.getDouble("cou_price"));
				item.setUpdate(rs.getDate("cou_up_date"));
				item.setIntro(rs.getString("cou_intro"));
				item.setTime(rs.getDate("cou_time"));
				item.setTeach_way(rs.getString("cou_teach_way"));
				item.setTea_email(rs.getString("tea_email"));
				list.add(item);
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
	public ArrayList<Items> getSearchItems(String s)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from course where cou_name like '%"+s+"%' or cou_subject like '%"+s+"%' ;";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Items item = new Items();
				item.setId(rs.getString("cou_id"));
				item.setName(rs.getString("cou_name"));
				item.setGrade(rs.getString("cou_grade"));
				item.setSubject(rs.getString("cou_subject"));
				item.setPrice(rs.getDouble("cou_price"));
				item.setUpdate(rs.getDate("cou_up_date"));
				item.setIntro(rs.getString("cou_intro"));
				item.setTime(rs.getDate("cou_time"));
				item.setTeach_way(rs.getString("cou_teach_way"));
				item.setTea_email(rs.getString("tea_email"));
				System.out.println(item.getName());
				list.add(item);
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
	@SuppressWarnings("resource")
	public ArrayList<Items> getIdItem(String id,String email)//按id和客户id来搜索，目的在于添加浏览集
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from browse where cou_id = '"+id+"' and stu_email = '"+email+"';";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(!rs.next())
			{	Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				String sql1 = "insert into browse(stu_email,cou_id,bro_date,bro_concerned)values('"+email+"','"+id+"','"+time+"',1);";
				System.out.println(sql1);
				stmt = conn.prepareStatement(sql1);
			    stmt.executeUpdate();
			}
			return getIdItem(id);
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
	@SuppressWarnings("resource")
	public void setSearch(String e,String s)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBHelper.getConnection();
			String sql = "select * from search where stu_email = '"+e+"' and sea_content = '"+s+"';";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(!rs.next())
			{	Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				String sql1 = "insert into search(stu_email,sea_date,sea_content)values('"+e+"','"+time+"','"+s+"');";
				System.out.println(sql1);
				stmt = conn.prepareStatement(sql1);
			    stmt.executeUpdate();
			}
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