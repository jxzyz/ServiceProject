<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.service.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的购物车</title>
<style>
body{ text-align:center} 
a:link { color: #0000cc; TEXT-DECORATION:none}
a:visited { TEXT-DECORATION:none}
a:hover {color: #FF0000; TEXT-DECORATION:none}
.div{ margin:0 auto } 
img{border:0px;vertical-align:middle;padding:0;margin:0} 
button{font-family:"Arial", "Tahoma", "微软雅黑", "雅黑";border:0;
vertical-align:middle;margin:8px;line-height:18px;font-size:18px} 
.btn{width:140px;height:36px;line-height:18px;font-size:18px;
background:url("button1.jpg") no-repeat left top;color:#FFF;padding-bottom:4px}
.btns { width:65px; height:30px; font-family:"Arial", "Tahoma", "微软雅黑", "雅黑"; background:url("button1.jpg") no-repeat left top; color:#FFF; }  
.manongjc{ width:"100%"} 
.manongjc table{ background:#5599FF; color:black} 
.manongjc table td{ background:#FFF; text-align:center}
.manongjc table{display:block;margin:0 auto;width:352px}
.manongjc table th{text-align:center; background-color:#CCC; color:black}
</style>
</head>
<body>
<%
String s = request.getParameter("stu_email"); 
if(s.equals("null"))
{
	PrintWriter pw = response.getWriter();
	response.setContentType("text/html;charset=utf-8");
	pw.println("You have to login in first.");
	pw.println("<br/>");
	pw.println("<a href = search.jsp?stu_email="+s+">go back</a>");}
else
{

%>
<h1>我的购物车</h1>

<hr/>
<br/>
<div class="div">
<input type="button" class="btn" value="我的购物车" onclick="window.location='ShoppingCart.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
<input type="button" class="btn" value="已购买课程" onclick="window.location='AlreadyPurchase.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
<input type="button" class="btn" value="全部课程" onclick="window.location='search.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
</div>
<br/>
<br/>


<form action="regservlet?stu_email=<%=s %>" method="post">
<div class="manongjc"> 
<table width="100%" border="0" cellspacing="1" cellpadding="4">
<tr>
<th>课程名称</th>
<th>课程年级</th>
<th>课程学科</th>
<th>课程价格</th>
<th>选择</th>
</tr>
<%	
	
	
	ShoppingCartDAO shoppingdao = new ShoppingCartDAO();
	ArrayList<ShoppingCart> list = shoppingdao.getItemsByState(s,0);
	if(list!=null&&list.size()>0){
	for(int i=0;i<list.size();i++)
	{
		ShoppingCart shoppingcart = list.get(i);
%>
		<tr>
			
			<td><%= shoppingcart.getCou_name()%></td>
			<td><%= shoppingcart.getCou_grade()%></td>
			<td><%= shoppingcart.getCou_subject()%></td>
			<td><%= shoppingcart.getCou_price()%></td>
			<td><input name="cou_id" type="checkbox" value=<%=shoppingcart.getCou_id() %> /></td>
			
		</tr>
<% 
		}
	  }
%>
</table> 
</div>
<br/>	

  <input type="submit" class="btns" value="pay" name="butt" 
  onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
  &nbsp;&nbsp;
  <input type="submit" class="btns" value="delete" name="butt" 
  onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
</form>

<%
}%>
  
</body>
</html>