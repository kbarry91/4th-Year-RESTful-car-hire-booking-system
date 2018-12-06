package ie.gmit.sw.WebService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.models.Booking;
import ie.gmit.sw.rmi.RMIClient;
import ie.gmit.sw.utils.*;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookingresource")
public class MyResource extends BookingMarshal {
	RMIClient bc = new RMIClient();
	List<Booking> bookings = new ArrayList<Booking>();

	public MyResource() {
		init();
	}

	private void init() {
		bookings = bc.getAllBookings();
		System.out.println("Booking list created");
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * 
	 * @GET
	 * @Produces(MediaType.TEXT_PLAIN) public String getIt() { return "Got it!"; }
	 */

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/{value}")
	/*
	 * Note how this method has been annotated to produce both XML and JSON The
	 * response format which is sent will depend on the Accept: header field in the
	 * HTTP request from the client
	 */
	public Response getBooking(@PathParam("value") String value) {
		Booking requested = null;
		for (Booking b : bookings) {
			if (b.getBookingId() == Integer.parseInt(value)) {
				requested = b;
			}
		}
		if (requested != null) {
			String msg = getBookingAsXML(requested);

			return Response.status(200).entity(msg).build();
		} else {
			return Response.status(404).entity("Resource doesn't exist").build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getIt() {
		
		return bc.getAllBookings();
		// return bookings;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response createBooking(String toCreate) {

		Booking newBooking = getBookingFromXML(toCreate);
		Booking requested = null;
		System.out.println("DEBUG/POST: Atempting to add booking wioth date "+newBooking.getStartDate());
		for (Booking b : bookings) {
			System.out.println("DEBUG/POST:" + newBooking.getBookingId());
			if (b.getBookingId() == newBooking.getBookingId()) {
				requested = b;
			}
		}

		if (requested != null) {
			String msg = "The booking number " + newBooking.getBookingId() + " already exists";
			return Response.status(409).entity(msg).build();
		} else {
			bookings.add(newBooking);
			bc.create(newBooking);
			String msg = "Resource created!";
			return Response.status(201).entity(msg).build(); // return 201 for resource created
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("{id}")
	public Response updateBooking(@PathParam("id") String id, String toUpdate) {

		Booking updateBooking = getBookingFromXML(toUpdate);
		Booking toReplace = null;
		System.out.println("DEBUG/POST: Atempting to update booking with id "+updateBooking.getBookingId());
		
		for (Booking b : bookings) {
			System.out.println("DEBUG/UPDATE:comparing " +b.getBookingId()+" with:"+ updateBooking.getBookingId());

			if (b.getBookingId() == updateBooking.getBookingId()) {
				toReplace = b;
			}
		}

		if (toReplace == null) {
			String msg = "The booking number " + updateBooking.getBookingId() + " does not exist!";
			return Response.status(409).entity(msg).build();
		} else {
			bookings.remove(toReplace);
			bookings.add(updateBooking);
			bc.updateBooking(updateBooking);
			String msg = "Update Resource crated!";
			return Response.status(201).entity(msg).build(); // return 201 for resource created
		}
	}

	@DELETE
	// @Produces({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_XML})
	@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	@Path("/{value}")
	public Response deleteBooking(@PathParam("value") String value) {
		System.out.println("DEBUG/BookingResource: Attempting delete");
		Booking requested = null;
		for (Booking b : bookings) {
			if (b.getBookingId() == Integer.parseInt(value)) {
				requested = b;
			}
		}

		if (requested != null) {
			String msg = "The order number " + value + " was deleted!";
			bookings.remove(requested);
			bc.delete(requested.getBookingId());
			return Response.status(200).entity(msg).build();
		} else {
			String msg = "The booking number " + value + " does not exist";
			;
			return Response.status(404).entity(msg).build(); // return 404 for resource not found
		}
	}
	
}
