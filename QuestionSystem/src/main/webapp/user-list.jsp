<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color:blue">
		<div>
			<a href="http://www.xadmin.net" class="navbar-brand">Question System</a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath() %>/list" class="nav-link" >Question List</a></li>
		</ul>
	</nav>
</header>
<br>
<div class="row">
	<div class="container">
		
		<h3 class="test-center">${question.questionText }</h3>
		<hr>
		<!--<div class="container text-left">
			<a href="<%=request.getContextPath() %>/new" class="btn btn-success" >Add New User</a>
		
		</div>-->
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Actions</th> 
					<!--<th>ID</th>-->
					<th>Answer</th>
					<th>Choice</th>
				<!--<th>Country</th>-->
					 
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="user" items="${listUser}">
					<tr>
					
						<td>
						 <!--<a href="edit?id=<c:out value='${user.id }'/>">Edit</a>
							&nbsp;&nbsp;
							<a href="delete?id=<c:out value='${user.id }'/>">Delete</a>
							&nbsp;&nbsp;-->
							<a href="choose?id=<c:out value='${user.id}'/> ">Choose</a>
						</td>					
						<!--<td> <c:out value="${user.id}"/> </td>-->
						<td> <c:out value="${user.name}"/> </td>
						<td> <c:out value="${user.email}"/> </td>
					<!--	<td> <c:out value="${user.country}"/> </td>-->

						
					</tr>				
				</c:forEach>
			
			
			</tbody>
			
		</table>
		<h3 class="test-center">What you choose is:  ${question.cid }</h3>
	</div>

</div>

</body>
</html>