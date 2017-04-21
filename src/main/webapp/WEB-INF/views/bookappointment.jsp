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
	
<script type="text/javascript">
function FormValidation(){ 
    var fn=document.getElementById('email').value;
    if(fn == ""){
        document.getElementById('email').style.bordercolor = "red";
        return false;
    }
    var pswd=document.getElementById('pwd').value;
    if(pswd == ""){
        document.getElementById('pwd').style.bordercolor = "red";
        return false;
    }
    var date=document.getElementById('doa').value;
    if(date == ""){
        document.getElementById('doa').style.bordercolor = "red";
        return false;
    }else {
    	
    }
    var time=document.getElementById('toa').value;
    if(time == ""){
        document.getElementById('toa').style.bordercolor = "red";
        return false;
    }
    return true;
}



</script>

<title>Book Appointment</title>
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
				<li><a href="signup"><span class="glyphicon glyphicon-log-in"></span> SignUp</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<h2 id="heading" class="text-center">Enter following details to book an appointment</h2>
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form action="/Spring-MVC-LoginForm-1.0.0-BUILD-SNAPSHOT/newappointment"
					role="form" class="signin-form form-horizontal" id="appointment_form"
					method="post" onsubmit="return FormValidation();">
					
					<div class="form-group" class="sr-only">
						<label for="email">Email Id: </label><span
							class="glyphicon glyphicon-envelope"></span> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Enter E-mail id">
					</div>

					<div class="form-group" class="sr-only">
						<label for="pwd">Password: </label> <input type="password"
							class="form-control" id="pwd" name="password"
							placeholder="Enter Password">
					</div>
					
					<div class="form-group" class="sr-only">
						<label for="doa">Date of Appointment: </label></span><input type="text"
							class="form-control" id="doa" name="doa"
							placeholder="Enter Date of Appointment dd/mm/yyyy">
					</div>

					<div class="form-group" class="sr-only">
						<label for="toa">Time of Appointment: </label></span><input type="text"
							class="form-control" id="toa" name="toa"
							placeholder="Enter Time in 24-hour format HH:MM">
					</div>


					<div class="form-group" class="sr-only">
						<label for="serviceName">Service: </label>
						<select name="serviceName">  
						    <option value="NONE">--- Select ---</option>  
							<option value="Lab Tests">Lab Tests</option>
							<option value="Doctor Visit">Doctor Visit</option>
							<option value="Nursing">Nursing</option>
							<option value="Massage Therapy">Massage Therapy</option>
							<option value="Physio Therapy">Physio Therapy</option>
							<option value="Dental Checkup">Dental Checkup</option>
							<option value="Eye Checkup">Eye Checkup</option>
						</select>
					</div>

					<div class="form-group" class="sr-only">
						<label for="serviceProvider">Service: </label>
						<select name="serviceProvider">
							<option value="NONE">--- Select ---</option>        
							<option value="Anand Lab">Anand Lab</option>
							<option value="GK Lab">GK Lab</option>
						</select>
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