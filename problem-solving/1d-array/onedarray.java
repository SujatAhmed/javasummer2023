public class onedarray {
	public static void main(String[] args) {
		
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
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

		//System.out.println(function(0, leap, posarray, specialarray));

		function(0, leap, posarray, specialarray);
	}

	public static void function(int position1, int leap, int[] posarraynull,int[] specialarraynull ) {
		int newposition1 = position1;
		int newposition2 = position1; 
		newposition1++;
		newposition2= newposition2+leap;
		int[] newarray = new int[10];
		int[] newposarray = new int[10];
		boolean check1 = false;
		boolean check2 = false;
		boolean check = false;


		for (int i = 0; i < newarray.length; i++) {
			newarray[i]=specialarraynull[i];
			
		}
		for (int i = 0; i < newposarray.length; i++) {
			newposarray[i]=posarraynull[i];
			
		}
		
		for(int i = 0; i<10; i++){
			if(newposition1==newarray[i] || newposition2==newarray[i]){
				check = true;
				break;
				
 


			}
		}



		for (int i = 0; i <10 ; i++) {
			if(newposition1==posarraynull[i]){
				check1 = true ;
				break;
				

			}
			
		}

		for (int i = 0; i <10 ; i++) {
			if(newposition2==posarraynull[i]){
				
				check2 = true ;
				

			}
			
		}
		if(check){
			System.out.println(check);
			return;
		}
		else if(check1){
			function(newposition1, leap, newposarray, newarray);
			
		}
		else if(check2){
			function(newposition2, leap, newposarray, newarray);
		}
		else if(!(check1&&check2)){
			System.out.println(check1);
			return;
		}




			


		
	}
}
