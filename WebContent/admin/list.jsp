<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ include file="include/header.jsp" %>
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
				<div class="col-md-10">
					<table class="table">
					  <thead>
					    <tr>
					      <th>编号</th>
					      <th>标题</th>
					      <th>分类</th>
					      <th>日期</th>
					      <th>作者</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td>Mark</td>
					      <td>Otto</td>
					      <td>@mdo</td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td>Jacob</td>
					      <td>Thornton</td>
					      <td>@fat</td>
					      <td></td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td>Larry</td>
					      <td>the Bird</td>
					      <td>@twitter</td>
					      <td></td>
					    </tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>