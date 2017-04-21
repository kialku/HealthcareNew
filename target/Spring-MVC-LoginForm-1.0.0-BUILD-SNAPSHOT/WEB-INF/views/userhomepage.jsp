<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- your webpage info goes here -->
<title>health care @ home</title>
<meta name="author" content="your name">
<meta name="description" content="">
<!-- you should always add your stylesheet (css) in the head tag so that
    it starts loading before the page html is being displayed -->
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<!-- webpage content goes here in the body -->
	<div id="page">
		<div id="logo">
			<h1>
				<a href="/" id="logoLink">health care @ home</a>
			</h1>
		</div>
		<div id="nav">
			<ul>
				<li><a href="<c:url value="/newappointment" />">New
						Appointment</a></li>
				<li><a href="<c:url value="/cancelappointment" />">Cancel
						Appointment</a></li>
				<li><a href="<c:url value="/myappointments" />">Show
						Appointments</a></li>
			</ul>
			<footer class="section section-primary">
				<div class="container">
					<div class="row">
						<div class="col-sm-6">
							<p class="text-info text-right">
								<br> <br>
							</p>
							<div class="row">
								<div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
									<a href="#"><i
										class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> <a
										href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
									<a href="#"><i
										class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> <a
										href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 hidden-xs text-right">
									<a href="#"><i
										class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a> <a
										href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
									<a href="#"><i
										class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a> <a
										href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>


</body>
</html>