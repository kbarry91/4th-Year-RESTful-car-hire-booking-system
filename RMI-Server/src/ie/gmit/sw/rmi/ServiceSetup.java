package ie.gmit.sw.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServiceSetup {

	/*
	 * Runs the main method to binds the remote object and initializes the RMI
	 * server
	 */
	public static void main(String[] args) throws Exception {

		// Create an instance of a DatabaseService as AatabaseServiceImplements
		DatabaseService databaseService = new DatabaseServiceImpl();

		// Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		// Bind remote object (databaseService) to the registry with the human-readable
		// name "databaseservice"
		try {
			Naming.rebind("databaseservice", databaseService);
			// Print a message to standard output
			System.out.println("Booking Server ready.");
		} catch (Exception e) {
			System.out.println("Error has occurred setting up RMI server!");
			e.printStackTrace();
		}

	}
}
