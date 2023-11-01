import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<VIPPrisoner> vipPrisoners = new ArrayList<>();

        vipPrisoners.add(new VIPPrisoner("a","F10A",315,1));
        vipPrisoners.add(new VIPPrisoner("b","A00B",315,2));
        vipPrisoners.add(new VIPPrisoner("c","B51A",315,2));
        vipPrisoners.add(new VIPPrisoner("d","C21B",315,2));

        for(VIPPrisoner prisoner : vipPrisoners){
            int days =(int)(Math.random()*100);
            prisoner.determineCrime();
            prisoner.skipDays(days);
            prisoner.displayInfo();
        }

        for(VIPPrisoner prisoner : vipPrisoners){
            if(prisoner.eligibleForRelease()){
                System.out.println("Name: " + prisoner.getName()+ " -- Code: " + prisoner.getPrisonerCode()+ " -- Release Status: Eligible");
            }
            else{
                System.out.println("Name: " + prisoner.getName()+ " -- Code: " + prisoner.getPrisonerCode()+ " -- Release Status: Not eligible");
            }
        }

    }
}
