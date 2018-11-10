package ie.gmit.sw.rmi;


import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ie.gmit.sw.models.Booking;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {
	private static final long serialVersionUID = 1L;
	DataSource sqlDatasource;
	Statement stmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		System.out.println("Debug in DatabaseServiceImpl constructor in jersy");
		String url = "jdbc:mysql://localhost:3306/carbookingdb?useSSL=false";
		// Get connection to db
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "root", "");

			// Create statement object
			stmt = conn.createStatement();
			System.out.println("DEBUG DB Connected//////////////////////////////////////////////////////");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DEBUG DB Connect Failed//////////////////////////////////////////////////////");

		}

	}

	@Override
	public void addBooking(String q) throws RemoteException {
		try {
			stmt.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("SQL Error creating bookingS");
			e.printStackTrace();
		}
	}

	@Override
	public void updateBooking(String q) throws RemoteException {
		try {
			stmt.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("SQL Error creating bookingS");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBooking(String q) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate(q);
		} catch (SQLException e) {
			System.out.println("SQL Error creating bookingS");
			e.printStackTrace();
		}
	}

	@Override
	public List<Booking> listAllBookings() throws RemoteException {
		 System.out.println("Listing all bookings////////////////////////////////////////////////////");
		String query = "select * from bookings";
		ResultSet result = null;

		ArrayList<ResultSet> resultSetSerialized = new ArrayList<ResultSet>();

		Booking booking = new Booking();
		List<Booking> bookings = new ArrayList<Booking>();

		try {
			result = stmt.executeQuery(query); // generate the result set
		} catch (SQLException e) {
			System.out.println("sql error");
		}

		try {
			while (result.next()) {
				booking.setBookingId(result.getInt("BookingId"));
				booking.setVehicleId(result.getInt("VehicleId"));
				booking.setCustId(result.getInt("CustomerId"));
				booking.setStartDate(result.getString("StartDate"));
				booking.setEndDate(result.getString("EndDate"));

				bookings.add(booking);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bookings;
	}

}
