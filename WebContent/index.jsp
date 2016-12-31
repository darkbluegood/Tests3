<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Category category = new Category();
		ArrayList<Category> arraylist = category.getClasses();
	%>
	<ul>
	<%
		for(Category c : arraylist){
	%>
			<%
				if(c.getFid() ==0){
			%>
			<li><%= c.getName() %></li>
			<%
				}
			%>
		<%
		}
		%>
		
	</ul>
</body>
</html>