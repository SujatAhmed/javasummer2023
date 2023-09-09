/**
 * lab10
 *
 */
import java.text.*;
import java.util.*;
public class footballer {
	String name;
	String position; 
	String team;
	int[] goals = new int[1000];
	int[] assists= new int[1000];
	int matches;

	int totalGoals; 
	int totalAssists;
	footballer(){





	}





	// All the setters
	public void setMatches(Scanner scanner) {
		System.out.println("Enter the amount of matches this player has played");
		this.matches = scanner.nextInt();

	}
	
	public void setName(Scanner scanner) {
		System.out.println("Enter the name of the player");
		this.name = scanner.nextLine();
	}
	public void setTeam(Scanner scanner) {
		System.out.println("Enter the  team of the player");
		this.team = scanner.nextLine();

	}
	public void setPosition(Scanner scanner) {
		System.out.println("Enter the  position of the player");
		this.position= scanner.nextLine();
	}

	public void setGoals(Scanner scanner ){
		System.out.println("enter the goals in each match of this player: ");
		for (int  i = 0; i < matches; i++) {
			System.out.println("goals in match" + (i+1));
			this.goals[i] = scanner.nextInt();

		}
	}
	public void setAssists(Scanner scanner ){
		System.out.println("enter the assists  in each match of this player: ");
		for (int  i = 0; i < matches; i++) {
			System.out.println("assists in match" + (i+1));
			this.assists[i] = scanner.nextInt();

		}
	}
	public void setTotalassists(){
		int sum = 0; 
		for (int  i = 0; i < matches; i++) {
			sum = sum + assists[i];
			
		}
		this.totalAssists= sum;


	}
	public void setTotalgoals(){
		int sum = 0; 
		for (int  i = 0; i < matches; i++) {
			sum = sum + goals[i];
			
		}
		this.totalGoals = sum;

	}




	// All the getters  
	
	public void getGoals() {
		for (int i = 0; i < matches; i++) {
			System.out.println("the goals for match"+(i+1)+"for player"+ name+ "is ");
			System.out.println(goals[i]);

			
		}
	}
	
	public void getAssists() {
		for (int i = 0; i < matches; i++) {
			System.out.println("the assists for match"+(i+1)+"for player"+ name+ "is ");
			System.out.println(assists[i]);
			

		}
	}
	public int getTotalGoals() {
		return totalGoals;
	}
	public int getTotalAssists() {
		return totalAssists;
	}
	public String getName() {
		return name;
	}
	public String getTeam() {
		return team;
	}
	public int getMatches() {
		return matches;
	}	
	public String getPosition() {
		return position;
	}
	public double getAveragegoals(){
		
		double avggoals;
		double sum=0;;
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < matches; i++) {
			sum = sum + (double)goals[i];
			
		}
		avggoals = sum/5;
		String roundedValue = df.format(avggoals);
		double finalavggoal = Double.parseDouble(roundedValue);
		return finalavggoal;
		

	}
	public double getAverageassists(){

		double avgassists;
		double sum=0;;
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < matches; i++) {
			sum = sum + (double)assists[i];
			
		}
		 avgassists= sum/5;
		String roundedValue = df.format(avgassists);
		double finalavgassists = Double.parseDouble(roundedValue);
		return finalavgassists;
		

	}
	public double getAveragegoalcontribution(){
		double avggc;
		double average_goals = getAveragegoals();
		double average_assists = getAverageassists();
		avggc = average_goals + average_assists;
		DecimalFormat df = new DecimalFormat("0.00");
		String roundedValue = df.format(avggc);
		double finalavggc = Double.parseDouble(roundedValue);
		return finalavggc;
		
	}
	public double goalstoassistsratio(){
		double ratio;
		ratio = (double)this.totalGoals/(double)this.totalAssists;
		DecimalFormat df = new DecimalFormat("0.00");
		String roundedValue = df.format(ratio);
		double finalratio = Double.parseDouble(roundedValue);
		return finalratio;
	}




	// All the adders
	public void addMatchesby1(){
		matches++;

	}
	public void addMatchesbyInput(int matches){
		this.matches = this.matches + matches;
	}
	public void addGoals(int goals,int matches ){
		if(matches> this.matches|| matches< 0){
			System.out.println("the player has not played this many matches");

		}
		for (int i = 0; i < this.matches; i++) {
			if(i == matches){
				this.goals[i] = goals + this.goals[i] ;
			}
		}
		setTotalgoals();
	}
	public void addAssists(int assists ,int matches ){
		if(matches> this.matches|| matches< 0){
			System.out.println("the player has not played this many matches");

		}
		for (int i = 0; i < this.matches; i++) {
			if(i == matches){
				this.assists[i] = assists + this.assists[i] ;
			}
		}
		setTotalassists();
	}





	public void comparefootballers(baller otherballer){
		if(this.totalGoals>otherballer.totalGoals && this.totalAssists>otherballer.totalAssists){
			System.out.println(this.name + " has more goals and assists than " + otherballer.name);

		}
		else if(this.totalGoals>otherballer.totalGoals && this.totalAssists<= otherballer.totalAssists){
			System.out.println(this.name + " has more goals than " + otherballer.name+ " but has fewer or equal assists");
		}
		else if(this.totalGoals<=otherballer.totalGoals && this.totalAssists> otherballer.totalAssists){
			System.out.println(this.name + " has fewer or equal goals but has more assists than " + otherballer.name);
		}
		else{
			System.out.println(this.name + " has fewer goals and fewer assists than " + otherballer.name);
		}

	}
	 


	public void printdata(){
		System.out.printf("%-20s %-10d %-10.2f %-10.2f %-10.2f %-10.2f%n", 
            name, matches, getAveragegoals(), getAverageassists(), getAveragegoalcontribution(), goalstoassistsratio());

	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		baller player = new baller();

			player.setName(scanner);
			player.setTeam(scanner);
			player.setPosition(scanner);
			player.setMatches(scanner);
			player.setGoals(scanner);
			player.setAssists(scanner);
			player.setTotalgoals();
			player.setTotalassists();
			scanner.nextLine();

		System.out.println("");
		System.out.println("");

		System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s%n","Name", "Matches", "AvgGoals", "AvgAssists", "GoalContrib", "goals/assists");


			player.printdata();
			


	}
}
