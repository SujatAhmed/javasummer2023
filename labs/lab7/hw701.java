import java.util.*;

/**
 * hw701
 */
public class hw701 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[20];
		 for (int i = 0; i < arr.length; i++) {
			arr[i]= sc.nextInt();

		 	
		 }
				sc.close();
		int sudo;
		for (int i = 0; i < arr.length-1; i++) {
		    for (int j = i+1; j < arr.length; j++) {

		       if(arr[i]>arr[j]){
						 sudo = arr[i];
						 arr[i]= arr[j];
						 arr[j]=sudo;
						}
		
		    }	
		}
		for (int i = 0; i < arr.length; i++) {
								System.out.print(arr[i]+ " ");


		}
		
		
				System.out.println(" ");
       

				double median = (arr[19/2]+arr[(19/2)+1])/2;
				System.out.println(median);
	}
}
