import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student extends User {
    private String CGPA;

    Student(String name, String ID, String email, String password,String CGPA){
        super(name, email, ID, password);
        this.CGPA = CGPA;
    }

    public String getCGPA() {
        return CGPA;
    }
    public void handleActions(ArrayList<Course> co){
        System.out.println("1.Add Course 2.View Courses 0.Back");
        int choice;

        try{
            choice = Main.sc.nextInt();
        }catch(InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActions(co);
            return;
        }

        if(choice==1){
            this.handelActionsForAdding(co);


        } else if (choice==2) {
            this.handleActionsForViewing(co);

        }
        else if (choice==0){
            Main.sc.nextLine();
            Main.userLogin();
        }
        else{
            System.out.println("Enter the numbers within the given options");
            handleActions(co);
        }
    }
    public void handelActionsForAdding(ArrayList<Course> co) {
        int choice;
        int checker = 0;


        Course timingCheck  = new Course();
        System.out.println("Enter the Index of the Course you want to be enrolled in: (1-6) or press 0 to go back");
        System.out.println("1.CourseA.1 2.CourseA.2 3.CourseA.3 4.CourseB.1 5.CourseC.1 6.CourseC.2");

        try {
            choice = Main.sc.nextInt();
        }catch (InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handelActionsForAdding(co);
            return;
        }

        if(choice<0 || choice>6){
            System.out.println("Invalid parameter please try again");
            handelActionsForAdding(co);
            return;
        }

        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(Main.courseCatalogue[choice - 1])) {
                    timingCheck = iterate;
                    break;
                }
            }
            //Logic to check if the student is enrolled in Different section of same course.
            String nameCheck = timingCheck.getName();
            int excludedIndex = nameCheck.length()-2;
            String actualCourseName = nameCheck.substring(0,excludedIndex);

            for (Course iterate : co) {
                for (Student st : iterate.getStudents()) {
                    if (st.getName().equals(this.getName())) {
                        if (iterate.getTiming().equals(timingCheck.getTiming())) {
                            if (iterate != timingCheck) {
                                checker = 1;
                                System.out.println("The timing of this course clashes with " + iterate.getName());
                                break;
                            }
                        }
                    }
                }
            }
            for (Course iterate : co) {
                for (Student st : iterate.getStudents()) {
                    if (st.getName().equals(this.getName())) {
                        if(iterate.getName().contains(actualCourseName)){
                            checker = 1;
                            System.out.println("You are already enrolled in this course");
                            break;

                        }
                    }
                }
            }
            for (Course iterate : co) {
                if (iterate.getName().equals(Main.courseCatalogue[choice - 1])) {
                    if (iterate.getStudents().size() >= 5) {
                        checker = 1;
                        System.out.println("This course if filled: ");
                        break;
                    }
                }
            }
        }




        if(choice!=0 && checker==0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(Main.courseCatalogue[choice - 1])) {
                    Main.addCourse(this, iterate);
                    System.out.println("Course " + iterate.getName() + " Added successfully");
                }

            }
            this.handelActionsForAdding(co);
        }
        else{
            handleActions(co);
        }
    }
    public void handleActionsForViewing(ArrayList<Course> co){
        ArrayList<Integer> courseIndex;
        int choice;
        System.out.println("Your courses: ");
        courseIndex = Main.viewCourse(this);
        System.out.println("1.Remove Courses 0.Back");

        try {
            choice = Main.sc.nextInt();
        }catch(InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForViewing(co);
            return;
        }

        if(choice<0 || choice>1){
            System.out.println("Invalid parameters please try again");
            handleActions(co);
            return;

        }
        if(choice ==1){
            this.handleActionsForRemoving(co,courseIndex);
        }
        else{
            this.handleActions(co);
        }
    }

    public void handleActionsForRemoving(ArrayList<Course> co, ArrayList<Integer> courseIndex){

        int choice;
        System.out.println("Enter the index of the course you want to dropout from or press 0 to go back");
        System.out.println("According to this index given below");
        Main.viewCourse(this);


        try {
            choice = Main.sc.nextInt();
        }catch(InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForRemoving(co,courseIndex);
            return;
        }

        if(choice<0 || choice>6){
            System.out.println("Invalid parameters please try again");
            handleActionsForRemoving(co, courseIndex);
            return;
        }
        if(!Main.checkWithinBounds(courseIndex,choice)){
            System.out.println("Please only Enter the index shown to you");
            handleActionsForViewing(co);
            return;
        }

        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(Main.courseCatalogue[choice - 1])) {
                    Main.removeCourse(this, iterate);
                    System.out.println(iterate.getName()+ " has been successfully removed from your catalogue");
                    break;
                }
            }
            this.handleActionsForViewing(co);
        }
    }
}
