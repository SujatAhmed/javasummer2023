public class RegularHotelRoom extends HotelRooom{

	private boolean hasWifi;
	private boolean hasAc;

	RegularHotelRoom(){
		super();
		this.hasWifi = false;
		this.hasAc = false;
	}
	RegularHotelRoom(String roomNumber, double pricePerNight, int numberOfBeds, boolean hasWifi, boolean hasAc){
		super(roomNumber,pricePerNight,numberOfBeds);
		this.hasWifi = hasWifi;
		this.hasAc = hasAc;
	}
	public boolean gethasWifi(){
		return this.hasWifi;
	}
	public boolean gethasAc(){
		return this.hasAc;
	}



	@Override
	public String getRoomNumber() {
		return super.getRoomNumber();
	}
	@Override
	public double getPricePerNight() {
		return super.getPricePerNight();
	}
	@Override
	public int getNumberOfBeds() {
		return super.getNumberOfBeds();
	}
	@Override
	public void setRoomNumber(String roomNumber) {
		super.setRoomNumber(roomNumber);
	}
	@Override
	public void setNumberOfBeds(int numberOfBeds) {
		super.setNumberOfBeds(numberOfBeds);
	}
	@Override
	public void setPricePerNight(double pricePerNight) {
		super.setPricePerNight(pricePerNight);
	}
	public void sethasWifi(boolean hasWifi){
		this.hasWifi = hasWifi;
	}
	public void sethasAc(boolean hasAc){
		this.hasAc = hasAc;
	}
	@Override
	public void displaInfo() {
		super.displaInfo();
		System.out.println(hasAc);
		System.out.println(hasWifi);
	}

	@Override
	double calculatrTotalPrice(int days) {
		return super.calculatrTotalPrice(days);
	}
}



