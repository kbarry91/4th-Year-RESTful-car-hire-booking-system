package ie.gmit.sw.WebService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.RMI.BookingModelReturned;
import ie.gmit.sw.dsController.BookingController;
import ie.gmit.sw.dsModels.Booking;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bookingresource")
public class MyResource {
	BookingController bc = new BookingController();

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
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		List<Booking> bookings = new ArrayList<Booking>();
		Booking booking = new Booking();
		List<BookingModelReturned> bookingModelsReturned = bc.getAllBookings();

		for (BookingModelReturned bmr : bookingModelsReturned) {
			booking.setBookingId(bmr.getBookingId());
			booking.setVehicleId(bmr.getVehicleId());
			booking.setCustomerId(bmr.getCustomerId());
			booking.setStartDate(bmr.getStartDate());
			booking.setEndDate(bmr.getEndDate());
			

			bookings.add(booking);

		}
		return booking.toString();
	}
}
