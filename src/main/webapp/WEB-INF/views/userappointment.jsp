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

<title>My Appointments</title>
<style>
   td{
    border: 1px solid #333;
    text-align: center;
   }
   table {
    width: 90%;
    border: 1px solid #333;
   }

   th {
    height: 30px;
    text-align: center;
    border: 1px solid #333;
   }
  </style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">HealthCare</a>
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right">
			<li><a href="viewprofile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
				<li><a href="signup"><span class="glyphicon glyphicon-log-in"></span>Sign Up</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">

		<div class="row">
			<h2 id="heading" class="text-center">Your appointments</h2>
			<div class="col-lg-2"></div>

			<div class="col-lg-8">				
				<div class="form-group" class="sr-only">
					<label for="firstName">${tabledata}</label> 
				</div>
			</div>

			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>