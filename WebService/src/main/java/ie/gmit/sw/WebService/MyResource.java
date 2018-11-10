package ie.gmit.sw.WebService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.models.Booking;
import ie.gmit.sw.rmi.RMIClient;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookingresource")
public class MyResource {
	RMIClient bc = new RMIClient();

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
	@Produces(MediaType.APPLICATION_XML)
	public List<Booking> getIt() {
		/*List<Booking> bookings = new ArrayList<Booking>();
		Booking booking = new Booking();
		List<Booking> bookingModelsReturned = bc.getAllBookings();

		for (Booking bmr : bookingModelsReturned) {
			booking.setBookingId(bmr.getBookingId());
			booking.setVehicleId(bmr.getVehicleId());
			booking.setCustId(bmr.getCustId());
			booking.setStartDate(bmr.getStartDate());
			booking.setEndDate(bmr.getEndDate());
			

			bookings.add(booking);
			System.out.println("In my resource:"+booking.toString());

		}
		*/
		for (Booking booking : bc.getAllBookings()) {
			System.out.println("DEBUG My Resource: "+booking.toString());
		}
		return bc.getAllBookings();
		//return bookings;
	}
}
