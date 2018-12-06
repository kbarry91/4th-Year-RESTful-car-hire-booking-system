<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ie.gmit.sw.Consumer.*"%>
<%@page import="ie.gmit.sw.models.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Booking Update confirmed</title>
</head>

<body>
		 <h1>New Booking updated and added to Database....</h1>

	<%	
		// Create new instance of controller and booking objects
		Controller controller = new Controller();
		Booking booking= new Booking();
		String startDate = (request.getParameter("start_date"));
		String endDate = (request.getParameter("end_date"));

		booking.setBookingId(Integer.parseInt(request.getParameter("booking_id")));
		booking.setCustId(Integer.parseInt(request.getParameter("customer_id")));
		booking.setVehicleId(Integer.parseInt(request.getParameter("vehicle_id")));
		booking.setStartDate("start_date");
		booking.setEndDate("end_date");

		controller.updateBooking(booking);
	%>

	<h3>Booking Reference has been updated</h3>
	<form method="get" action="index.jsp">
				<button type="submit"  class="btn btn-secondary">Return to home page</button>
	</form>

</body>
</html>