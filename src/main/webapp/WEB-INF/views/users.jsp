<%@page import="com.spring.controller.SignupDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Healthcare - Admin</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">Healthcare</a>
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="viewprofile"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
				<li><a href="signup"><span class="glyphicon glyphicon-log-out"></span> Sign Up</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<table id="users-table" class="table table-bordered">
					<tr>
						<th>
							First Name
						</th>
						<th>
							Last Name
						</th>
						<th>
							Date Of Birth
						</th>
						<th>
							Phone
						</th>
						<th>
							Email
						</th>
						<th>
							City
						</th>
						<th>
							PIN
						</th>
					</tr>
					<c:forEach items="${users }" var="user">
						<tr>
							<td>${user.firstName }</td>
							<td>${user.lastName }</td>
							<td>${user.dob }</td>
							<td>${user.mobile }</td>
							<td>${user.email }</td>
							<td>${user.city }</td>
							<td>${user.pincode }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-lg-2"></div>
		</div>
</body>
</html>