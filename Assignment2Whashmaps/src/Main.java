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
        User test;
        System.out.println("Enter your ID");
        ID = getString();
        test = userHashMap.get(ID);
        if(test==null){
            userLogin();
            return;
        }
        System.out.println("Enter your Password");
        Password = getString();
        if(!Password.equals(test.getPassword())){
           userLogin();
           return;
        }
        test.handleAction(courseHashMap);
    }

    public static String getString(){
        String string = sc.nextLine();
        String string1 = string;
        return string1;
    }
    public static int getInt(){
        int Int = sc.nextInt();
        return Int;
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
        ArrayList<Integer> storeSerialNumberOfCourses = new ArrayList<>();
        for(Course iterate: student.getCourseList()){
            System.out.println(iterate.getSL() + "." + iterate.getName() );
            storeSerialNumberOfCourses.add(iterate.getSL());
        }
        return  storeSerialNumberOfCourses;
    }
    public static ArrayList<Integer> viewCoursesForTeacher(Teacher teacher){
        ArrayList<Integer> storeSerialNumberOfCourses = new ArrayList<>();
        for(Course iterate: teacher.getCourseList()){
            System.out.println(iterate.getSL() + "." + iterate.getName() );
            storeSerialNumberOfCourses.add(iterate.getSL());
        }
        return storeSerialNumberOfCourses;
    }
    public static ArrayList<Integer> viewStudentsForTeacher(int SL, Teacher teacher){
        ArrayList<Integer> storeSerialNumberOfStudents = new ArrayList<>();
        Course test = new Course();
        for(Course iterate: teacher.getCourseList()){
            if(SL== iterate.getSL()){
                test= iterate;
                break;
            }
        }
        for(Student iterate: test.getStudentList()){
            System.out.println(iterate.getSL()+"."+iterate.getName());
            storeSerialNumberOfStudents.add(iterate.getSL());
        }
        return storeSerialNumberOfStudents;

    }
    public static void removeCourseAccordingToSL(int SL,Student student){
       for(Course iterate: student.getCourseList()) {
           if(SL== iterate.getSL()){
               removeStudentFromCourse(student,iterate);
              break;
           }
       }
    }
    public static void removeStudentAccordingToSL(int Sl,Course course){
       for(Student iterate: course.getStudentList()) {
           if(Sl == iterate.getSL()){
               removeStudentFromCourse(iterate,course);
           }
       }
    }
    public static boolean checkIfWithinList(int SL, ArrayList<Integer> store){
        for(Integer a : store){
            if(a==SL){
                return true;
            }
        }
        return false;
    }



}
