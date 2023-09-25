// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Employee[] e = new Employee[3];
        e[0] = new Employee("Sujat", 2000);
        e[1] = new Manager("Abir", 2000, 50);
        e[2] = new ContentWriter("Fahmid", 1000, 90);
        System.out.println(e[0] instanceof Manager);
        System.out.println(e[0] instanceof ContentWriter);
        System.out.println(e[1] instanceof Manager);
        System.out.println(e[1] instanceof ContentWriter);
        System.out.println(e[2] instanceof Manager);
        System.out.println(e[2] instanceof ContentWriter);
        Manager m = (Manager) e[1];
        ContentWriter c  = (ContentWriter) e[2];
        m.displayInfo();
        System.out.println("the bonus of the manager "+ m.getName() + " is " + m.calculateBonus(50));
        c.displayInfo();
        System.out.println("the bonus of the manager "+ c.getName() + " is " + c.calculateBonus(40));
    }
}