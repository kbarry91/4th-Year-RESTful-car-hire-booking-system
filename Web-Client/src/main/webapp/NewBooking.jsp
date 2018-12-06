<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ie.gmit.sw.Consumer.Controller"%>
<%@page import="ie.gmit.sw.models.*"%>


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
		
		<title>New Vehicle Booking</title>
		
	</head>
	<body>
		 <h1>New Booking created and added to Database....</h1>
		 <form method="get" action="index.jsp">
				<button type="submit"  class="btn btn-secondary">Return to home page</button>
		</form>
		<%
			// Create new instance of controller and booking objects
			Controller controller = new Controller();
			Booking booking= new Booking();
			
			booking.setBookingId(Integer.parseInt(request.getParameter("booking_id")));
			booking.setCustId(Integer.parseInt(request.getParameter("customer_id")));
			booking.setVehicleId(Integer.parseInt(request.getParameter("vehicle_id")));
			booking.setStartDate("start_date");
			booking.setEndDate("end_date");
			
			controller.createBooking(booking);
		%>
		<form method="get" action="index.jsp">
				<button type="submit"  class="btn btn-secondary">Return to home page</button>
		</form>
		
	
	</body>
</html>