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
        totalDamage = (Math.random() * 5) + 10;
        System.out.println(this.getName() + " has caused " + (int)totalDamage + " damage points to " + k.getName() + " through the majhi smacker");

        k.healthDeplete( (int)totalDamage);

        System.out.println("Remaining healthpoints of " + k.getName() + " is " + k.getHealth());

        if(k.getHealth()<=0){
            System.out.println(k.getName() + " has depleted all their healthpoints," + this.getName() + " wins");
        }
    }
}
