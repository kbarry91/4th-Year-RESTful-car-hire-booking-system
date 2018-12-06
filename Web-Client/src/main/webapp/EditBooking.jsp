<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ie.gmit.sw.Consumer.*"%>
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
	
	<title>Update  Booking</title>
	</head>
<body>
	<%
		Controller controller = new Controller();
		int id = Integer.parseInt(request.getParameter("id"));
		Booking booking = controller.getBookingId(id);
	%>

	<h1>
		Update vehicle booking
		<%=booking.getBookingId()%>
	</h1>

	<div class="form-group">
		<form method="post" action="UpdatedBooking.jsp">
			Booking ID:<br> <input type="text" class="form-control"
				name="booking_id" value="<%=booking.getBookingId()%>"><br>
			Customer ID:<br> <input type="text" class="form-control"
				name="customer_id"
				value="<%=booking.getCustId()%>"><br>
			Vehicle ID:<br> <input type="text" class="form-control"
				name="vehicle_id" value="<%=booking.getVehicleId()%>"><br>
			Start Date:<br> <input type="text" class="form-control"
				name="start_date" value="<%=booking.getStartDate()%>"><br>
			End Date:<br> <input type="text" class="form-control"
				name="end_date" value="<%=booking.getEndDate()%>"><br>

			<input type="submit" class="btn btn-primary" value="Update">
		</form>
		
	 
	</div>

<form method="get" action="index.jsp">
				<button type="submit"  class="btn btn-secondary">Return to home page</button>
		</form>


</body>
</html>