<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h2 id="heading" class="text-center">View Profile</h2>
			<div class="col-lg-2"></div>

			<div class="col-lg-8">
				<div id="message">
				</div>
				<form action="/Spring-MVC-LoginForm-1.0.0-BUILD-SNAPSHOT/admin"
					role="form" class="signin-form form-horizontal" id="register_form"
					method="post">
					<div class="form-group" class="sr-only">
						<label for="userName">Admin UserName: </label> <span
							class="glyphicon glyphicon-user"></span><input type="text"
							class="form-control" id="userName" name="userName"
							placeholder="Enter First Name">
					</div>
					<div class="form-group" class="sr-only">
						<label for="password">Admin Password: </label><span
							class="glyphicon glyphicon-eye-open"></span> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter Your Last Name or Family Name">
					</div>
					<div class="form-group" class="sr-only">
						<input type="radio" name="action1" value="statusChange" Checked> <label for="password">Mark Appointment as Completed </label>
					</div>
					<div class="form-group form-inline" class="sr-only">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
				</form>
			</div>

			<div class="col-lg-2"></div>
		</div>

		<div class="row">
			<div class="col-lg-12">

				<div class="alert alert-danger alert-dismissible fade in"
					role="alert" id="footerMessage">${footerMessage}</div>
			</div>
		</div>
	</div>

</body>
</html>