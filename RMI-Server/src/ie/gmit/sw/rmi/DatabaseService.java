package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.models.Booking;

public interface DatabaseService extends Remote {
	// add a new booking
	public void addBooking(String q) throws RemoteException; 

	// list booking
	public List<Booking> listAllBookings() throws RemoteException; 

	// update booking
	public void updateBooking(String q) throws RemoteException; 

	// deletebooking
	public void deleteBooking(String q) throws RemoteException; 
}
