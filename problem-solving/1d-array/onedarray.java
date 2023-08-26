public class onedarray {
	public static void main(String[] args) {
		
		bool check;
		int[] arr = {1,0,1,0,0,1,0,0,1,1};
		int leap = 3;
		int[] posarray = new int[10];
		int[] specialarray= new int[10];
		for(int i =0; i <10; i ++){
			if(arr[i]==0){
				posarray[i]=i;

			}

		}
		int count =0;
		for(int i = 6; i<10;i++){
			if (arr[i]==0){
				specialarray[count]=i;
				count++;
			}

		}

		System.out.println(function(0, leap, posarraynull, specialarraynull));
	}

	public static bool function(int position1, int leap, int[] posarraynull,int[] specialarraynull) {
		int newposition1 = position1;
		int newpositon2 = position1; 
		newposition1++;
		newpositon2= newpositon2+leap;
		
		for(int i = 0; i<10; i++){
			if(newposition1==specialarraynull[i] || newpositon2==specialarraynull[i]){
				check = true;
				return check;
				break;
			}
		}

		for (int i = 0; i <10 ; i++) {
			if(newposition1==posarraynull[i]){
				function(newposition1, leap, posarraynull, specialarraynull);
				

			}
			
		}

		for (int i = 0; i <10 ; i++) {
			if(newposition2==posarraynull[i]){
				function(newposition2, leap, posarraynull, specialarraynull);
				

			}
			
		}

		
		
	}
}
