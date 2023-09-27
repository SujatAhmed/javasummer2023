public class Employee {
    private String name;
    private double salary;
    Employee(){

    }
    Employee(String name , double salary ){
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public double calculateBonus(double bonus){
        return (bonus*salary)/100;
    }
    public void displayInfo(){
        System.out.println("The name of the employee is " + this.name);
        System.out.println("The salary of the employee is " + this.salary);
    }
    public static void objectOverview(Object object){
        if(object instanceof Manager){
            Manager m = new Manager();
            m = (Manager)object;
            m.displayInfo();
        } else if (object instanceof ContentWriter) {
            ContentWriter c = new ContentWriter();
            c = (ContentWriter)object;
            c.displayInfo();

        } else if (object instanceof GraphicDesigner) {
            GraphicDesigner g = new GraphicDesigner();
            g = (GraphicDesigner) object;
            g.displayInfo();

        }
        else {

            Employee e = new Employee();
            e = (Employee) object;
            e.displayInfo();

        }


    }

}
