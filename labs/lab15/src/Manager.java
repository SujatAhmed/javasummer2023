public class Manager extends  Employee{
    private  int employeeCount;
    Manager(){

    }
    Manager(String name, double salary, int employeeCount){
        super(name,salary);
        this.employeeCount = employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }
    @Override
    public double calculateBonus(double bonus){
        return (getSalary()*bonus/100)+ (250*(double)employeeCount);
    }
    @Override
    public void displayInfo(){
        System.out.println("The name of the manager is " + this.getName());
        System.out.println("The salary of the manager is " + this.getSalary());
        System.out.println("The employee count of the manager is " + this.employeeCount );
    }


}
