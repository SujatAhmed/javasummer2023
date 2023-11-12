public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> printStuff(1));
        Thread thread2 = new Thread(()->printStuff(2));
        thread1.start();
        thread2.start();
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
