public class Main {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello")).start();
    }

    public static void printStuff(int a){
        for (int i = 0; i <5 ; i++) {
            System.out.println(i + " from thread " + a );
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
