
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ include file="include/header.jsp" %>
<%@ page import="entity.Category" %>
<%@page import="java.sql.ResultSet"%>
<body ng-app="app" ng-controller="categoryCtrl">
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
					<a href="javascript:void(0)" ng-click="parentadd()">添加大类</a>
					<%
						Category category = new Category();
						ArrayList<Category> clist = category.getClasses();

						for(Category c : clist){
							if(c.getFid() == 0){
					%>
					<div class="class_block">
						<div class="header clearfix">
							<h3><%=c.getName() %></h3>
							<a href="<%= request.getContextPath() %>/CategoryServlet?type=del_p&id=<%= c.getId() %>" class="delClass">删除</a>
							<span class="newClass" ng-click="subadd(<%=c.getId() %>)">添加</span>
							
						</div>
						<div class="content padding5">
							<ul class="list">
							<%
								for(Category s : clist){
									if(s.getFid() == c.getId()){
							%>
								<li><%=s.getName() %> <a href="<%= request.getContextPath() %>/CategoryServlet?type=del_s&id=<%= s.getId() %>" class="del">删除</a></li>
							<%
									}
								}
							%>
							</ul>
						</div>
					</div>

					<% }} %>
					
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="dialog" ng-if="parentclass">
		<div class="panel panel-default">
		  <div class="panel-heading clearfix">
		    <h3 class="panel-title">添加类名</h3>
		    <span class="panel-close" ng-click="close()">close</span>
		  </div>
		  <div class="panel-body">
		    <form class="form-inline" action="<%= request.getContextPath() %>/CategoryServlet" method="POST">
		    	<input type="hidden" name="type" value="parentclass" />
		    	<input type="hidden" name="fid" value="0" />
			  <div class="form-group">
			    <input type="text" class="form-control" id="" name="name" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary">保存</button>
			</form>
		  </div>
		</div>
	</div>
	
	<div class="dialog" ng-if="subclass">
		<div class="panel panel-default">
		  <div class="panel-heading clearfix">
		    <h3 class="panel-title">添加类名</h3>
		    <span class="panel-close" ng-click="close()">close</span>
		  </div>
		  <div class="panel-body">
		    <form class="form-inline" action="<%= request.getContextPath() %>/CategoryServlet" method="POST">
		    	<input type="hidden" name="type" value="subclass" />
		    	<input type="hidden" name="fid" ng-model="fid" value="{{fid}}" />
			  <div class="form-group">
			    <input type="text" class="form-control" id="" name="name" placeholder="">
			  </div>
			  <button type="submit" class="btn btn-primary">保存</button>
			</form>
		  </div>
		</div>
	</div>
</body>
<script>
	var app = angular.module("app",[]);
	app.run(function(){
		console.log("11")
	}).controller("categoryCtrl",function($scope){
		$scope.parentadd = function(){
			$scope.parentclass = true;
		}
		$scope.subadd = function(id){
			$scope.subclass = true;
			$scope.fid = id;
		}
		$scope.close = function(){
			$scope.parentclass = false;
			$scope.subclass = false;
		}
	});
</script>
</html>