import java.util.*;
public class lab5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int b = (int)A;
		System.out.println(b);
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		int a4 = sc.nextInt();
		sc.close();
		System.out.println(sumOfSquares(a1));
		multiplesof4(a2);
		System.out.println(max(a3,a4));
		
	}
	static int sumOfSquares(int n1){
		int sum = 0;
		for (int i = 1; i <= n1; i++) {
			sum = sum + (i*i);


			
		}
		return sum;

	}
	static void multiplesof4(int n2){

		for (int i = 1; i <= n2; i++) {
			if(i%4==0){
				System.out.println(i);
			}
		}
		

	}
	static int max(int n2, int n3){
		if(n2>n3){
			return n2;
		}
		else if(n3>n2){
			return n3;
		}
		else{
			return n2;
		}

	}
}
