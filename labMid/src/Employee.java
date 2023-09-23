public class Employee {

        private String name;
        private String department;
        private double monthly_salary;

        Employee(){

        }
        Employee(String name, String department, double monthly_salary ){
            this.name = name;
            this.department = department;
            this.monthly_salary = monthly_salary;
        }

        public String getName() {
            return this.name;
        }
        public String getDepartment() {
            return this.department;
        }
        public double getSalary() {
            return this.monthly_salary;
        }
        public void setName(String name) {
            this.name = name ;

        }
        public void setSalary(double monthly_salary) {
            this.monthly_salary = monthly_salary;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public double getAnnualSalary() {
            return (12*this.monthly_salary);
        }
        public void displayInfo() {
            System.out.println("The name of the employee is: "+ this.name);
            System.out.println("The department of the employee is: "+ this.department);
            System.out.println("The annual salary of the employee is: "+ this.getAnnualSalary());

        }

    }






