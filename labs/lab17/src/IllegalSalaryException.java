public class IllegalSalaryException extends Exception {
    private double salary;
    public IllegalSalaryException(double salary){
        super("Invalid salary: " + salary);
        this.salary = salary;

    }

    public double getSalary() {
        return salary;
    }
}
