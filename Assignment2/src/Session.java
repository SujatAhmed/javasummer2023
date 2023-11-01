import java.util.ArrayList;

public class Session {
    private static Session session;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    Session(){
        session = this;
        createDatabase();
    }
    public void createDatabase(){
        Student studentA = new Student("A","S1","student_a@northsouth.edu","password","3.4");
        Student studentB = new Student("B","S2","student_b@northsouth.edu","password","3.6");
        Student studentC=  new Student("C","S3","student_c@northsouth.edu","password","3.2");
        Teacher  teacherA= new Teacher("A", "T1","teacher_a@northsouth.edu","password");
        Teacher teacherB = new Teacher("B", "T2","teacher_b@northsouth.edu","password");
        TA taA = new TA("A", "A1","assistant_a@northsouth.edu","password");
        TA taB = new TA("B", "A2","assistant_b@northsouth.edu","password");
        users.add(studentA);
        users.add(studentB);
        users.add(studentC);
        users.add(teacherA);
        users.add(teacherB);
        users.add(taA);
        users.add(taB);

        courses.add(new Course("CourseA.1", 1,teacherA,taA,"A"));
        courses.add(new Course("CourseA.2", 2,teacherB,taA,"A"));
        courses.add(new Course("CourseA.3", 3,teacherA,taB,"B"));
        courses.add(new Course("CourseB.1", 1,teacherA,taA,"D"));
        courses.add(new Course("CourseC.1", 1,teacherB,taA,"B"));
        courses.add(new Course("CourseC.2", 2,teacherA,taB,"C"));


    }

    public static Session getSession() {
        return session;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
