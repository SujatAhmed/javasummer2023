public class Employee {
    protected String name;
    protected double salary;
    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;

    }
    @Override
    public String toString(){
        return this.name+ this.salary;

    }
}
