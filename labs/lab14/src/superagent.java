public class superagent extends combatant {
    superagent(){

    }
    superagent(String name, int health){
        super(name, health);
    }
    @Override
    public void performSpecialMove(combatant k){
        double totalDamage = Math.random()*8 + 9;
        System.out.println(this.getName()  + " has performerd " + (int)totalDamage + " damage points to " + k.getName() + " through the Tiger dive shot");

        depleteHeath((int)totalDamage,k);
        System.out.println("Remaining healthpoints of " + k.getName() + " is " + k.getHealth());
        if(k.getHealth()<=0){
            System.out.println(k.getName() + " has depleted all their healthpoints," + this.getName() + " wins");
        }


    }

}
