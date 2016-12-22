package com.service.util;
import java.sql.*;
public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/followme?useUnicode=true&characterEncoding=UTF-8";
	private static final String username = "root";
	private static final String password = "root";
	
	private static Connection conn=null;
	
	static
	{
		try{
			Class.forName(driver);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	//单例模式，返回数据库连接对象
	public static Connection getConnection() throws SQLException
	{
		if(conn == null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	public static void main(String args[])
	{
		try{
			Connection conn = DBHelper.getConnection();
			if(conn != null)
			{
				System.out.println("zhenchang");
			}
			else
			{
				System.out.println("error");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}

