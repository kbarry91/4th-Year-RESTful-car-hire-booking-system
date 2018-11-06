package ie.gmit.sw.dsController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.RMI.BookingModelReturned;
import ie.gmit.sw.RMI.IBookingService;

public class BookingController {
	IBookingService bookingServiceInterface;

	public BookingController() {

		// get a handle on the remote object
		try {
			this.bookingServiceInterface = (IBookingService) Naming.lookup("rmi://127.0.0.1:1099/bookingService");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Return all bookings
	 */
	public List<BookingModelReturned> getAllBookings() {
		ResultSet resultSet = null;
		List<BookingModelReturned> bookings = new ArrayList<BookingModelReturned>();
		BookingModelReturned resultBooking;
		String startDate = null;
		String resultObject = null;

		try {
			bookings = bookingServiceInterface.listAllBookings();
			System.out.println("Booking controller//listAllBookings");
		} catch (RemoteException e) {

			System.out.println("error accessing data from remote object");
			e.printStackTrace();
		}

		//System.out.println(bookings.size());
		//resultBooking = bookings.get(0);

		//System.out.println(resultBooking.getBookingId()); // for
		return bookings;
	}

	/*
	 * Return a specific booking
	 */
	public BookingModelReturned getBookingById(int id) {

		List<BookingModelReturned> bookings = new ArrayList<BookingModelReturned>();
		BookingModelReturned resultBooking = null;

		try {
			bookings = bookingServiceInterface.listAllBookings();
		} catch (RemoteException e) {
			System.out.println("error accessing data from remote object");
			e.printStackTrace();
		}

		for (BookingModelReturned b : bookings) {
			if (b.getBookingId() == id) {
				resultBooking = b;
			}

		}

		if (resultBooking != null) {
			return resultBooking;
		} else {
			return null;
		}

	}

	/* Create a booking */
	public void createBooking(BookingModelReturned booking) {
		String query = "Insert INTO bookings VALUES(" + booking.getBookingId() + "," + booking.getVehicleId() + ","
				+ booking.getCustomerId() + ",\"" + booking.getStartDate() + "\",\"" + booking.getEndDate() + "\");";

		try {
			bookingServiceInterface.addBooking(query);
		} catch (RemoteException e) {
			System.out.println("error on sql query in booking controller");
			e.printStackTrace();
		}
	}

	/* Update a booking */
	public void updateBooking(BookingModelReturned booking) {

		String query = "UPDATE bookings SET vehicle_id =" + booking.getVehicleId() + ", " + "customer_id ="
				+ booking.getCustomerId() + ", " + "start_date =\"" + booking.getStartDate() + "\", " + "end_date =\""
				+ booking.getEndDate() + "\" WHERE booking_id=" + booking.getBookingId() + ";";

		try {
			bookingServiceInterface.updateBooking(query);
		} catch (RemoteException e) {
			System.out.println("error updating booking in Booking controller");
			e.printStackTrace();
		}

	}

	/** Delete a booking */
	public void deleteBooking(int id) {
		String query = "DELETE FROM bookings WHERE booking_id =" + id + ";";

		try {
			bookingServiceInterface.deleteBooking(query);
		} catch (RemoteException e) {
			System.out.println("error deleting booking in Booking controller");
			e.printStackTrace();
		}

	}

}
