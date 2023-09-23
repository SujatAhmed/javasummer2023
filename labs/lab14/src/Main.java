// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        int winner = 0;
        combatant k1 = new martialartist("Sujon majhi", 100);
        combatant k2 = new supersoldier("Vikram Rathore", 100);
        combatant k3 = new superagent("Tiger" , 100);

        while (true) {
            double rand = Math.random() * 2;
            int choice = (int) Math.ceil(rand);
            if(choice == 1){
                k1.performSpecialMove(k2);
                if(k2.getHealth()<=0){
                    winner = 1;
                    k1.recover();
                    break;
                }
            }
            else{
                k2.performSpecialMove(k1);
                if(k1.getHealth()<=0){
                    winner = 2;
                    k2.recover();
                    break;
                }
            }


        }
        System.out.println("The beginning of a new fight ");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        if(winner ==1){
            while (true) {
                double rand = Math.random() * 2;
                int choice = (int) Math.ceil(rand);
                if(choice == 1){
                    k1.performSpecialMove(k3);
                    if(k3.getHealth()<=0){
                        k1.recover();
                        break;
                    }
                }
                else{
                    k3.performSpecialMove(k1);
                    if(k1.getHealth()<=0){
                        k3.recover();
                        break;
                    }
                }
            }
        }
        else if(winner ==2 ) {
            while (true) {
                double rand = Math.random() * 2;
                int choice = (int) Math.ceil(rand);
                if(choice == 1){
                    k2.performSpecialMove(k3);
                    if(k3.getHealth()<=0){
                        k2.recover();
                        break;
                    }
                }
                else{
                    k3.performSpecialMove(k2);
                    if(k2.getHealth()<=0){
                        k3.recover();
                        break;
                    }
                }
            }
        }

    }
}
