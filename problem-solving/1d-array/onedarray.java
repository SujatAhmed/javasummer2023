public class onedarray {
	public static void main(String[] args) {
		
		int[] arr = {1,0,1,0,0,1,1,1,1,1};
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

		System.out.println(function(0, leap, posarray, specialarray));

	}

	public static int function(int position1, int leap, int[] posarraynull,int[] specialarraynull ) {
		int newposition1 = position1;
		int newposition2 = position1; 
		newposition1++;
		newposition2= newposition2+leap;
		int[] newarray = new int[10];
		int[] newposarray = new int[10];


		for (int i = 0; i < newarray.length; i++) {
			newarray[i]=specialarraynull[i];
			
		}
		for (int i = 0; i < newposarray.length; i++) {
			newposarray[i]=posarraynull[i];
			
		}
		
		for(int i = 0; i<10; i++){
			if(newposition1==newarray[i] || newposition2==newarray[i]){
				return 1;
 

			}
		}

		for (int i = 0; i <10 ; i++) {
			if(newposition1==posarraynull[i]){
				 return function(newposition1, leap, newposarray, newarray );
				

			}
			
		}

		for (int i = 0; i <10 ; i++) {
			if(newposition2==posarraynull[i]){
				 return function(newposition2, leap, newposarray, newarray );
				

			}
			
		}

		return 0;	


		
	}
}
