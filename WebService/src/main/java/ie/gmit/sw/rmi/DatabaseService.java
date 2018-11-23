package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ie.gmit.sw.models.Booking;

/*
 * DatabaseService exposes CRUD functionality of the Remote Object.
 * */
public interface DatabaseService extends Remote {
	// add a new booking
	public boolean create(String q) throws RemoteException;

	// list booking
	public List<Booking> read() throws RemoteException;

	// update booking
	public void update(String q) throws RemoteException;

	// Delete booking
	public void delete(String q) throws RemoteException;

}
