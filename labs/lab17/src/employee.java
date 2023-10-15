public class employee {

    private String name;
    private double salary;
    private String department;
    employee(){

    }
    employee(String name , double salary, String department ){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) throws IllegalSalaryException{
        if(salary>=0 && salary<=50000){
            this.salary = salary;
        }
        else{
            throw new IllegalSalaryException(salary);
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public double calculateBonus(double bonus) throws BeyondLimitBonusException {
        if (bonus >= 0 && bonus <= 50) {
            return (bonus * salary) / 100;
        }
        else{
            throw new BeyondLimitBonusException(bonus);
        }
    }

    public String getDepartment() {
        return department;
    }

    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Salary: " + this.salary);
        System.out.println("Department: " + this.department);
    }


}

