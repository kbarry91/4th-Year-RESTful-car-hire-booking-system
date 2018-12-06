package ie.gmit.sw.Consumer;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.utils.*;
import ie.gmit.sw.models.*;

/**
 * RestAcces allows the client interact with the REST SERVER
 */
public class RestAccess extends BookingMarshal {
	private String base = "http://localhost:8080/WebService/webapi/bookingresource/";

	// Factory class to create a client object.
	private Client client = ClientBuilder.newClient();

	// Connect target.
	private WebTarget target = client.target(base);

	private String xmlResponse;
	private String send;
	Response response;

	/*
	 * Get a list of all booking objects
	 */
	public List<Booking> getBookings() {
		// Make request.
		xmlResponse = target.request(MediaType.APPLICATION_XML).get(String.class);
		Bookings bookings = getBookingsFromXML(xmlResponse);
		List<Booking> bookingList;
		bookingList = bookings.getBooking();
		return bookingList;

	}

	public Booking getBookingById(int id) {
		target = client.target(base + "/" + id);
		xmlResponse = target.request(MediaType.APPLICATION_XML).get(String.class);
		Booking newBooking = getBookingFromXML(xmlResponse);
		return newBooking;

	}

	public void updateBooking(Booking booking) {
		target = client.target(base + "/" + booking.getBookingId());
		send = getBookingAsXML(booking);
		response = target.request().put(Entity.xml(send));
		System.out.println(response);

	}

	public void createBooking(Booking booking) {
		target = client.target(base);
		send = getBookingAsXML(booking);
		response = target.request().post(Entity.xml(send));
		System.out.println(response);
	}

	public void deleteBooking(int id) {
		target = client.target(base + "/" + id);
		response = target.request().delete();
		System.out.println(response);

	}

}
