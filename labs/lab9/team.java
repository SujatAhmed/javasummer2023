
public class team {

    String teamName;
	String coachName;
	String homeCountry; 
	int currentNumberofpl;
	final int maxNumberofpl = 7;
	String[] playerNames = new String[maxNumberofpl];


	team(String teamName, String coachName, String homeCountry){
		this.teamName = teamName;
		this.coachName = coachName;
		this.homeCountry = homeCountry;
		this.currentNumberofpl = 0;
	}
	public String getTeamName() {
		System.out.println("The team name is:");
		return teamName;
	}
	public String getCoachName() {
		System.out.println("the coach name is: ");
		return coachName;
	}
	public String getHomeCountry() {
		System.out.println("the home country is: ");
		return homeCountry;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}
	public void addplayer(String player){
		if(currentNumberofpl==0){
			playerNames[currentNumberofpl] = player;
			currentNumberofpl++;
			System.out.println("the player has been added named," + player);
		}
		else if(currentNumberofpl !=0 && currentNumberofpl< maxNumberofpl){
			playerNames[currentNumberofpl] = player;
			currentNumberofpl++;
			System.out.println("the player has been added named," + player);
		}
		else if(currentNumberofpl !=0 && currentNumberofpl>=maxNumberofpl){
			System.out.println("Max amount of players reached can't add the player " + player);
		}

	}
	public void removePlayer(String player ){
		for (int i = 0; i < currentNumberofpl; i++) {
			if(this.playerNames[i].equals(player)){
				for (int j = i; j < currentNumberofpl-1; j++) {
					playerNames[j] = playerNames[j+1];

				}

			}
		}
		System.out.println(" the player has been removed, named " + player);
			playerNames[currentNumberofpl-1] = null;
			currentNumberofpl--;


	}
	public void printinfo(){
		System.out.println(getTeamName());
		System.out.println(getCoachName());
		System.out.println(getHomeCountry());
		System.out.println("the current number of players in this team is: ");
		System.out.println(currentNumberofpl);
		System.out.println("the name of the players of the team are: ");
		for (int i = 0; i < currentNumberofpl; i++) {
			System.out.println(playerNames[i]);
		}


	}


	public static void main(String[] args) {
		team t1= new team("Football Club Barcelona", "Xavi hernandez" , "Catalunia");
		t1.addplayer("Pedri");
		t1.addplayer("gavi");
		t1.addplayer("yamal");
		t1.addplayer("frenkie de jong");
		t1.addplayer("lewy");
		t1.addplayer("araujo");
		t1.addplayer("kounde");

		t1.printinfo();
		t1.addplayer("balde");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		t1.removePlayer("yamal");
		
		t1.printinfo();
		t1.addplayer("balde");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		t1.printinfo();

		
	}
}
