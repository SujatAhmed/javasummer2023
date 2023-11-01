import java.util.ArrayList;

public class Course {
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
