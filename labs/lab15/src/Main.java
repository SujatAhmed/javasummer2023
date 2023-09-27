// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Employee[] e = new Employee[4];
        e[0] = new Employee("Sujat", 2000);
        e[1] = new Manager("Abir", 2000, 50);
        e[2] = new ContentWriter("Fahmid", 1000, 90);
        e[3] = new GraphicDesigner("ekanto", 5000, "Logo Design");
        for (int i = 0; i < e.length ; i++) {
            Employee.objectOverview(e[i]);

        }

    }
}