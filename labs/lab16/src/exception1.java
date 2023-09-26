import java.util.Scanner;
public class exception1 {


    public static void takeIntegers(int start) throws IllegalArgumentException{

       int[] input = new int[10];
       int i=0;
       Scanner sc = new Scanner(System.in);
       try {
           for (i = start; i < input.length; i++) {
               System.out.println("Enter the numbers");
               input[i] = sc.nextInt();
               if (input[i] < 0) {
                   throw new IllegalArgumentException("Don't give a negative number!!");
               }
           }
       }catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
           takeIntegers(i);


       }


    }




    public static void main(String[] args) {
        takeIntegers(0);


    }
}
