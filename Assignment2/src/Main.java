import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<User> userList = new Session().getUsers();
    public static ArrayList<Course> courseList = new Session().getCourses();
    public static String[] courseCatalogue = {"CourseA.1","CourseA.2","CourseA.3","CourseB.1","CourseC.1","CourseC.2"};
    public static String[] studentCatalogue = {"A","B","C"};


    public static void main(String[] args) {
        userLogin();
    }

    public static void userLogin(){
        User testUser = null;

        int choice;
        String Password;
        String ID;
        System.out.println("Enter your ID.(If you're a Student,Teacher or TA, enter your appropriate IDs)");
        ID = sc.nextLine();
        for(User iterate : userList){
            if(iterate.getID().equals(ID)){
                testUser = iterate;
            }
        }
        if(testUser==null){
            System.out.println("The ID does not match with any user in the database, please try again");
            userLogin();
            return;
        }
        System.out.println("Enter your password");
        Password = sc.nextLine();
        if(testUser.getPassword().equals(Password)){
            if(testUser instanceof Student){
                Student testUser2 = (Student)testUser;
                System.out.println("Welcome, Student "+ testUser2.getName());
                testUser2.handleActions(courseList);
            } else if (testUser instanceof Teacher) {
                Teacher testUser2 = (Teacher)testUser;
                System.out.println("Welcome, Teacher "+ testUser2.getName());
                testUser2.handleActions(courseList);
            }
            else if(testUser instanceof TA){
                TA testUser2 = (TA)testUser;
                System.out.println("Welcome, TA "+ testUser2.getName());
                testUser2.handleActions(courseList);
            }
        }
        else{
            System.out.println("Invalid Password, Please try Again");
            userLogin();
            return;
        }
    }



    public static void addCourse(Student st, Course co){
        co.addStudent(st);
    }
    public static void removeCourse(Student st, Course co){
        co.removeStudent(st);
    }
    public static ArrayList<Integer> viewCourse(Student st){
        ArrayList<Course> storeCourses = new ArrayList<>();
        ArrayList<Integer> storeIndex = new ArrayList<>();
       for(Course iterate1: courseList) {
           for(Student iterate2 : iterate1.getStudents()){
              if(st.getName().equals(iterate2.getName())) {
                  storeCourses.add(iterate1);
              }
           }
       }
       for(Course iterate: storeCourses){
           for(int i = 0; i <courseCatalogue.length; i++) {
               if (iterate.getName().equals(courseCatalogue[i])) {
                   System.out.println((i+1) + "." + iterate.getName());
                  storeIndex.add((i+1));
               }
           }
       }
       return storeIndex;
    }
    public static ArrayList<Integer> viewCourse(Teacher teach){
        ArrayList<Integer> storeCourses = new ArrayList<>();

        for(Course iterate1: courseList) {
            if(teach.getName().equals(iterate1.getTeacher().getName())){
                for(int i = 0; i < courseCatalogue.length; i++){
                    if(courseCatalogue[i].equals(iterate1.getName())){
                        System.out.println((i+1)+ ") " +iterate1.getName());
                        storeCourses.add((i+1));
                    }
                }
            }
        }
        return storeCourses;
    }
    public static ArrayList<Integer> viewCourse(TA ta){

        ArrayList<Integer> storeCourses = new ArrayList<>();
        for(Course iterate1: courseList) {
            if(ta.getName().equals(iterate1.getTa().getName())){
                for(int i = 0; i < courseCatalogue.length; i++){
                    if(courseCatalogue[i].equals(iterate1.getName())){
                        System.out.println((i+1)+ ") " +iterate1.getName());
                        storeCourses.add((i+1));
                    }
                }
            }
        }
        return storeCourses;
    }
    public static boolean checkWithinBounds(ArrayList<Integer> arr, int a ){
        for(int b: arr){
            if(b==a){
               return true;
            }
        }
        return false;
    }

}
