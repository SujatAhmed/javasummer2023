
/**
 * Captain
 */
public class Captain extends Pirate{

	boolean ownShip;
	Ship ownedship;
	Captain(){
		super();
		ownShip = false;

	}
	Captain(String name, String country){
		super(name,country);
	}
	public void ownShip(Ship ownedship){
		this.ownedship = ownedship;
		ownShip = true;
	}
	public void disownship(){
		ownShip = false;
		this.ownedship = null;
	}
	public void getShipDetails(){
		if(!ownShip){
			System.out.println("the pirate captain does not have a ship");
		}
		else{
		 ownedship.displayDetails();
		}
	}
	public static void main(String[] args) {

		Captain c1 = new Captain("Roger","uganda");
		Ship s1 = new Ship("moby dick");
		Ship s2 = new Ship("Thousand Sunny");
		c1.ownShip(s1);
		c1.getShipDetails();
		c1.disownship();
		c1.getShipDetails();
		c1.ownShip(s2);
		c1.getShipDetails();
	}
}
