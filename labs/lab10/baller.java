/**
 * lab10
 *
 */
import java.text.*;
import java.util.*;
public class baller {
	String name;
	String position; 
	String team;
	int[] goals = new int[5];
	int[] assists= new int[5];
	int matches = 5;

	int totalGoals; 
	int totalAssists;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public void setGoals(Scanner scanner ){
		System.out.println("enter the goals in each match of this player: ");
		for (int  i = 0; i < goals.length; i++) {
			System.out.println("goals in match" + (i+1));
			goals[i] = scanner.nextInt();

		}
	}
	public void setAssists(Scanner scanner ){
		System.out.println("enter the assists  in each match of this player: ");
		for (int  i = 0; i < assists.length; i++) {
			System.out.println("assists in match" + (i+1));
			assists[i] = scanner.nextInt();

		}
	}
	public void setTotalassists(){
		int sum = 0; 
		for (int  i = 0; i < assists.length; i++) {
			sum = sum + assists[i];
			
		}

	}
	public void setTotalgoals(){
		int sum = 0; 
		for (int  i = 0; i < goals.length; i++) {
			sum = sum + goals[i];
			
		}

	}
	
	public void getGoals() {
		for (int i = 0; i < goals.length; i++) {
			System.out.println("the goals for match"+(i+1)+"for player"+ name+ "is ");
			System.out.println(goals[i]);

			
		}
	}
	
	public void getAssists() {
		for (int i = 0; i < assists.length; i++) {
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
		for (int i = 0; i < goals.length; i++) {
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
		for (int i = 0; i < assists.length; i++) {
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
		avggc = (average_goals + average_assists)/2;
		DecimalFormat df = new DecimalFormat("0.00");
		String roundedValue = df.format(avggc);
		double finalavggc = Double.parseDouble(roundedValue);
		return finalavggc;
		
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		baller mbappe = new baller();
		mbappe.setName("mbappe");
		mbappe.setTeam("psg");
		mbappe.setPosition("left_wing");
		mbappe.setGoals(scanner);
		mbappe.setAssists(scanner);
		mbappe.setTotalgoals();
		mbappe.setTotalassists();
		System.out.println(mbappe.getName());
		System.out.println(mbappe.getPosition());
		System.out.println(mbappe.getTeam());
		System.out.println(mbappe.getTotalAssists());
		System.out.println(mbappe.getTotalGoals());
		System.out.println(mbappe.getAveragegoals());
		System.out.println(mbappe.getAverageassists());
		System.out.println(mbappe.getAveragegoalcontribution());


		
	}
}
