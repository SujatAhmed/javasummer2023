import java.util.Scanner;
public class fibonacci {
  public static void main(String[] args) {
    fib_generator();
    
  }
  public static void fib_generator() {
    Scanner input = new Scanner(System.in);
    
     System.out.println("Choose the number of terms till which you want to print out the series except 0 and 1");
     int size = input.nextInt();
     int a = 0; 
     int b = 1;
     int c;
     System.out.println("");
     System.out.print("0 1 ");
    for(int i = 0; i<size; i++){
      c = a+b;
      a = b;
      b = c;
      System.out.print(c);
      System.out.print(" ");
      
    }
    System.out.println(" ");
    
     input.close();
  }
  
  
}
