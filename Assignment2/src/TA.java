import java.util.ArrayList;
import java.util.InputMismatchException;

public class TA extends User implements  Action{
    TA(String name, String ID, String email, String password){
        super(name, email, ID, password);
    }

    public void handleActions(ArrayList<Course> co){
        int choice;
        System.out.println("1.View Courses 2.Logout");
        try{
            choice = Main.sc.nextInt();
        }catch(InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActions(co);
            return;
        }

        if(choice==1){
            handleActionsForViewing(co);
        }
        else if(choice ==2){
            Main.sc.nextLine();
            Main.userLogin();
        }
        else{
            handleActions(co);
            return;
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        int choicePrime;
        ArrayList<Integer> storeCourses;
        Course test = new Course();
        System.out.println("Enter the index of the course you want to view or press 0 to go back: ");
        storeCourses = Main.viewCourse(this);
        try{

            choicePrime = Main.sc.nextInt();
        }catch (InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForViewing(co);
            return;
        }
        if(choicePrime==0){
            handleActions(co);
            return;
        }
        if(!Main.checkWithinBounds(storeCourses,choicePrime)){
            System.out.println("Please enter the indexes that are shown to you below");
            handleActionsForViewing(co);
            return;
        }

        for(Course iterate: co){
            if(Main.courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        System.out.println("The students of " + test.getName());
        for(Student st : test.getStudents()){
            for(int i = 0; i <Main.studentCatalogue.length;i++){
                if(Main.studentCatalogue[i].equals(st.getName())){
                    System.out.println((i+1) + ") "+ st.getName() );
                }
            }
        }
        this.handleActions(co);

    }
}

