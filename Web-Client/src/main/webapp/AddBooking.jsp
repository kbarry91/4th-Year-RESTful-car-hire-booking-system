<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new booking</title>
</head>
<body>

	<h1>Enter all details to add a new booking</h1>

	<div class="form-group">
		<form method="post" action="NewBooking.jsp">
			Booking Reference ID:
			<br> 
			<input type="text" class="form-control" name="booking_id" value="000">
			
			<br>Customer Reference ID:<br>
			<input type="text" class="form-control" name="customer_id" value="000">
			
			<br>Vehicle Reference ID:<br> 
			<input type="text" class="form-control" name="vehicle_id" value="000">
			
			<br>Booking Start Date:<br>
			 <input type="text" class="form-control" name="start_date" value="dd-mm-yyyy">
			 
			<br> Booking Return Date:<br>
			<input type="text" class="form-control" name="end_date" value="dd-mm-yyyy">
			
			<br> 
			
			<input type="submit" class="btn btn-primary" value="Create">
			
			
		</form>
		<form method="get" action="index.jsp">
				<button type="submit"  class="btn btn-secondary">Cancel Booking</button>
		</form>

	</div>

</body>
</html>