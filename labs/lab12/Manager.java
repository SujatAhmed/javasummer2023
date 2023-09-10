/**
 * Manager
 */
public class Manager  extends Employee{


	String department;
	int empcount = 0;
	
	
	Manager(){
		super();

	}
	Manager(String name, double salary,String department, int empcount){
		super(name,salary);
		this.department  = department;
		this.empcount = empcount;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setEmpcount(int empcount) {
		this.empcount = empcount + this.empcount;
	}
	public int getEmpcount() {
		return empcount;
	}
	public String getDepartment() {
		return department;
	}
	public double calculateBonus(double bonus){
		this.salary = super.calculateBonus(bonus) + (((double)empcount)*500);
		return this.salary; 
	}
	
	

	public void displayInfo(){
		super.displayInfo();
		System.out.println("The name of the dpartment is: "+ department);
		
	}







	public static void main(String[] args) {
		Manager m1 = new Manager("Sujat", 1000, "CSE", 2);
		m1.calculateBonus(100);
		m1.displayInfo();
		
	}
}
