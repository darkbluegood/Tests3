<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ page import="entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="include/header.jsp" %>
<%
	Category category = new Category();
	ArrayList<Category> clist = category.getClasses();
%>
<body>
	<div class="container">
		<div class="padding">
			<div class="row">
				<div class="sidebar col-md-2">
					<ul>
						<li><a href="add.jsp">添加新闻</a></li>
						<li><a href="list.jsp">新闻列表</a></li>
						<li><a href="category.jsp">新闻分类</a></li>
					</ul>
				</div>
				<div class="col-md-6">
					<form>
						<div class="form-group">
				    		<input type="text" class="form-control" id="" placeholder="请输入标题">
				    	</div>
				    	<div class="form-group">
					    	<select class="c-select form-control">
							  <option selected>选择分类</option>
							  <%
							  	for(Category c : clist){
							  		if(c.getFid() == 0){
							  			
							  		
							  %>
							  		<option value="<%= c.getId() %>"><%= c.getName() %></option>
							  		<%
								  		for(Category s : clist){
								  			if(c.getId() == s.getFid()){
								  	%>
								  		<option>---<%= s.getName() %></option>
								  	<%
								  			}
								  		}
							  		%>
							  		
							  <%
							  		}
							  	}
							  %>
							</select>
						</div>
						<div class="form-group">
							<textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>