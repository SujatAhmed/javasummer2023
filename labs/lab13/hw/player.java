public class player {

	private String name;
	private String club;
	private int matches;

	player(){
		name =  "";
		club = "";
		matches = 0;

	}
	player(String name, String club, int matches){
		this.name = name;
		this.club = club ;
		this.matches = matches;
	}
	public String getName() {
		return name;
	}
	public String getClub() {
		return club;
	}
	public int getMatches() {
		return matches;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public void playMatch(){
		matches++;
	}
	public void displayinfo(){
		System.out.println("The name of the player is: " + name + " the club of the player is " + club + " the number of matches that the player has played is: " + matches );
	}
		
}
