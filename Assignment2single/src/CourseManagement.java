import java.util.Scanner;
import java.util.ArrayList;

interface Action {
    void handleActions(ArrayList<Course> co);

}
class Course {
    private int section;
    private String name;
    private String timing;

    public Teacher teacher;
    public TA ta;
    private ArrayList<Student> students ;

    Course(){

    }

    Course(String name, int section, Teacher teacher,TA ta,String timing){
        this.section = section;
        this.name = name;
        this.students = new ArrayList<>();
        this.timing = timing;
        this.teacher  = teacher;
        this.ta = ta;


    }

    public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }



    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTiming() {
        return timing;
    }

    public void setTa(TA ta) {
        this.ta = ta;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public TA getTa() {
        return ta;
    }

    public void addStudent(Student student){
        students.add(student) ;
    }
    public void removeStudent(Student student){
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }



}




class User {
    private String name;
    private String email;
    private String ID;
    private String password;
    User(){

    }
    User(String name , String email,String ID, String password){
        this.name = name;
        this.ID = ID;
        this.password= password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}


  class Student extends User implements Action{
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
        int choice = CourseManagement.sc.nextInt();
        if(choice==1){
            this.handelActionsForAdding(co);


        } else if (choice==2) {
            this.handleActionsForViewing(co);

        }
        else if (choice ==0){
            CourseManagement.userLogin();
        }
        else{
            System.out.println("Invalid Input");
            handleActions(co);

        }
    }
    public void handelActionsForAdding(ArrayList<Course> co) {
        int checker = 0;

        String courseCatalogue[] = new String[6];
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";

        Course timingCheck  = new Course();
        System.out.println("Enter the Index of the Course you want to be enrolled in: (1-6) or press 0 to go back");
        System.out.println("1.CourseA.1 2.CourseA.2 3.CourseA.3 4.CourseB.1 5.CourseC.1 6.CourseC.2");

        int choice = CourseManagement.sc.nextInt();
        if(choice<0 || choice>6){
            handelActionsForAdding(co);
            return;
        }

        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(courseCatalogue[choice - 1])) {
                    timingCheck = iterate;
                    break;
                }
            }
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
                if (iterate.getName().equals(courseCatalogue[choice - 1])) {
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
                if (iterate.getName().equals(courseCatalogue[choice - 1])) {
                    CourseManagement.addCourse(this, iterate);
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
        System.out.println("Your courses: ");
        CourseManagement.viewCourse(this);
        System.out.println("1.Remove Courses 0.Back");
        int choice = CourseManagement.sc.nextInt();
        if(choice ==1){
            this.handleActionsForRemoving(co);
        }
        else{
            this.handleActions(co);
        }
    }

    public void handleActionsForRemoving(ArrayList<Course> co){
        String courseCatalogue[] = new String[6];
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";

        System.out.println("Enter the index of the course you want to dropout from or press 0 to go back");

        int choice = CourseManagement.sc.nextInt();
        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(courseCatalogue[choice - 1])) {
                    CourseManagement.removeCourse(this, iterate);
                }
            }
            this.handleActionsForRemoving(co);
        }
        else{
            this.handleActionsForViewing(co);

        }



    }
}
class Teacher extends User implements Action{
    Teacher(){

    }
    Teacher(String name, String ID, String email, String password){
        super(name, email, ID, password);
    }

    @Override
    public void handleActions(ArrayList<Course> co){
        System.out.println("1.View Courses 2.Logout");
        int choice = CourseManagement.sc.nextInt();
        if(choice==1){
            handleActionsForViewing(co);
        }
        else{
            CourseManagement.userLogin();
        }

    }




    public void handleActionsForRemoving(ArrayList<Course> co,int courseNumber){
        String[] courseCatalogue = new String[6];
        Course test = new Course();
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";

        String[] studentCatalogue = new String[3];
        studentCatalogue[0] = "A";
        studentCatalogue[1] = "B";
        studentCatalogue[2] = "C";

        System.out.println("Enter the index of the student to be removed: ");
        int choice = CourseManagement.sc.nextInt();
        String studentName = studentCatalogue[choice-1];
        for(Course iterate : co){
            for(int i = 0; i<courseCatalogue.length;i++){
                if(courseCatalogue[courseNumber-1].equals(iterate.getName())){
                    test = iterate;
                    break;
                }
            }
        }
        for(Student st : test.getStudents()){
            if(studentName.equals(st.getName())){
                CourseManagement.removeCourse(st,test);
                break;
            }
        }


        System.out.println("1.Remove Students 0.Back");
        choice = CourseManagement.sc.nextInt();
        if(choice ==1){
            handleActionsForRemoving(co,courseNumber);
        }
        else{
            handleActions(co);
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        String[] courseCatalogue = new String[6];
        Course test = new Course();
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";
        String[] studentCatalogue = new String[3];
        studentCatalogue[0] = "A";
        studentCatalogue[1] = "B";
        studentCatalogue[2] = "C";
        System.out.println("Enter the index of the course you want to view: ");
        CourseManagement.viewCourse(this);
        int choicePrime = CourseManagement.sc.nextInt();
        for(Course iterate: co){
            if(courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        for(Student st : test.getStudents()){
            for(int i = 0; i <studentCatalogue.length;i++){
                if(studentCatalogue[i].equals(st.getName())){
                    System.out.println((i+1) + ") "+ st.getName() );
                }
            }
        }


        System.out.println("1.Remove Students 0.Back");
        int choice = CourseManagement.sc.nextInt();
        if(choice==1){
            this.handleActionsForRemoving(co,choicePrime);
        }
        else{
            this.handleActions(co);
        }

    }


}
class TA extends User implements  Action{
    TA(String name, String ID, String email, String password){
        super(name, email, ID, password);
    }

    public void handleActions(ArrayList<Course> co){
        System.out.println("1.View Courses 2.Logout");
        int choice = CourseManagement.sc.nextInt();
        if(choice==1){
            handleActionsForViewing(co);
        }
        else{
            CourseManagement.userLogin();
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        String[] courseCatalogue = new String[6];
        Course test = new Course();
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";
        String[] studentCatalogue = new String[3];
        studentCatalogue[0] = "A";
        studentCatalogue[1] = "B";
        studentCatalogue[2] = "C";
        System.out.println("Enter the index of the course you want to view: ");
        CourseManagement.viewCourse(this);
        int choicePrime = CourseManagement.sc.nextInt();
        for(Course iterate: co){
            if(courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        for(Student st : test.getStudents()){
            for(int i = 0; i <studentCatalogue.length;i++){
                if(studentCatalogue[i].equals(st.getName())){
                    System.out.println((i+1) + ") "+ st.getName() );
                }
            }
        }
        this.handleActions(co);

    }

}


class Session {
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

public class CourseManagement {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<User> userList = new Session().getUsers();
    public static ArrayList<Course> courseList = new Session().getCourses();

    public static void main(String[] args) {
        userLogin();

    }
    public static void userLogin(){
        int checker = 0;
        System.out.println("Which one are you: 1.Student 2.Teacher 3.TA" );
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your ID: ");
        String ID = sc.nextLine();
        for (User iterate : userList){
            if(iterate.getID().equals(ID)){
               checker = 1;
               break;
            }
        }
        if(checker==0){
            System.out.println("Wrong ID please try again ");
            userLogin();
            return;
        }
        for (User iterate: userList){
            if(iterate.getID().equals(ID)){
                System.out.println("Enter your password: ");
                String Password = sc.nextLine();
                if(iterate.getPassword().equals(Password)){
                    System.out.println("Welcome, " + iterate.getName());
                    if(choice==1){
                        Student st = (Student)iterate;
                        st.handleActions(courseList);
                        break;
                    }
                    else if(choice ==2){
                        Teacher te = (Teacher)iterate;
                        te.handleActions(courseList);
                        break;
                    }
                    else if(choice ==3){
                        TA ta = (TA)iterate;
                        ta.handleActions(courseList);
                        break;
                    }
                }
                else{
                    System.out.println("Invalid password, please try again");
                    userLogin();
                    break;
                }
            }

        }
    }
    public static void addCourse(Student st, Course co){

        co.addStudent(st);

    }
    public static void removeCourse(Student st, Course co){
        co.removeStudent(st);

    }
    public static void viewCourse(Student st){
        for(Course iterate1: courseList) {
            for(Student iterate2 : iterate1.getStudents()){
                if(st.getName().equals(iterate2.getName())) {
                    System.out.println(iterate1.getName()+ " ");
                }
            }
        }
    }
    public static void viewCourse(Teacher teach){
        String courseCatalogue[] = new String[6];
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";

        for(Course iterate1: courseList) {
            if(teach.getName().equals(iterate1.getTeacher().getName())){
                for(int i = 0; i < courseCatalogue.length; i++){
                    if(courseCatalogue[i].equals(iterate1.getName())){
                        System.out.println((i+1)+ ") " +iterate1.getName());
                    }
                }
            }
        }
    }
    public static void viewCourse(TA ta){
        String courseCatalogue[] = new String[6];
        courseCatalogue[0] = "CourseA.1";
        courseCatalogue[1] = "CourseA.2";
        courseCatalogue[2] = "CourseA.3";
        courseCatalogue[3] = "CourseB.1";
        courseCatalogue[4] = "CourseC.1";
        courseCatalogue[5] = "CourseC.2";

        for(Course iterate1: courseList) {
            if(ta.getName().equals(iterate1.getTa().getName())){
                for(int i = 0; i < courseCatalogue.length; i++){
                    if(courseCatalogue[i].equals(iterate1.getName())){
                        System.out.println((i+1)+ ") " +iterate1.getName());
                    }
                }
            }
        }
    }
}






