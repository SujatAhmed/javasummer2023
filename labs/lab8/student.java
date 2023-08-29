import java.util.*;
/**
 * hw801
 */
public class student{
	public static void main(String[] args) {
		student s1 = new student("sujat","2231177","cse");
		System.out.println(s1.getname());
		System.out.println(s1.getID());
		System.out.println(s1.getDept());
		s1.setName("Notsujat");
		s1.setID("not2231177642");
		s1.setdept("notCSE");
		System.out.println(s1.getname());
		System.out.println(s1.getID());
		System.out.println(s1.getDept());

		System.out.println("student info ");
		s1.printinfo();
		
	

		
	}
	private String name;
	private String ID;
	private String dept;
	student(){

	}
	student(String name, String ID, String dept){
		this.name = name;
		this.ID = ID;
		this.dept = dept;
	}
	void setName(String name){
		this.name = name;
	}
	String getname(){
		return name;
	}
	void setID(String ID){
		this.ID = ID;
	}
	String getID(){
		return ID;
	}
	void setdept(String dept){
		this.dept = dept;
	}
	String getDept(){
		return dept;
	}
	void printinfo(){
		System.out.println(name);
		System.out.println(dept);
		System.out.println(ID);

	}
}
