import java.util.ArrayList;
import java.util.HashMap;

public  class Teacher  extends User{
    Teacher(String Name, String ID, String Password){
        super( Name,  ID,  Password);
    }
    public ArrayList<Student> getStudentList(Course course) {
        return course.getStudentList();
    }
    @Override
    public  void handleAction(HashMap<Integer,Course> courseHashMap){

    }
}
