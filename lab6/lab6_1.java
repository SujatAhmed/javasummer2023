import java.util.*;

/**
 * lab6.1
 */
public class lab6_1 {
   public static void main(String[] args) {
   
    Scanner input = new Scanner (System.in);
    System.out.println("Enter the 2 elements for the first method: ");

    int a1 = input.nextInt();
    int a2 = input.nextInt();
    System.out.println("Enter the 3 elements for the second method: ");
    int a3 = input.nextInt();
    int a4 = input.nextInt();
    int a5 = input.nextInt();


    System.out.println("the minimum of the  first 2 elements is: ");
    System.out.println(findMin(a1,a2));
    System.out.println("the minimum of the  last 3 elements is: ");
    System.out.println(findMin(a3,a4,a5));
  
    input.close();
  }
  public static int findMin(int a, int b , int c) {
    
    int[] minimum =  {a, b, c};
    int min1 = minimum[0];

    for(int i=1 ; i<3 ; i++){
      if (minimum[i]<min1){

         min1 = minimum[i];
      }
    }
    return min1;

  }
  public static int findMin(int x, int y ) {

    int min2;
    if(x>y){
      min2 = y;
    }
    else{
      min2 = x;
    }
    return min2;
  }
}

 
