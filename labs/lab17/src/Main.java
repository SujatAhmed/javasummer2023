import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        employee e = new employee("Sujat", 500000, "");
        String[] Departments = {"Sales", "Marketing", "Logistics", "Promotions"};
        String department;
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the department name: ");
            department = sc.nextLine();
            int checker = 0;
            for (String s : Departments) {
                if (s.equals(department)) {
                    e.setDepartment(department);
                    checker = 1;
                    break;
                }

            }
            if(checker ==0 ){
                throw new InvalidDepartmentException(department);
            }
        }catch(InvalidDepartmentException ex){
            System.out.println(ex.getMessage());

        }
    }

}
