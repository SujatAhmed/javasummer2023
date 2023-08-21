import java.util.Scanner;
public class pattern{





    public static void main(String[] args) {
        Scanner take_char = new Scanner(System.in);


        System.out.println("input the characters a and b");

        char c = take_char.next().charAt(0);
        char d = take_char.next().charAt(0);
        
        patterncreator(c, d);
        take_char.close();
    }

     

     public static void patterncreator(char a, char b){

        Scanner input = new Scanner(System.in);

        System.out.println("input the rows you'd like to have ");
        int x = input.nextInt();
        //int b = input.nextInt();

        for(int i=0 ; i<x ;i++){
            for(int j = 0; j<=i;j++){
                if(j%2==0){
                    
                     System.out.print("" + a);
                }
                else{
                    
                     System.out.print(""+ b);

                }

            }
            System.out.println("");
        }
        input.close();
        
    }
}
