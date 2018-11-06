package ie.gmit.sw.dsModels;

public class Booking {
	private int bookingId;
	private int vehicleId;
	private int customerId;
	private String startDate;
	private String endDate;
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", vehicleId=" + vehicleId + ", customerId=" + customerId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
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
}
