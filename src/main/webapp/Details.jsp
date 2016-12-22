<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.service.util.*" %>
 <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程详细信息</title>
<style>
body{ text-align:center} 
a:link { color: #0000cc; TEXT-DECORATION:none}
a:visited { TEXT-DECORATION:none}
a:hover {color: #FF0000; TEXT-DECORATION:none}
.manongjc{ width:"100%"} 
.manongjc table{ background:#5599FF; color:black} 
.manongjc table td{ background:#FFF; text-align:center}
.manongjc table{display:block;margin:0 auto;width:701px}
.manongjc table th{text-align:center; background-color:#CCC; color:black}
</style> 
</head>
<body>
<div class="manongjc"> 
<table width="100%" border="0" cellspacing="1" cellpadding="4">
<tr>
<th>课程号</th><th>课程名</th><th>对应科目</th><th>上传时间</th><th>上课时间</th>
<th>上课方式</th><th>课程介绍</th><th>价格</th><th>是否加入购物车</th>
</tr>
<%
	String s3 = request.getParameter("stu_email");
	ItemsDAO itemDao = new ItemsDAO();
	ArrayList<Items> list =  itemDao.getIdItem(request.getParameter("id"),request.getParameter("stu_email"));
	if(list!=null&&list.size()>0){
	for(int i=0;i<list.size();i++)
	{
		Items item = list.get(i);
%>
		<tr>
			<td><%= item.getId()%></td>
			<td><%= item.getName()%></td>
			<td><%= item.getSubject()%></td>
			<td><%= item.getUpdate() %></td>
			<td><%= item.getTime()%></td>
			<td><%= item.getTeach_way()%></td>
			<td><%= item.getIntro()%></td>
			<td><%= item.getPrice()%></td>
			<td><a href = "CartServlet?id=<%= item.getId() %>&stu_email=<%= s3%>">添加至购物车</a></td>
		</tr>
<% 
	}
	}
%>


	</table>
</div>
</body>
</html>