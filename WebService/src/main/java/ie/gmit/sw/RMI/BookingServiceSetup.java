package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BookingServiceSetup {

	public static void main(String[] args) throws Exception {

		//Create an instance of a BookingServiceImplements. As BookingServiceImplements implements the BookingService
		//interface, it can be referred to as a BookinService type.
		IBookingService bookingService = new BookingServiceImplements();

		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		//Bind our remote object to the registry with the human-readable name "bookingService"
		// access using "rmi://127.0.0.1:1099/bookingService"
		try {
			Naming.rebind("bookingSevice", bookingService);
			//Print a message to standard output
			System.out.println("Booking Server ready.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Server malfunction");
		}

	
		//String myQuery = "insert into Bookings values  (002,200,020,\'01/08/18\',\'05/08/18\');";
	//	bookingService.createCarBooking(myQuery);
		//

	}
}
