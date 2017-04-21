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

<title>HealthCare</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">HealthCare</a>
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
			<h2 id="heading" class="text-center">Home Page</h2>
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
			<div>
				<ul class="nav">
					<li><a href="newappointment"><span class="glyphicon glyphicons-user"></span> New Appointment</a></li>
					<li><a href="cancelappointment"><span class="glyphicon glyphicons-floppy-remove"></span> Cancel Appointment</a></li>
					<li><a href="viewappointments"><span class="glyphicon glyphicons-history"></span> My Appointments</a></li>
				</ul>
			</div>
			</div>
			<div class="col-lg-2"></div>
		</div>
		<div class="row"></div>
	</div>

</body>
</html>