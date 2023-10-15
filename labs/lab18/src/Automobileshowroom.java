import java.util.ArrayList;
import java.util.Objects;

public class Automobileshowroom extends Showroom{
    private String carBrand;
    private ArrayList<String> carModels;

    Automobileshowroom(){
        super();
    }
    Automobileshowroom(String name, String Location, double rent, String carBrand){
        super(name, Location, rent);
        this.carBrand = carBrand;
        this.carModels =  new ArrayList<>();
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
        carModels.clear();
    }

    public String getCarBrand() {
        return carBrand;
    }
    public void addModel(String model) {
        if (!(carModels.contains(model))) {
            carModels.add(model);
        }
    }
    @Override
    public double calculateYearlyRent(){
        return (12*getRent()) + 500*(double)carModels.size();
    }

    @Override
    public void displayInfo(){

        System.out.println("Name: " + this.getName());
        System.out.println("Location: "+ this.getLocation());
        System.out.println("Yearly rent: " + this.calculateYearlyRent());
        System.out.println(carBrand);
        System.out.println("Car Models:");
        for (String model: carModels
             ) {
            System.out.println(model);
        }
    }
}
