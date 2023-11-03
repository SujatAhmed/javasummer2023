import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    DataBase(){
        createDatabase();
    }
    private HashMap <Integer, Course> courseList = new HashMap<Integer,Course>();
    private HashMap <String, User> userList = new HashMap<String,User>();

    public void createDatabase(){
        userList.put("S1", new Student("A","S1","password",1)) ;
        userList.put("S2", new Student("B","S2","password",2)) ;
        userList.put("S3", new Student("C","S3","password",3)) ;
        userList.put("T1",new Teacher("A","T1","password"));
        userList.put("T2",new Teacher("B","T2","password"));
        courseList.put(1, new Course("CourseA.1",1,1));
        courseList.put(2, new Course("CourseA.2",2,2));
        courseList.put(3, new Course("CourseA.3",3,3));
        courseList.put(4, new Course("CourseB.1",1,4));
        courseList.put(5, new Course("CourseC.1",1,5));
        courseList.put(6, new Course("CourseC.2",2,6));
        courseList.get(1).setTeacher((Teacher) userList.get("T1"));
        courseList.get(2).setTeacher((Teacher) userList.get("T1"));
        courseList.get(3).setTeacher((Teacher) userList.get("T2"));
        courseList.get(4).setTeacher((Teacher) userList.get("T1"));
        courseList.get(5).setTeacher((Teacher) userList.get("T1"));
        courseList.get(6).setTeacher((Teacher) userList.get("T2"));
        userList.get("T1").addCourse(courseList.get(1));
        userList.get("T1").addCourse(courseList.get(2));
        userList.get("T1").addCourse(courseList.get(4));
        userList.get("T1").addCourse(courseList.get(5));
        userList.get("T2").addCourse(courseList.get(3));
        userList.get("T2").addCourse(courseList.get(6));

    }

    public HashMap<Integer, Course> getCourseList() {
        return courseList;
    }

    public HashMap<String, User> getUserList() {
        return userList;
    }
}
