public class Ship {

	String shipName;
	Ship(){
		shipName = "";
		
	}
	Ship(String name){
		shipName = name;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipName() {
		return shipName;
	}
	public void displayDetails(){
		System.out.println(shipName);
	}





	public static void main(String[] args) {
		
	}
}
