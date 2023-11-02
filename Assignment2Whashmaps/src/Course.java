import java.util.ArrayList;

public class Course {
    private String Name;
    private int Section;

    private Teacher teacher;

    private int SL;
    private ArrayList<Integer> SLofStudents;
    private ArrayList<Student> studentList ;
    Course(){

    }

    Course(String Name, int Section, int SL){
        this.Name = Name;
        this.SL = SL;
        this.Section = Section;
        studentList = new ArrayList<>();
        SLofStudents = new ArrayList<>();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(Student student){
        studentList.remove(student);
    }

    public int getSL() {
        return SL;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Integer> getSLofStudents() {
        for(Student iterate: this.studentList){
            SLofStudents.add(iterate.getSL());
        }
        return SLofStudents;
    }
}
