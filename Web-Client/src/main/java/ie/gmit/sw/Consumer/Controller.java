package ie.gmit.sw.Consumer;

import java.util.List;

import ie.gmit.sw.models.*;

public class Controller {

	public Controller() {

	}

	// Rest Access object
	RestAccess access = new RestAccess();
	private List<Booking> bookingList;

	/*
	 * Return a List of all bookings from remote object
	 */
	public List<Booking> getBookings() {
		bookingList = access.getBookings();
		return bookingList;
	}

	/*
	 * Return a single booking object
	 */
	public Booking getBookingId(int id) {
		Booking booking = access.getBookingById(id);
		return booking; // Return that booking object.
	}

	/* Update a booking */
	public void updateBooking(Booking booking) {
		access.updateBooking(booking);
	}

	/*
	 * Create a booking
	 */
	public void createBooking(Booking booking) {
		access.createBooking(booking);
	}

	/*
	 * Delete a booking
	 */
	public void Delete(int id) {
		access.deleteBooking(id);
	}

}
