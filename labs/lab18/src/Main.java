import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JewelryShowroom j = new JewelryShowroom("fraud jewels", "Gulistan", 500000, "bismuth");
        ElectronicsShowroom e = new ElectronicsShowroom("get zapped" , "chernobyl" , 9000000, "smei-conductors");
        try{
            System.out.println("Enter an electronic item to add: ");
            String item = sc.nextLine();
            e.addItem(item);
        }catch(UnapprovedItemException ex ){
            System.out.println(

                ex.getMessage()
            );
        }
        try{
            System.out.println("Enter an electronic item to add: ");
            String item = sc.nextLine();
            e.addItem(item);
        }catch(UnapprovedItemException ex ){

            System.out.println(

                ex.getMessage()
            );
        }
        try{
            System.out.println("Enter an electronic item to add: ");
            String item = sc.nextLine();
            e.addItem(item);
        }catch(UnapprovedItemException ex ){
            System.out.println(

                ex.getMessage()
            );

        }
        try{
            System.out.println("Enter a jewelry item to add: ");
            String item = sc.nextLine();
            j.addItem(item);
        }catch (UnapprovedItemException ex){
            System.out.println(
                ex.getMessage()
            );

        }try{
            System.out.println("Enter a jewelry item to add: ");
            String item = sc.nextLine();
            j.addItem(item);
        }catch (UnapprovedItemException ex){
            System.out.println(
                ex.getMessage()
            );

        }try{
            System.out.println("Enter a jewelry item to add: ");
            String item = sc.nextLine();
            j.addItem(item);
        }catch (UnapprovedItemException ex){
            System.out.println(
                ex.getMessage()
            );

        }
        e.displayInfo();
        j.displayInfo();

    }
}
