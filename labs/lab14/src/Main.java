public class Main {
    public static void main(String[] args) {

        combatant sujonMajhi = new martialartist("Sujon majhi", 100);
        combatant vikramRathore = new supersoldier("Vikram Rathore", 50);
        combatant tiger = new superagent("Tiger" , 100);
        combatant donaldTrump = new superagent("Trump", 800);

        fight(fight(sujonMajhi,vikramRathore),tiger);

    }
    public static combatant fight(combatant a, combatant b){

        while (true) {

            double rand = Math.random() * 2;
            int choice = (int) Math.ceil(rand);

            if(choice == 1){
                a.performSpecialMove(b);
                if(b.getHealth()<=0){
                    a.recover();
                    System.out.println("\n\n\n\n");
                    return a;
                }
            }

            else{
                b.performSpecialMove(a);
                if(a.getHealth()<=0){
                    b.recover();
                    System.out.println("\n\n\n\n");
                    return b;
                }
            }

        }
    }

}
