import java.util.Scanner;
public class labhw3 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int mark1 = input.nextInt();

        double result = Math.pow(mark1, 0.5);
        
        System.out.println("the result is: " + result);
        System.out.println("");
        input.close();


        
    }
}
