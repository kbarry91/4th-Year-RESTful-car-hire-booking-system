package ie.gmit.sw.RMI;

import java.rmi.RemoteException;

public interface BookingServiceImpl {
	// add a new booking
	public void createCarBooking(String q) throws RemoteException; 

	// list booking
//	public List<ReturnedCarHire> readCarHire() throws RemoteException; 

	// update booking
	public void updateCarBooking(String q) throws RemoteException; 

	// dletebooking
	public void deleteCarBooking(String q) throws RemoteException; 
}
