/**
 * Employee
 */
public class Employee {
	String name;
	double salary;
	Employee(){
		name = " ";
		salary = 0;

	}
	Employee(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	double calculateBonus(double bonus){
		
		this.salary  = this.salary + (bonus/100)*this.salary;
		return salary;
	}
	public void displayInfo(){
		System.out.println("the name of the employee is: " + this.name  );
		System.out.println(" the salary of the employee is: " + this.salary);
	}



    public static void main(String[] args) {
    	
    }	
}
