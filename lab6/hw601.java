import java.util.*;
public class hw601{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in) ;
    //initialize
    int[] arr = new int[10];
    for (int  i = 0; i<arr.length ; i++) {
      arr[i]= input.nextInt();
    }

    int temp;
     //sorting algorithm 
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = i+1; j < arr.length; j++) {
        if(arr[i]>arr[j]){
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    //print out the array 
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+ " ");
    }

    System.out.println(" ");
    input.close();
  }
}
