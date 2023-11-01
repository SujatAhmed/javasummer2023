import java.util.ArrayList;
import java.util.InputMismatchException;

public class Teacher extends User implements Action{
    Teacher(){

    }
    Teacher(String name, String ID, String email, String password){
        super(name, email, ID, password);
    }

    @Override
    public void handleActions(ArrayList<Course> co){
        int choice;
        System.out.println("1.View Courses 2.Logout");
        try {
            choice = Main.sc.nextInt();
        }catch (InputMismatchException ex){
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
        else {
            System.out.println("\nInvalid parameters, try again");
            handleActions(co);
            return;
        }

    }




    public void handleActionsForRemoving(ArrayList<Course> co,int courseNumber,ArrayList<Integer> sto){
        Course test = new Course();
        int choice;

        System.out.println("Enter the index of the student to be removed or press 0 to go back: ");
        for(Integer st: sto){
            for(int i =0 ; i<Main.studentCatalogue.length;i++){
                if(st==(i+1)){
                    System.out.println(st + "."+ Main.studentCatalogue[i]);
                }
            }
        }
        try {
            choice = Main.sc.nextInt();
        }catch (InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForRemoving(co,courseNumber,sto);
            return;
        }
        if(choice==0){
            handleActionsForViewing(co);
            return;
        }
        if(choice<1||choice>3){
            System.out.println("Invalid input please try again");
            handleActionsForRemoving(co,courseNumber,sto);
        }
        if(!Main.checkWithinBounds(sto,choice)){
            System.out.println("Please enter the indexes according to what is shown to you");
            handleActionsForRemoving(co,courseNumber,sto);
        }

        String studentName = Main.studentCatalogue[choice-1];
        for(Course iterate : co){
            for(int i = 0; i<Main.courseCatalogue.length;i++){
               if(Main.courseCatalogue[courseNumber-1].equals(iterate.getName())){
                test = iterate;
                break;
                }
            }
        }
        for(Student st : test.getStudents()){
            if(studentName.equals(st.getName())){
                Main.removeCourse(st,test);
                System.out.println(st.getName()+ " has been removed from " + test.getName());
                break;
            }
        }


        System.out.println("1.Remove Students 0.Back");
        try {
            choice = Main.sc.nextInt();
        }catch (InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForRemoving(co,courseNumber,sto);
            return;
        }
        if(choice ==1){
            handleActionsForRemoving(co,courseNumber,sto);
        }
        else{
            handleActions(co);
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        ArrayList<Integer> storeStudents = new ArrayList<>();
        ArrayList<Integer> storeCourses = new ArrayList<>();

        int choicePrime;
        int choice;
        Course test = new Course();
        System.out.println("Enter the index of the course you want to view according to what is printed below or press 0 to go back: ");
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
        if(choicePrime>6||choicePrime<1){
            System.out.println("Invalid input please try again");
            handleActionsForViewing(co);
            return;
        }
        if(!Main.checkWithinBounds(storeCourses,choicePrime)){
            System.out.println("Please enter the numbers according to what's given");
            handleActionsForViewing(co);
            return;

        }

        for(Course iterate: co){
            if(Main.courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        System.out.println("Students of " + test.getName());
        for(Student st : test.getStudents()){
            for(int i = 0; i <Main.studentCatalogue.length;i++){
                if(Main.studentCatalogue[i].equals(st.getName())){
                    System.out.println((i+1) + ") "+ st.getName() );
                    storeStudents.add((i+1));
                }
            }
        }


        System.out.println("1.Remove Students 0.Back");
        try{
            choice = Main.sc.nextInt();
        }catch (InputMismatchException ex){
            Main.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForViewing(co);
            return;
        }
        if(choice==1){
            this.handleActionsForRemoving(co,choicePrime,storeStudents);
        }
        else{
            this.handleActions(co);
        }

    }

}
