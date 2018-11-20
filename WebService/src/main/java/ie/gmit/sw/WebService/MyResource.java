package ie.gmit.sw.WebService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.models.Booking;
import ie.gmit.sw.rmi.RMIClient;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookingresource")
public class MyResource {
	RMIClient bc = new RMIClient();
	List<Booking> bookings = new ArrayList<Booking>();

	public MyResource() {
		init();
	}

	private void init() {
		bookings = bc.getAllBookings();
		System.out.println("======Bookking list created");
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
	public Booking getBooking(@PathParam("value") String value) {
		Booking requested = null;
		for (Booking b : bookings) {
			if (b.getBookingId() == Integer.parseInt(value)) {
				requested = b;
			}
		}

		return requested;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getIt() {
		/*
		 * List<Booking> bookings = new ArrayList<Booking>(); Booking booking = new
		 * Booking(); List<Booking> bookingModelsReturned = bc.getAllBookings();
		 * 
		 * for (Booking bmr : bookingModelsReturned) {
		 * booking.setBookingId(bmr.getBookingId());
		 * booking.setVehicleId(bmr.getVehicleId()); booking.setCustId(bmr.getCustId());
		 * booking.setStartDate(bmr.getStartDate());
		 * booking.setEndDate(bmr.getEndDate());
		 * 
		 * 
		 * bookings.add(booking);
		 * System.out.println("In my resource:"+booking.toString());
		 * 
		 * }
		 * 
		 * //List<Booking> allBookings = bc.getAllBookings();
		 * 
		 */
		return bc.getAllBookings();
		// return bookings;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response createBooking(@PathParam("value") int value, Booking toCreate) {
		Booking requested = null;
		for (Booking b : bookings) {
			if (b.getBookingId() == value) {
				requested = b;
			}
		}

		if (requested != null) {
			String msg = "The booking number " + value + " already exists";
			return Response.status(409).entity(msg).build();
		} else {
			bookings.add(toCreate);
			bc.create(toCreate);
			String msg = "Resource created!";
			return Response.status(201).entity(msg).build(); // return 201 for resource created
		}
	}

	@DELETE
	//@Produces({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{value}")
	public Response deleteBooking(@PathParam("value") String value) {
		System.out.println("DEBUG/BookingResource: Attempting delete");
		Booking requested = null;
		for (Booking b : bookings) {
			if (b.getBookingId() ==Integer.parseInt(value)) {
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
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String getIt() { /*List<Booking>
	 * bookings = new ArrayList<Booking>(); Booking booking = new Booking();
	 * List<Booking> bookingModelsReturned = bc.getAllBookings();
	 * 
	 * for (Booking bmr : bookingModelsReturned) {
	 * booking.setBookingId(bmr.getBookingId());
	 * booking.setVehicleId(bmr.getVehicleId()); booking.setCustId(bmr.getCustId());
	 * booking.setStartDate(bmr.getStartDate());
	 * booking.setEndDate(bmr.getEndDate());
	 * 
	 * 
	 * bookings.add(booking);
	 * System.out.println("In my resource:"+booking.toString());
	 * 
	 * }
	 * 
	 * List<Booking> allBookings = bc.getAllBookings(); int counter = 0; for
	 * (Booking booking : allBookings) { counter ++;
	 * System.out.println("DEBUG My Resource "+counter+": "+booking.toString()); }
	 * return allBookings.get(1).toString(); //return bookings; }
	 */
}
