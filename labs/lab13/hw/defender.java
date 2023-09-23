import java.util.Scanner;

/**
 * defender
 */
public class defender extends player{
	private int blocks;
	private int tackles;
	defender(){
		super();
	}

	defender(String name, String club){
		super(name, club, 0);
		int blocks = 0;
		int tackles = 0;
	}
	
	public int getBlocks() {
		return blocks;
	}
	public int getTackles() {
		return tackles;
	}
	public void tacklePlayer(){
		tackles++;

	}
	public void blockPlayer(){
		blocks++;
	}
	@Override
	public void playMatch(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of matches " + this.getName() +  " has played");
		int totalmatches = sc.nextInt();
		this.setMatches(totalmatches);
		int[] tacklesPmatch = new int[this.getMatches()];
		int[] blocksPmatch = new int[this.getMatches()];
		for (int i = 0; i < tacklesPmatch.length; i++) {
			System.out.println("Enter the amount of tackles for match " + (i+1));
			tacklesPmatch[i]  = sc.nextInt();
			for (int  j = 0; j < tacklesPmatch[i];j++) {
				tacklePlayer();
			}
			System.out.println("Enter the amounts of block for match " + (i+1));
			blocksPmatch[i] = sc.nextInt();
			for (int j = 0; j < blocksPmatch[i];j++) {
				blockPlayer();
				
			}
		}
		sc.close();

	}
	@Override
	public void displayinfo(){
		double tackelesPerMatch = (double)(tackles/(this.getMatches()));
		double blockpermatch = (double)(blocks/(this.getMatches()));
		super.displayinfo();
		System.out.println("The Tackles  per match of " + this.getName() + " is " + tackelesPerMatch);
		System.out.println("The Blocks   per match of " + this.getName() + " is " + blockpermatch);
	} 
	public static void main(String[] args) {
		
		goalkeeper g1 = new goalkeeper("Allison Becker ", "Liverpool");
		g1.playMatch();
		g1.displayinfo();
		defender d1 = new defender("Lisandro Martinez ", "Manchester United");
		d1.playMatch();
		d1.displayinfo();





	}

}





