package ie.gmit.sw.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.models.Booking;
import ie.gmit.sw.rmi.DatabaseService;

public class RMIClient {
	DatabaseService bookingServiceInterface;

	public RMIClient() {
		System.out.println("DEBUG- booking controller constuctor");
		// get a handle on the remote object
		try {
			System.out.println("DEBUG- booking controller constuctor about to naming lookup");

			this.bookingServiceInterface = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/bookingService");
			System.out.println("DEBUG- booking controller constuctor after naming lookup");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("DEBUG- booking controller constuctor end");

	}

	/*
	 * Return all bookings
	 */
	public List<Booking> getAllBookings() {
		ResultSet resultSet = null;
		List<Booking> bookings = null ;
		Booking resultBooking;
		String startDate = null;
		String resultObject = null;

		try {
			System.out.println("Booking Jersey controller//////////////////////////////////////////////listAllBookings");

			bookings = bookingServiceInterface.listAllBookings();
		} catch (RemoteException e) {

			System.out.println("error accessing data from remote object//////////////////////////////////////////////");
			e.printStackTrace();
		}

		System.out.println(bookings.size());
		System.err.println("Bookings-->"+bookings.get(0).toString());
	//	resultBooking = bookings.get(0);

//	System.out.println(resultBooking.getBookingId()); // for
		return bookings;
	}

	/*
	 * Return a specific booking
	 */
	public Booking getBookingById(int id) {

		List<Booking> bookings = new ArrayList<Booking>();
		Booking resultBooking = null;

		try {
		bookings = bookingServiceInterface.listAllBookings();
		} catch (RemoteException e) {
			System.out.println("error accessing data from remote object");
			e.printStackTrace();
		}

		for (Booking b : bookings) {
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
	public void createBooking(Booking booking) {
		String query = "Insert INTO bookings VALUES(" + booking.getBookingId() + "," + booking.getVehicleId() + ","
				+ booking.getCustId() + ",\"" + booking.getStartDate() + "\",\"" + booking.getEndDate() + "\");";

		try {
			bookingServiceInterface.addBooking(query);
		} catch (RemoteException e) {
			System.out.println("error on sql query in booking controller");
			e.printStackTrace();
		}
	}

	/* Update a booking */
	public void updateBooking(Booking booking) {

		String query = "UPDATE bookings SET vehicle_id =" + booking.getVehicleId() + ", " + "customer_id ="
				+ booking.getCustId() + ", " + "start_date =\"" + booking.getStartDate() + "\", " + "end_date =\""
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
