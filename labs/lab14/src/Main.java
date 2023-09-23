public class Main {


    public static void main(String[] args) {
        int winner = 0;
        combatant k1 = new martialartist("Sujon majhi", 100);
        combatant k2 = new supersoldier("Vikram Rathore", 100);
        combatant k3 = new superagent("Tiger" , 100);


        winner = fighting_simulator(k1,k2) ;
        System.out.println(" \n \n \n ");

        System.out.println(" A new fight has begun ");

        System.out.println(" \n \n \n ");



        if (winner == 1){
            fighting_simulator(k1,k3);
        }
        else{
            fighting_simulator(k2,k3);
        }


    }



    public static int fighting_simulator(combatant a, combatant b){
        while (true) {
            int winner = 0;
            double rand = Math.random() * 2;
            int choice = (int) Math.ceil(rand);
            if(choice == 1){
                a.performSpecialMove(b);
                if(b.getHealth()<=0){
                    winner = 1;
                    a.recover();
                    return winner;
                }
            }
            else{
                b.performSpecialMove(a);
                if(a.getHealth()<=0){
                    winner = 2;
                    b.recover();
                    return winner;

                }
            }
        }
    }
}
