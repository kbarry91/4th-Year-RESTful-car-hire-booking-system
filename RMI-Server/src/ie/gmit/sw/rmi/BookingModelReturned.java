package ie.gmit.sw.rmi;

import java.io.Serializable;

public class BookingModelReturned  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8008411665683542434L;
	private int bookingId;
	private int vehicleId;
	private int customerId;
	private String startDate;
	private String endDate;
	
	public BookingModelReturned() {
		super();
	}

	public BookingModelReturned(int bookingId, int vehicleId, int customerId, String startDate, String endDate) {
		super();
		this.bookingId = bookingId;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "BookingModelReturned [bookingId=" + bookingId + ", vehicleId=" + vehicleId + ", customerId="
				+ customerId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

}
