import java.util.*;
/**
 * hourglass
 */
public class hourglass {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

     int[][] glass = new int[6][6] ;
    //  System.out.println("enter the inputs in the 6*6 array");
    int i;
    int j;
    for (i=0; i<6;i++){
      for (j=0; j<6;j++){
        glass[i][j]  = input.nextInt();
      }
    }
    
    int rowmax = 2;
    int rowmin = 0;
    int colmax = 2; 
    int colmin = 0;
    int k;
    int l;
    int sum = 0;
    int max = 0;  
    //this is the 3*3 block that traverses the entire matrix
    while(rowmax!=6){
      for(k=rowmin;k<=rowmax;k++){

        for(l=colmin;l<=colmax;l++){

        //thingy that determines the sum
          if (!(k == rowmin + 1 && (l == colmin || l == colmax))){

          sum = sum + glass[k][l];
          }
        }
      }
      colmin++;
      colmax++;

      if(colmax == 6){
        colmax = 2;
        colmin = 0;
        rowmin++;
        rowmax++;

      }

      System.out.println(sum);
      if(sum > max){
        max = sum;
      }

      sum = 0;

    }
    System.out.println(max);
  }
 }

