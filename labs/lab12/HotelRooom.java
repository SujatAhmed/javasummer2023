/**
 * HotelRooom
 */
public class HotelRooom {

	private String roomNumber;
	private double pricePerNight;
	private int numberOfBeds;


	HotelRooom(){
		roomNumber = "";
		pricePerNight = 0;
		numberOfBeds  = 0;
	}
	HotelRooom(String roomNumber, double pricePerNight, int numberOfBeds){
		this.roomNumber = roomNumber;
		this.pricePerNight = pricePerNight;
		this.numberOfBeds = numberOfBeds;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void displaInfo(){
		System.out.println(this.roomNumber);
		System.out.println(this.pricePerNight);
		System.out.println(this.numberOfBeds);

	}
	double calculatrTotalPrice(int days){
		double totalprice = ((double)days)*this.pricePerNight;


		return totalprice;
	}

	public static void main(String[] args) {
		HotelRooom h1 = new HotelRooom("101", 500 , 5);
		RegularHotelRoom rh1 = new RegularHotelRoom("102", 700, 5, true , true );
		h1.getNumberOfBeds();
		h1.getPricePerNight();
		h1.getRoomNumber();
		h1.setNumberOfBeds(7);
		h1.setPricePerNight(300);
		h1.setRoomNumber("103");
		System.out.println(h1.calculatrTotalPrice(4));
		h1.displaInfo();
		rh1.getNumberOfBeds();
		rh1.getRoomNumber();
		rh1.getPricePerNight();
		rh1.setRoomNumber("104");
		rh1.setPricePerNight(500);
		rh1.setNumberOfBeds(9);
		System.out.println(rh1.calculatrTotalPrice(5));
		rh1.displaInfo();
		
	}
}
