import java.util.ArrayList;
import java.util.HashMap;

public abstract class User {
    private   String  Name;
    private  String ID;
    private  String Password;
    private ArrayList<Course> courseList ;

    private ArrayList<Integer> SLofCourse;
    User(){

    }

    User(String Name, String ID, String Password){
        this.Name = Name;
        this.Password = Password;
        this.ID = ID;
        courseList = new ArrayList<>();
        SLofCourse = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public ArrayList<Integer> getSLofCourse() {
        for(Course iterate : this.courseList){
            SLofCourse.add(iterate.getSL());
        }
        return SLofCourse;
    }
    public abstract void handleAction(HashMap<Integer,Course> courseHashMap);
}
