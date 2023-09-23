public class martialartist  extends combatant{
    martialartist(){
        super();
    }
    martialartist(String name, int health){
        super(name,health);
    }
    @Override
    public void performSpecialMove(combatant k){
        double totalDamage;
        totalDamage = (double) (Math.random() * 5) + 10;
        System.out.println(this.getName() + " has caused " + (int)totalDamage + " damage points to " + k.getName() + " through the majhi smacker");

        depleteHeath( (int)totalDamage, k);
        //k.displayDetails();
        if(k.getHealth()<=0){
            System.out.println(k.getName() + " has depleted all their healthpoints," + this.getName() + " wins");
        }
    }
}
