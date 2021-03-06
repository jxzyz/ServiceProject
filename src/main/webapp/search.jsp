<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.service.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>全部课程</title>
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
.btns { width:60px; height:25px; background:url("button1.jpg") no-repeat left top; color:#FFF; }  
.manongjc{ width:"100%"} 
.manongjc table{ background:#5599FF; color:black} 
.manongjc table td{ background:#FFF; text-align:center}
.manongjc table{display:block;margin:0 auto;width:501px}
.manongjc table th{text-align:center; background-color:#CCC; color:black}
</style> 
</head>
<body>
<form action ="index.jsp" method = "get">
搜索课程：<input type="text" name="cou" />
<input type="hidden" name = "stu_email" value = "<%= request.getParameter("stu_email") %>">
<input type="submit" class="btns" name = "commit" value ="搜索" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'">
</form>
<br/>
<div class="div">
<input type="button" class="btn" value="我的购物车" onclick="window.location='ShoppingCart.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'" >
<input type="button" class="btn" value="已购买课程" onclick="window.location='AlreadyPurchase.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'" >
<input type="button" class="btn" value="全部课程" onclick="window.location='search.jsp?stu_email=<%= request.getParameter("stu_email")%>'" 
onmouseover="this.style.backgroundPosition='left -36px'" onmouseout="this.style.backgroundPosition='left top'" >
</div>
<br/>
<br/>

<div class="manongjc"> 
<table width="100%" border="0" cellspacing="1" cellpadding="4">
<tr>
<th>课程号</th>
<th>课程名</th>
<th>年级</th>
<th>上课时间</th>
<th>老师邮箱</th>
<th>价格</th>
<th>是否加入购物车</th>
</tr>
<%
	int pagesize=15;
	int curPage = 0;
	int pagecount=0;
	String s3 = request.getParameter("stu_email");
	String tmp = request.getParameter("curPage");
	if(tmp == null)
	{
		tmp = "0";
	}
	curPage = Integer.parseInt(tmp);
	ItemsDAO Itemdao = new ItemsDAO();
	ArrayList<Items> list = Itemdao.getAllItems();
	try{
	pagecount=(list.size()%pagesize==0)?(list.size()/pagesize):(list.size()/pagesize+1);
	if(list!=null&&list.size()>0){
//	for(int i=0;i<list.size();i++)
	for(int i=0+15*curPage;i>=0&&i<list.size()&&i<(curPage+1)*15;i++)
	{
		Items item = list.get(i);
%>
		<tr>
			<td><%= item.getId()%></td>
			<td><a href = "Details.jsp?id=<%= item.getId()%>&stu_email=<%= s3%>"><%= item.getName()%></a></td>
			<td><%= item.getGrade() %></td>
			<td><%= item.getTime() %></td>
            <td><%= item.getTea_email()%></td>
			<td><%= item.getPrice()%></td>
			<td><a href = "CartServlet?id=<%= item.getId() %>&stu_email=<%= s3%>">添加至购物车</a></td>
		</tr>
<% 
		}
	  }
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
%>
</table>
</div>
<br/>
<a href = "search.jsp?curPage=0&stu_email=<%= s3%>" >首页</a>
<a href = "search.jsp?curPage=<%=curPage-1%>&stu_email=<%= s3%>" >上一页</a>
<a href = "search.jsp?curPage=<%=curPage+1%>&stu_email=<%= s3%>" >下一页</a>
第<%=curPage+1 %>页/共<%=pagecount %>页
</body>
</html>