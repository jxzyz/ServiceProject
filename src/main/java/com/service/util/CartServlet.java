package com.service.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String id = request.getParameter("id");
		String stu_email = request.getParameter("stu_email");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int price = 0;
		
		try{
			if(stu_email.equals("null"))
			{
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.println("You have to login in first.");
				out.println("<br/>");
				out.println("<a href = search.jsp?stu_email="+stu_email+">go back</a>");
			}
			else
			{
			conn = DBHelper.getConnection();
			String sql = "select * from buy where cou_id ='"+id+"' and stu_email = '"+stu_email+"';";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				String sql2 = "select cou_price from course where cou_id ='"+id+"';";
				stmt = conn.prepareStatement(sql2);
				ResultSet rs1 = stmt.executeQuery();
				if(rs1.next())
					{ price = rs1.getInt("cou_price");}
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				System.out.println(time);
				String sql1 = "insert into buy(stu_email,cou_id,buy_price,buy_date,buy_state)values('"+stu_email+"','"+id+"',"+price+",'"+time+"',0);";
				System.out.println(sql1);
				stmt = conn.prepareStatement(sql1);
			    stmt.executeUpdate();
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.println("success");
				out.println("<br/>");
				out.println("<a href = search.jsp?stu_email="+stu_email+">go back</a>");
			}
			else
			{
				PrintWriter out = response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.println("done before");
				out.println("<br/>");
				out.println("<a href = search.jsp?stu_email="+stu_email+">go back</a>");
			}
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
