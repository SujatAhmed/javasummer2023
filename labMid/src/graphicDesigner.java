
import  java.util.*;

public class graphicDesigner extends Employee {



    private String specialization;
    private int completedProjects;
    private static double collectiveSalary = 0;
    private static int numOfDesigners = 0;

    graphicDesigner(){
        super();
        numOfDesigners++;

    }
    graphicDesigner(String name, String department, double monthly_salary, String specialization, int completedProjects ){
        super(name,department,monthly_salary);
        this.specialization = specialization;
        this.completedProjects = completedProjects;
        numOfDesigners++;
        collectiveSalary = collectiveSalary + monthly_salary;


    }
    public String getSpecialization(){
        return this.specialization;
    }
    public int getCompletedProjects() {
        return this. completedProjects;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;

    }
    public void setCompletedprojects(int completedProjects  ) {
        this.completedProjects =  completedProjects;
    }
    public static void displayDesignersDataBase() {
        double avgSalary = collectiveSalary/(double)numOfDesigners;
        System.out.println("Total salary of the designers is: " + collectiveSalary);
        System.out.println("The average salary of the designer is: " + avgSalary );
        //I forgot to print the number of graphicalDesigner variables but it's implemented in the constructors



    }
    public void displaystatus() {
        if(this.completedProjects> 5) {
            System.out.println("Professional designer");
        }
        else {
            System.out.println("Novice Designer");
        }
    }
    @Override
    public double getAnnualSalary() {
        double bonus = (double)completedProjects*1000;
        double annual = 12*this.getSalary();
        return (bonus + annual);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("The specialization of the employe is"+ this.specialization);
        System.out.println("The number of projects done is"+ this.completedProjects);

    }

    public static void main(String[] args) {
        graphicDesigner[] g = new graphicDesigner[5];
        Scanner sc = new Scanner(System.in);
        double max = -1;


        g[0] = new graphicDesigner("Sujat", "B", 2000, "C", 6);
        g[1] = new graphicDesigner("Abir", "E", 8000, "F", 1 );
        g[2] = new graphicDesigner("Azmayeen", "F", 3000, "G", 3 );




        for (int i = 0; i <3 ; i++) {
            g[i].displayInfo();
            g[i].displaystatus();
            System.out.println("  ");


        }
        graphicDesigner.displayDesignersDataBase();




        for (int i = 0; i < 2; i++) {
            if(g[i].getSalary()>max) {
                max = g[i].getSalary();
            }

        }
        System.out.println("The max salary is: " + max);

/*   main method used in mid
        for(int  i= 0; i <2; i++) {
            System.out.println("Enter the name, department, monthly salary, specialization and completed projects : ");
            String name = sc.nextLine();
            String dept = sc.nextLine();
            double sal = sc.nextDouble();
            String spec = sc.nextLine();
            int CP = sc.nextInt();
            sc.next();

            g[i] = new graphicDesigner(name,dept,sal,spec,CP);
        }
        for(int i = 0; i<2; i ++) {
            if(g[i].getSalary()>max) {
                max = g[i].getSalary();
            }
        }
        System.out.println(" the max salary is: " + max);
        graphicDesigner.displayDesignersDataBase() ;
        g[0].getAnnualSalary();
        g[0].displayInfo();
        g[0].displaystatus();
        g[1].displaystatus();*/




    }


}
