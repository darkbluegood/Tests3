<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="entity.Category" %>
<%@ page import="entity.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style>
		.list>li{ float:left;list-style:none;padding-left:1px; }
		.list>li>a{ display:block;border-right:1px solid #ccc;margin-left: 15px;padding-right: 15px; }
		.submenu{ background:#aaa;margin-top:10px; }
		.submenu a{ display:block;text-align:center; padding:5px 0;}
		.main{ clear:both;width:300px;margin: auto; }
	</style>
</head>
<body>
	<%
		Category category = new Category();
		ArrayList<Category> arraylist = category.getClasses();
	%>
	<ul class="list">
	<%
		for(Category c : arraylist){
	%>
			<%
				if(c.getFid() ==0){
			%>
			<li><a href=""><%= c.getName() %></a>
				<div class="submenu">
					<% for(Category s : arraylist){ %>
						<% if(s.getFid() == c.getId()){ %>
						<a href=""><%= s.getName() %></a>
						<% } %>
					<% } %>
				</div>
			</li>
			<%
				}
			%>
		<%
		}
		%>
	</ul>
	<%
		List list = new List();
		ArrayList<List> getLists = list.getList();
	%>
	<div class="main">
		<ul>
			<%
				for(List l : getLists){
			%>
				<li><a href="content.jsp?id=<%= l.getId() %>"><%= l.getTitle() %></a></li>
			<%
				}
			%>
		</ul>
	</div>
</body>
</html>