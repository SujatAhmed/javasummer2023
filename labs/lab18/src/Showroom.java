public class Showroom {
    private String name;
    private String Location ;
    private double rent;
    Showroom(){

    }
    Showroom(String name, String Location, double rent){
        this.name = name;
        this.Location = Location;
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
    public double calculateYearlyRent(){
        return (12*rent);
    }
    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.Location);
        System.out.println("Yearly Rent: " + this.calculateYearlyRent());
    }
}
