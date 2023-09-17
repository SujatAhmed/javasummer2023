import java.util.Scanner;


/**
 * goalkeeper
 */
public class goalkeeper extends player {
	int cleanSheets;
	int goalsConceeded;
	goalkeeper(){
		super();
	}
	goalkeeper(String name, String club){
		super(name, club, 0);
	}  
	public int getCleanSheets() {
		return cleanSheets;
	}
	public int getGoalsConceeded() {
		return goalsConceeded;
	}

	@Override
	public void playMatch(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of matches " + this.getName() +  " has played: ");

		int totalmatches = sc.nextInt();
		this.setMatches(totalmatches);

		int[] goalsconceededPmatch = new int[this.getMatches()];
		for (int i = 0; i < goalsconceededPmatch.length; i++) {
			System.out.println("Enter the number of goals conceeded in match " + (i+1));
			goalsconceededPmatch[i] = sc.nextInt();
			if(goalsconceededPmatch[i] == 0){
				cleanSheets++;
			}
			else{
				goalsConceeded = goalsConceeded + goalsconceededPmatch[i] ;
			}
			
		}
	}
	@Override
	public void displayinfo(){
		double goalsagainst = (double)(goalsConceeded/this.getMatches());

		super.displayinfo();
		System.out.println("The goals conceeded per match of " + this.getName() + " is " + goalsagainst);
		System.out.println("The cleansheets of " + this.getName() + " is " + cleanSheets);
		
	}

  
}
