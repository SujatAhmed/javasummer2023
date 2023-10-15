public class InvalidDepartmentException extends Exception{
    private String department;
    public InvalidDepartmentException(String department){
        super ("Invalid department: " + department);
        this.department = department;

    }

    public String getDepartment() {
        return department;
    }
}
