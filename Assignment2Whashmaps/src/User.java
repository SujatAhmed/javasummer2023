import java.util.ArrayList;
import java.util.HashMap;

public abstract class User {
    private   String  Name;
    private  String ID;
    private  String Password;
    private ArrayList<Course> courseList ;


    User(){

    }

    User(String Name, String ID, String Password){
        this.Name = Name;
        this.Password = Password;
        this.ID = ID;
        courseList = new ArrayList<>();
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


    public void addCourse(Course course){
        courseList.add(course);
    }

    public abstract void handleAction(HashMap<Integer,Course> courseHashMap);
}
