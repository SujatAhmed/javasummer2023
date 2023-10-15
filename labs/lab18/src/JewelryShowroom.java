
import java.util.ArrayList;
public class JewelryShowroom extends Showroom{
    private String jewelryMaterial;
    private ArrayList<String> jewelryItems;

    JewelryShowroom() {
        jewelryItems = new ArrayList<>();
    }

    JewelryShowroom(String name, String location, double rent, String jewelryMaterial) {
        super(name, location, rent);
        this.jewelryMaterial = jewelryMaterial;
        jewelryItems = new ArrayList<>();
    }

    public void setMaterial(String jewelryMaterial) {
        this.jewelryMaterial = jewelryMaterial;
        jewelryItems.clear(); // Clear the items when changing the material
    }

    public String getMaterial() {
        return jewelryMaterial;
    }

    public void addItem(String item) throws UnapprovedItemException {

        String[] legalItems = {"Necklaces", "Rings", "Earrings", "Bracelets"};
        int checker = 0;
        for (String authorizedItem : legalItems) {
            if (item.equals(authorizedItem)) {
                checker = 1;
                break;
            }
        }
        if(checker==0){
            throw new UnapprovedItemException("Unauthorized Item: " + item);
        }

        else if (!jewelryItems.contains(item)) {
            jewelryItems.add(item);
        }
    }

    @Override
    public double calculateYearlyRent() {
        return super.calculateYearlyRent() + (250 * jewelryItems.size());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Material: " + this.jewelryMaterial);
        System.out.println("Jewelry Items:");
        for (String item : jewelryItems) {
            System.out.println("- " + item);
        }
    }
}
