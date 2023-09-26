import java.util.Scanner;

public class exception2 {
    public static void array( ) throws ArrayIndexOutOfBoundsException{
        int input = 0;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int)(Math.random()*1000);

        }

        try {
            System.out.println("Enter the index you want to see ");
            input = sc.nextInt();
            if(input>=100||input<0){
                throw new ArrayIndexOutOfBoundsException("This is outta bounds!");
            }
            else {
                System.out.println("The value of index that you have wanted is: " + arr[input]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            array();

        }bb

    }

    public static void main(String[] args) {
        array();
    }
}
