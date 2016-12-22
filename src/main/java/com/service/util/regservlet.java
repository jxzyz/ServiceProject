package com.service.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regservlet
 */
@WebServlet("/regservlet")
public class regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public regservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String s = request.getParameter("stu_email");
		String a = request.getParameter("butt");
		
		
		
		
		try
		{	
			if(a.equals("pay")){
			if(request.getParameterValues("cou_id")==null)
			{
				response.setContentType("text/html;charset=utf-8");
				out.println("You have not chosen even one course!<br/>");
				out.println("<a href=ShoppingCart.jsp?stu_email="+s+"><input type='button' value='Return to Shoppingcart'></a>");
			}
			else{
			String[] cou_ids = request.getParameterValues("cou_id");
			ShoppingCartDAO shoppingcartDAO = new ShoppingCartDAO();
			for(int i=0; i<cou_ids.length;i++)
			{
				shoppingcartDAO.change_state(cou_ids[i]);
			}
			//request.getRequestDispatcher("../serach.jsp").forward(request,response);
			response.setContentType("text/html;charset=utf-8");
			out.println("You have completed the purchase!<br/>");
			
			out.println("<a href=ShoppingCart.jsp?stu_email="+s+"><input type='button' value='Return to Shoppingcart'></a>");
			out.println("<a href=AlreadyPurchase.jsp?stu_email="+s+"><input type='button' value='Go to Already Purchase'></a>");
		
			}
			}
			else if(a.equals("delete"))
			{
				if(request.getParameterValues("cou_id")==null)
				{
					response.setContentType("text/html;charset=utf-8");
					out.println("You have not chosen even one course!<br/>");
					out.println("<a href=ShoppingCart.jsp?stu_email="+s+"><input type='button' value='Return to Shoppingcart'></a>");
				}
				else{
					String[] cou_ids = request.getParameterValues("cou_id");
					ShoppingCartDAO shoppingcartDAO = new ShoppingCartDAO();
					for(int i=0; i<cou_ids.length;i++)
					{
						shoppingcartDAO.delete(cou_ids[i]);
					}
					//request.getRequestDispatcher("../serach.jsp").forward(request,response);
					response.setContentType("text/html;charset=utf-8");
					out.println("You have completed the delete!<br/>");
					
					out.println("<a href=ShoppingCart.jsp?stu_email="+s+"><input type='button' value='Return to Shoppingcart'></a>");
					out.println("<a href=AlreadyPurchase.jsp?stu_email="+s+"><input type='button' value='Go to Already Purchase'></a>");
				
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
		
	}

}
