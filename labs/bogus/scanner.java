import java.util.Scanner;
public class scanner{
  public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Enter the three marks");
        

        System.out.println("Enter the 1st mark");
        double m1= input.nextDouble();
        System.out.println("Enter the 2nd mark");
        double m2= input.nextDouble();
        System.out.println("Enter the 3rd mark");
        double m3 = input.nextDouble();

        double average = (m1+m2+m3)/3;
        System.out.println(" this is the average " + average);


        m1=m1+1;
        m2=m2+1;
        m3=m3+1;

        double average1 = (m1+m2+m3)/3;


        System.out.println(" this is the new average " + average1);


    }
}



