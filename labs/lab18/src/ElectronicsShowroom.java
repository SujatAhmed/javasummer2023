import java.util.ArrayList;

public class ElectronicsShowroom extends Showroom {


    private String electronicsBrand;
    private ArrayList<String> electronicsItems;

    ElectronicsShowroom() {
        electronicsItems = new ArrayList<>();
    }

    ElectronicsShowroom(String name, String location, double rent, String electronicsBrand) {
        super(name, location, rent);
        this.electronicsBrand = electronicsBrand;
        electronicsItems = new ArrayList<>();
    }

    public void setElecBrand(String electronicsBrand) {
        this.electronicsBrand = electronicsBrand;
        electronicsItems.clear(); // Clear the items when changing the brand
    }

    public String getElecBrand() {
        return electronicsBrand;
    }

    public void addItem(String item) throws UnapprovedItemException {
        String[] legalItems = {
            "Television", "Refrigerator", "Microwave Oven", "Rice Cooker", "Toaster"
        };
        int checker = 0;
        for(String authorizedItem : legalItems){
            if(item.equals(authorizedItem)){
                checker = 1;
                break;
            }
        }
        if (checker == 0) {
            throw new UnapprovedItemException("Unauthorized item " + item);
        }
        if (!electronicsItems.contains(item)) {
            electronicsItems.add(item);
        }
    }



    @Override
    public double calculateYearlyRent() {
        return super.calculateYearlyRent() + (750 * electronicsItems.size());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + this.electronicsBrand);
        System.out.println("Electronics Items:");
        for (String item : electronicsItems) {
            System.out.println("- " + item);
        }
    }
}
