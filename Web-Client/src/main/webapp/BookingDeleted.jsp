<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ie.gmit.sw.Consumer.*"%>
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
		<title>Confirmed Booking Deleted</title>
	</head>
	
	<body>
		<%
			Controller controller = new Controller();
			int bookingId = Integer.parseInt(request.getParameter("booking_id"));
			controller.Delete(bookingId);
		%>
	
		<h1>
			The Booking for your vehicle with the ID
			<%=Integer.parseInt(request.getParameter("booking_id"))%>
			has been removed from the booking database.
		</h1>
		
	 	<form method="get" action="index.jsp">
			<button type="submit"  class="btn btn-secondary">Return to home page</button>
		</form>
	</body>
</html>