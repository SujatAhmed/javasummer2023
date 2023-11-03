import java.util.ArrayList;
import java.util.HashMap;

public  class Teacher  extends User{
    Teacher(String Name, String ID, String Password){
        super( Name,  ID,  Password);
    }

    @Override
    public  void handleAction(HashMap<Integer,Course> courseHashMap){
        System.out.println("1.View Course 0.Logout");
        int choice = Main.getInt();

        if(choice==1){
            handleActionForViewing(courseHashMap);
        } else if (choice==0) {
            Main.getString();
            Main.userLogin();
        }

    }
    public void handleActionForViewing(HashMap<Integer,Course> courseHashMap){
       ArrayList<Integer> storeCourses = Main.viewCoursesForTeacher(this);
        System.out.println("Enter the index of the Course you want to view of press 0 to go back");
        int choice = Main.getInt();
        if(choice==0){
            handleAction(courseHashMap);
            return;
        }
        if(Main.checkIfWithinList(choice,storeCourses)){
            System.out.println("Enter numbers within the given bound");
            handleActionForViewing(courseHashMap);
            return;
        }

        Course test = courseHashMap.get(choice);
        Main.viewStudentsForTeacher(test);
        System.out.println("1.Remove Students 0.Back");
        choice = Main.getInt();
        if (choice==1){
            handleActionForRemoving(courseHashMap,test);
        }
        else{
           handleActionForViewing(courseHashMap);
        }

    }
    public void handleActionForRemoving(HashMap<Integer,Course> courseHashMap,Course course){
        ArrayList<Integer> storeStudents ;
        storeStudents = Main.viewStudentsForTeacher(course);
        System.out.println("Enter the index of the student you want to remove of press 0 to back ");
        int choice = Main.getInt();
        boolean back = (choice==0);
        if(back){
            handleActionForViewing(courseHashMap);
            return;
        }

        if(Main.checkIfWithinList(choice,storeStudents)){
            System.out.println("Wrong number nigga");
            handleActionForRemoving(courseHashMap,course);
            return;
        }
        Student test = new Student();
        for(Student iterate : course.getStudentList()){
            if(choice == iterate.getSL()){
                test = iterate;
                break;
            }
        }
        Main.removeStudentFromCourse(test,course);
        handleActionForRemoving(courseHashMap,course);
    }
}
