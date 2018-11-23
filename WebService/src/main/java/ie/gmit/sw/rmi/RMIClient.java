package ie.gmit.sw.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.models.Booking;
import ie.gmit.sw.rmi.DatabaseService;

public class RMIClient {
	DatabaseService bookingServiceInterface;

	public RMIClient() {
		// get a handle on the remote object
		try {
			// Attach the RMI stub to the Database service
			this.bookingServiceInterface = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Return all bookings from RMI server database.
	 */
	public List<Booking> getAllBookings() {

		List<Booking> bookings = null;

		try {

			bookings = bookingServiceInterface.read();
		} catch (RemoteException e) {

			System.out.println("Error occurred: Could not read from RMI server!");
			e.printStackTrace();
		}
		// Return the list of bookings
		return bookings;
	}

	/*
	 * Return a specific booking
	 */
	public Booking getBookingById(int id) {

		List<Booking> bookings = new ArrayList<Booking>();
		Booking resultBooking = null;

		try {
			bookings = bookingServiceInterface.read();
		} catch (RemoteException e) {
			System.out.println("Error occurred: Get booking data on RMI server!");
			e.printStackTrace();
		}

		for (Booking b : bookings) {
			if (b.getBookingId() == id) {
				resultBooking = b;
			}
		}

		// If a booking was found return the object.
		if (resultBooking != null) {
			return resultBooking;
		} else {
			return null;
		}

	}

	/*
	 * Create a booking entry in database.
	 */
	public void create(Booking booking) {
		// Create the query
		String query = " INSERT INTO bookings (vehicle_id,customer_id,start_date,end_date)VALUES("
				+ booking.getVehicleId() + "," + booking.getCustId() + ",'" + booking.getStartDate() + "','"
				+ booking.getEndDate() + "')";
		try {
			bookingServiceInterface.create(query);
		} catch (RemoteException e) {
			System.out.println("Error occurred:  Creating a booking failed on RMI server!");
			e.printStackTrace();
		}
	}

	/*
	 * Update a booking entry in database.
	 */
	public void updateBooking(Booking booking) {
		// Create the query
		String query = "UPDATE bookings SET vehicle_id =" + booking.getVehicleId() + ", " + "customer_id ="
				+ booking.getCustId() + ", " + "start_date ='" + booking.getStartDate() + "', " + "end_date ='"
				+ booking.getEndDate() + "' WHERE booking_id=" + booking.getBookingId() + ";";

		try {
			bookingServiceInterface.update(query);
		} catch (RemoteException e) {
			System.out.println("Error occured: Updated booking failed on RMI server!");
			e.printStackTrace();
		}

	}

	/*
	 * Delete a booking from database.
	 */
	public void delete(int id) {
		// Create the query
		String query = "DELETE FROM bookings WHERE booking_id =" + id + ";";

		try {
			bookingServiceInterface.delete(query);
		} catch (RemoteException e) {
			System.out.println("Error occured: Deleting booking on RMI server!");
			e.printStackTrace();
		}
	}

}
