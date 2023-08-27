import java.util.*;
/**
 * hw702
 */
public class hw702 {

	public static void main(String[] args) {
		
		int[][] result = new int[4][5];
		Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 5; j++) {
					System.out.println("input the mark of student"+ (i+1) +" subject" +(j+1));
					int marks = sc.nextInt();
					result[i][j]= marks;
				}
				
			}
		sc.close();
		for (int i = 0; i < 4; i++) {
			System.out.print("the marks of student"+(i+1)+":  ");
			for (int j = 0; j < 5; j++) {
				System.out.print(result[i][j] + "   ");


				
			}
			System.out.println();
			
		}
		System.out.println("Average Score for Each Student:");
        for (int i = 0; i < 4; i++) {
            int totalmarks = 0;
            for (int j = 0; j < 5; j++) {
                totalmarks += result[i][j];
            }
            double averagemarks = (double) totalmarks / 5;
						System.out.println("average marks for student"+(i+1)+"is"+averagemarks);
			      
        }
		System.out.println("Average Score for Each Subject:");
        for (int j = 0; j < 5; j++) {
            int totalmarks = 0;
            for (int i = 0; i < 4; i++) {
                totalmarks += result[i][j];
            }
            double averagemarks = (double) totalmarks / 4;
						System.out.println("average marks for subject"+(j+1)+"is"+averagemarks);
        }
		for (int j = 0; j < 5; j++) {
            int maxmarks = -999999;
            int maxindex = -999999;
            for (int i = 0; i < 4; i++) {
                if (result[i][j] > maxmarks) {
                    maxmarks = marks[i][j];
                    maxindex = i;
                }
            }
            System.out.println("the maximum marks of");
        }

		
		 	
	}
}
