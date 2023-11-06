import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private int SL;
    Student(){

    }

    Student(String Name, String ID, String Password,int SL){
        super( Name,  ID,  Password);
        this.SL = SL;
    }



    public void addCourse(Course course){
        this.getCourseList().add(course);
    }
    public void removeCourse(Course course){
        this.getCourseList().remove(course);
    }

    public int getSL() {
        return SL;
    }
    @Override
    public void handleAction(HashMap<Integer,Course> courseHashMap){
        int choice;
        System.out.println("1.Add courses 2.View Courses 0.Back");
        choice = Main.getInt();
        if(choice==1){
           handleActionForAdding(courseHashMap);
        } else if (choice==2) {
            handeActionForViewing(courseHashMap);
        }
        else{
            Main.getString();
            Main.userLogin();
        }
    }
    public void handeActionForViewing(HashMap<Integer,Course> courseHashMap){
       Main.viewCoursesForStudent(this);
        System.out.println("1.Remove Course 0.Back");
        int choice = Main.getInt();
        if(choice==1){
            handleActionForRemoving(courseHashMap);
        }
        else{
            handleAction(courseHashMap);
        }

    }
    public void handleActionForAdding(HashMap<Integer,Course> courseHashMap){
        System.out.println("Enter the index of the course you want to add according to what's given below: \n 1.CourseA.1 2.CourseA.2 3.CourseA.3 4.CourseB.1 5.CourseC.1 6CourseC.2");
        System.out.println("Press 0 to go back");
        int choice = Main.getInt();
        if(choice==0){
            handleAction(courseHashMap);
        }
        else {
            Course test = courseHashMap.get(choice);
            Main.addCourse(this, test);
            handleActionForAdding(courseHashMap);
        }

    }
    public void handleActionForRemoving(HashMap<Integer,Course> courseHashMap){
        ArrayList<Integer> storeIndex = Main.viewCoursesForStudent(this);
        System.out.println("Enter the Index of the Course you want to remove or press 0 to go back");
        int choice = Main.getInt();
        if(choice==0){
           handleAction(courseHashMap);
           return;
        }
        if(Main.checkIfWithinList(choice,storeIndex)){
            System.out.println("Enter the numbers that are shown to you");
            handleActionForRemoving(courseHashMap);
        }
        else{
            Course test = courseHashMap.get(choice);
            Main.removeStudentFromCourse(this,test);
        }
    }
}
