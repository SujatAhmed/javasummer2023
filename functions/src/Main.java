public class Main {
    public static void main(String[] args) {
        int b = foo1(foo());
    }
    public static int foo(){
        System.out.println("hello world");
        return 1;
    }
    public static int foo1(int a){
        return a;
    }

}
