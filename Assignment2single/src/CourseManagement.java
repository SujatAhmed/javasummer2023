import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
 interface Action {
    void handleActions(ArrayList<Course> co);

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
        System.out.println("\n1.Add Course 2.View Courses 0.Logout");
        int choice;

        try{
            choice = CourseManagement.sc.nextInt();
        }catch(InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("Invalid input type");
            handleActions(co);
            return;
        }

        if(choice==1){
            this.handelActionsForAdding(co);


        } else if (choice==2) {
            this.handleActionsForViewing(co);

        }
        else if (choice==0){
            CourseManagement.sc.nextLine();
            CourseManagement.userLogin();
        }
        else{
            System.out.println("\nEnter the numbers within the given options");
            handleActions(co);
        }
    }
    public void handelActionsForAdding(ArrayList<Course> co) {
        int choice;
        int checker = 0;


        Course timingCheck  = new Course();
        System.out.println("\nEnter the Index of the Course you want to be enrolled in: (1-6) or press 0 to go back");
        System.out.println("\n1.CourseA.1 2.CourseA.2 3.CourseA.3 4.CourseB.1 5.CourseC.1 6.CourseC.2 0.Back");

        try {
            choice = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handelActionsForAdding(co);
            return;
        }

        if(choice<0 || choice>6){
            System.out.println("\nInvalid parameter please try again");
            handelActionsForAdding(co);
            return;
        }

        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(CourseManagement.courseCatalogue[choice - 1])) {
                    timingCheck = iterate;
                    break;
                }
            }
            //Logic to check if the student is enrolled in Different section of same course.
            String nameCheck = timingCheck.getName();
            int excludedIndex = nameCheck.length()-2;
            String actualCourseName = nameCheck.substring(0,excludedIndex);

            for (Course iterate : co) {
                for (Student st : iterate.getStudents()) {
                    if (st.getName().equals(this.getName())) {
                        if (iterate.getTiming().equals(timingCheck.getTiming())) {
                            if (iterate != timingCheck) {
                                checker = 1;
                                System.out.println("\nThe timing of this course clashes with " + iterate.getName());
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
                            System.out.println("\nYou are already enrolled in this course");
                            break;

                        }
                    }
                }
            }
            for (Course iterate : co) {
                if (iterate.getName().equals(CourseManagement.courseCatalogue[choice - 1])) {
                    if (iterate.getStudents().size() >= 5) {
                        checker = 1;
                        System.out.println("\nThis course if filled: ");
                        break;
                    }
                }
            }
        }




        if(choice!=0 && checker==0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(CourseManagement.courseCatalogue[choice - 1])) {
                    CourseManagement.addCourse(this, iterate);
                    System.out.println("\nCourse " + iterate.getName() + " Added successfully");
                }

            }
            this.handelActionsForAdding(co);
        }
        else{
            handleActions(co);
        }
    }
    public void handleActionsForViewing(ArrayList<Course> co){
        ArrayList<Integer> courseIndex;
        int choice;
        System.out.println("Your courses: ");
        courseIndex = CourseManagement.viewCourse(this);
        System.out.println("\n1.Remove Courses 0.Back");

        try {
            choice = CourseManagement.sc.nextInt();
        }catch(InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForViewing(co);
            return;
        }

        if(choice<0 || choice>1){
            System.out.println("\nInvalid parameters please try again");
            handleActions(co);
            return;

        }
        if(choice ==1){
            this.handleActionsForRemoving(co,courseIndex);
        }
        else{
            this.handleActions(co);
        }
    }

    public void handleActionsForRemoving(ArrayList<Course> co, ArrayList<Integer> courseIndex){

        int choice;
        System.out.println("\nEnter the index of the course you want to dropout from or press 0 to go back");
        System.out.println("According to this index given below:");
        CourseManagement.viewCourse(this);


        try {
            choice = CourseManagement.sc.nextInt();
        }catch(InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForRemoving(co,courseIndex);
            return;
        }

        if(choice<0 || choice>6){
            System.out.println("\nInvalid parameters please try again");
            handleActionsForRemoving(co, courseIndex);
            return;
        }
        if(!CourseManagement.checkWithinBounds(courseIndex,choice)){
            System.out.println("\nPlease only Enter the index shown to you");
            handleActionsForViewing(co);
            return;
        }

        if(choice!=0) {
            for (Course iterate : co) {
                if (iterate.getName().equals(CourseManagement.courseCatalogue[choice - 1])) {
                    CourseManagement.removeCourse(this, iterate);
                    System.out.println(iterate.getName()+ " has been successfully removed from your catalogue\n");
                    break;
                }
            }
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
        int choice;
        System.out.println("\n1.View Courses 2.Logout");
        try {
            choice = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActions(co);
            return;
        }
        if(choice==1){
            handleActionsForViewing(co);
        }
        else if(choice ==2){
            CourseManagement.sc.nextLine();
            CourseManagement.userLogin();
        }
        else {
            System.out.println("\nInvalid parameters, try again");
            handleActions(co);
            return;
        }

    }




    public void handleActionsForRemoving(ArrayList<Course> co,int courseNumber,ArrayList<Integer> sto){
        Course test = new Course();
        int choice;

        System.out.println("\nEnter the index of the student to be removed or press 0 to go back: ");
        for(Integer st: sto){
            for(int i = 0; i< CourseManagement.studentCatalogue.length; i++){
                if(st==(i+1)){
                    System.out.println(st + "."+ CourseManagement.studentCatalogue[i]);
                }
            }
        }
        try {
            choice = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForRemoving(co,courseNumber,sto);
            return;
        }
        if(choice==0){
            handleActionsForViewing(co);
            return;
        }
        if(choice<1||choice>3){
            System.out.println("\nInvalid input please try again");
            handleActionsForRemoving(co,courseNumber,sto);
        }
        if(!CourseManagement.checkWithinBounds(sto,choice)){
            System.out.println("\nPlease enter the indexes according to what is shown to you");
            handleActionsForRemoving(co,courseNumber,sto);
        }

        String studentName = CourseManagement.studentCatalogue[choice-1];
        for(Course iterate : co){
            for(int i = 0; i< CourseManagement.courseCatalogue.length; i++){
                if(CourseManagement.courseCatalogue[courseNumber-1].equals(iterate.getName())){
                    test = iterate;
                    break;
                }
            }
        }
        for(Student st : test.getStudents()){
            if(studentName.equals(st.getName())){
                CourseManagement.removeCourse(st,test);
                System.out.println(st.getName()+ " has been removed from " + test.getName());
                break;
            }
        }


        System.out.println("\n1.Remove Students 0.Back");
        try {
            choice = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForRemoving(co,courseNumber,sto);
            return;
        }
        if(choice ==1){
            handleActionsForRemoving(co,courseNumber,sto);
        }
        else{
            handleActions(co);
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        ArrayList<Integer> storeStudents = new ArrayList<>();
        ArrayList<Integer> storeCourses = new ArrayList<>();

        int choicePrime;
        int choice;
        Course test = new Course();
        System.out.println("\nEnter the index of the course you want to view according to what is printed below or press 0 to go back: ");
        storeCourses = CourseManagement.viewCourse(this);
        try{

            choicePrime = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("Invalid input type");
            handleActionsForViewing(co);
            return;
        }
        if(choicePrime==0){
            handleActions(co);
            return;
        }
        if(choicePrime>6||choicePrime<1){
            System.out.println("\nInvalid input please try again");
            handleActionsForViewing(co);
            return;
        }
        if(!CourseManagement.checkWithinBounds(storeCourses,choicePrime)){
            System.out.println("\nPlease enter the numbers according to what's given");
            handleActionsForViewing(co);
            return;

        }

        for(Course iterate: co){
            if(CourseManagement.courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        System.out.println("\nStudents of " + test.getName()+ ": \n");
        for(Student st : test.getStudents()){
            for(int i = 0; i < CourseManagement.studentCatalogue.length; i++){
                if(CourseManagement.studentCatalogue[i].equals(st.getName())){
                    System.out.println((i+1) + ") "+ st.getName() );
                    storeStudents.add((i+1));
                }
            }
        }


        System.out.println("\n1.Remove Students 0.Back");
        try{
            choice = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForViewing(co);
            return;
        }
        if(choice==1){
            this.handleActionsForRemoving(co,choicePrime,storeStudents);
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
        int choice;
        System.out.println("\n1.View Courses 2.Logout");
        try{
            choice = CourseManagement.sc.nextInt();
        }catch(InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActions(co);
            return;
        }

        if(choice==1){
            handleActionsForViewing(co);
        }
        else if(choice ==2){
            CourseManagement.sc.nextLine();
            CourseManagement.userLogin();
        }
        else{
            handleActions(co);
            return;
        }
    }

    public void handleActionsForViewing(ArrayList<Course> co){
        int choicePrime;
        ArrayList<Integer> storeCourses;
        Course test = new Course();
        System.out.println("\nEnter the index of the course you want to view or press 0 to go back: ");
        storeCourses = CourseManagement.viewCourse(this);
        try{

            choicePrime = CourseManagement.sc.nextInt();
        }catch (InputMismatchException ex){
            CourseManagement.sc.nextLine();
            System.out.println("\nInvalid input type");
            handleActionsForViewing(co);
            return;
        }
        if(choicePrime==0){
            handleActions(co);
            return;
        }
        if(!CourseManagement.checkWithinBounds(storeCourses,choicePrime)){
            System.out.println("\nPlease enter the indexes that are shown to you below");
            handleActionsForViewing(co);
            return;
        }

        for(Course iterate: co){
            if(CourseManagement.courseCatalogue[choicePrime-1].equals(iterate.getName())){
                test = iterate;
                break;
            }
        }
        System.out.println("\nStudents of " + test.getName()+ ": \n");
        for(Student st : test.getStudents()){
            for(int i = 0; i < CourseManagement.studentCatalogue.length; i++){
                if(CourseManagement.studentCatalogue[i].equals(st.getName())){
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
            System.out.println("\nEnter your ID.(If you're a Student,Teacher or TA, enter your appropriate IDs)");
            ID = sc.nextLine();
            for(User iterate : userList){
                if(iterate.getID().equals(ID)){
                    testUser = iterate;
                }
            }
            if(testUser==null){
                System.out.println("\nThe ID does not match with any user in the database, please try again");
                userLogin();
                return;
            }
            System.out.println("\nEnter your password");
            Password = sc.nextLine();
            if(testUser.getPassword().equals(Password)){
                if(testUser instanceof Student){
                    Student testUser2 = (Student)testUser;
                    System.out.println("\nWelcome, Student "+ testUser2.getName());
                    testUser2.handleActions(courseList);
                } else if (testUser instanceof Teacher) {
                    Teacher testUser2 = (Teacher)testUser;
                    System.out.println("\nWelcome, Teacher "+ testUser2.getName());
                    testUser2.handleActions(courseList);
                }
                else if(testUser instanceof TA){
                    TA testUser2 = (TA)testUser;
                    System.out.println("\nWelcome, TA "+ testUser2.getName());
                    testUser2.handleActions(courseList);
                }
            }
            else{
                System.out.println("\nkjd" +
                    "" +
                    "Invalid Password, Please try Again");
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
