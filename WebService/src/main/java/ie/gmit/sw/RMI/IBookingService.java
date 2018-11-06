package ie.gmit.sw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBookingService extends Remote {
	// add a new booking
	public void addBooking(String q) throws RemoteException; 

	// list booking
	public List<BookingModelReturned> listAllBookings() throws RemoteException; 

	// update booking
	public void updateBooking(String q) throws RemoteException; 

	// deletebooking
	public void deleteBooking(String q) throws RemoteException; 
}
