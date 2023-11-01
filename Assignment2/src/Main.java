import java.util.InputMismatchException;
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

        int choice;
        String ID;
        String Password;
        int checker = 0;
        System.out.println("Which one are you: 1.Student 2.Teacher 3.TA\n" );
        try {

            choice = sc.nextInt();

        }catch (InputMismatchException ex){
            sc.nextLine();
            System.out.println("Invalid input type\n");
            userLogin();
            return;
        }

        sc.nextLine();
        System.out.println("Enter your ID: \n");

        ID = sc.nextLine();


        for(User iterate: userList){
            if(iterate.getID().equals(ID)){
                checker =1 ;
                break;
            }
        }

        if(checker==0){
            System.out.println("Invalid ID, please try again\n");
            userLogin();
            return;
        }

        for (User iterate: userList){
            if(iterate.getID().equals(ID)){
                System.out.println("Enter your password: \n");

                    Password = sc.nextLine();

                if(iterate.getPassword().equals(Password)){
                    System.out.println("Welcome, " + iterate.getName()+"\n");
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
                    System.out.println("Invalid password, please try again\n");
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
