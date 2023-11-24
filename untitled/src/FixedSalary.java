public class FixedSalary extends Employee {
    private double fixedSalary;
    FixedSalary(String name, double salary, double fixedSalary){
        super(name,salary);
        this.fixedSalary = fixedSalary;
        this.salary = calc();
    }
    public double calc(){
        return 0.5*fixedSalary;
    }
    public String toString(){
        return super.toString();
    }

    public static void main(String[] args) {
        System.out.println((new FixedSalary("s",0, 6).toString()));
    }
}
