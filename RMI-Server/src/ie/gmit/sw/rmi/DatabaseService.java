package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.models.Booking;

public interface DatabaseService extends Remote {
	// create booking
	public boolean create(String q) throws RemoteException; 

	// read booking
	public List<Booking> listAllBookings() throws RemoteException; 

	// update booking
	public void update(String q) throws RemoteException; 

	// delete booking
	public void delete(String q) throws RemoteException; 
	
	
}
