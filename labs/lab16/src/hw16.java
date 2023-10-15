
import java.util.Scanner;

public class hw16 {


        public static void EvenOnlyIntegers( )  {
            int[] even = new int[5];
            Scanner sc = new Scanner(System.in);
            int sum = 0;
            int maxSquare = -1;

            for (int i = 0; i < 5; i++) {
                try {
                    System.out.print("enter an even integer: ");
                    int num = sc.nextInt();

                    if (num % 2 != 0) {
                        throw new Exception("even integers only");
                    }

                    even[i] = num;
                    sum += num;
                    int square = num * num;
                    if (square > maxSquare) {
                        maxSquare = square;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    i--;
                    sc.nextLine();
                }
            }

            System.out.println("sum of even integers:" + sum);
            System.out.println("max of squares: " + maxSquare);
        }


        public static void VowelsOnly() {
            char[] vowels = new char[10];
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < 10; i++) {
                try {
                    System.out.print("enter a vowel: ");
                    char ch = sc.next().charAt(0);


                    if ("aeiou".indexOf(ch) == -1) {
                        throw new Exception("vowels only");
                    }

                    vowels[i] = ch;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    i--;

                }
            }

            System.out.println("Vowels entered: ");
            for (int i =0; i< vowels.length;i++) {
                System.out.print(vowels[i] + " ");
            }

        }


        public static void outtaBounds() throws  ArrayIndexOutOfBoundsException {
            int[] array = new int[20];
            for (int i = 0; i < array.length ; i++) {
                array[i] = i;

            }

            try {

                int siuuuuuuu = array[24];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\nThis is an array of size 20!");
            }
        }

    public static void main(String[] args) {

        EvenOnlyIntegers();
        VowelsOnly();
        outtaBounds();
    }
    }


