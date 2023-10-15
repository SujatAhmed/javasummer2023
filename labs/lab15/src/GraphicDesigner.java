public class GraphicDesigner extends Employee{
    private String specialty;
    GraphicDesigner(){
       super();
    }
    GraphicDesigner(String name, double salary, String specialty){
        super(name,salary);
        this.specialty = specialty;
    }
    public void changeSpecialty(String specialty){
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }
    @Override
    public double calculateBonus(double bonus){
        if(specialty.equals("Logo Design")){
            return (bonus*this.getSalary()/100)+500;
        } else if (specialty.equals("Flyer Design")) {

            return (bonus*this.getSalary()/100)+1000;

        } else if (specialty.equals("Brochure Design")) {
            return (bonus*this.getSalary()/100)+750;

        }
        else{
            return (bonus*this.getSalary()/100)+250;
        }

    }
    @Override
    public void displayInfo(){
        System.out.println("The name of the graphic Designer is " + this.getName());
        System.out.println("The salary of the graphic Designer is" + this.getSalary());
        System.out.println("the specialty is" + this.specialty);
        System.out.println("The bonus of the graphic designer is" + this.calculateBonus(50));
    }
}
