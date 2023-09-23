public class supersoldier extends  combatant{
    supersoldier(){
        super();
    }
    supersoldier(String name, int health){
        super(name, health);
    }
    @Override
    public void performSpecialMove(combatant k){
        double totalDamage;
        totalDamage = Math.random()*8 + 10;
        System.out.println(this.getName() + " has caused " + (int)totalDamage + " damage points to "  + k.getName() + " by using Jawan punch" );
        depleteHeath( (int)totalDamage, k);
        //k.displayDetails();
        if(k.getHealth()<=0){
            System.out.println(k.getName() + " has depleted all their healthpoints," + this.getName() + " wins");
        }
    }
}
