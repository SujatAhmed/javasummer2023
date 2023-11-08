import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<Integer,Course> courseHashMap = new DataBase().getCourseList();
    public static HashMap<String,User> userHashMap = new DataBase().getUserList();

    public static void main(String[] args) {
        userLogin();
    }

    public static void userLogin(){
        String ID;
        String Password;
        User dummyUser;
        System.out.println("Enter your ID");
        ID = getString();
        dummyUser = userHashMap.get(ID);
        if(dummyUser==null){
            userLogin();
            return;
        }
        System.out.println("Enter your Password");
        Password = getString();
        if(!Password.equals(dummyUser.getPassword())){
           userLogin();
           return;
        }
        dummyUser.handleAction(courseHashMap);
    }

    public static String getString(){
        return sc.nextLine();
    }
    public static int getInt(){
        return sc.nextInt();
    }

    public static void addCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);
    }

    public static void removeStudentFromCourse(Student student, Course course){
        student.removeCourse(course);
        course.removeStudent(student);
    }

    public static ArrayList<Integer> viewCoursesForStudent(Student student){
        for(Course iterate: student.getCourseList()){
            System.out.println(iterate.getSL() + "." + iterate.getName() );
        }
        return student.getSLofCourses();
    }

    public static ArrayList<Integer> viewCoursesForTeacher(Teacher teacher){
        for(Course iterate: teacher.getCourseList()){
            System.out.println(iterate.getSL() + "." + iterate.getName() );
        }
        return teacher.getSLofCourses();
    }

    public static ArrayList<Integer> viewStudentsForTeacher(  Course course){
        for(Student iterate: course.getStudentList()){
            System.out.println(iterate.getSL()+"."+iterate.getName());
        }
        return course.getSLofStudents();
    }


    public static boolean checkIfWithinList(int SL, ArrayList<Integer> store){
        for(Integer a : store){
            if(a==SL){
                return false;
            }
        }
        return true;
    }
}
