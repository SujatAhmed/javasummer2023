public class combatant {
    private String name;
    private int health;

    combatant(){

    }
    combatant(String name, int health ){
        this.name = name;
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setHealth(int health) {
//        this.health = health;
//    }
//
    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
    public void recover(){
        this.health = 100;
    }
    public void displayDetails(){

        System.out.println("The name of the combatant is: " +  this.name );
        System.out.println("The health of the combatant is "  + this.health );

    }
    public void performSpecialMove(combatant k) {
        System.out.println("Perform this from the child class");
    }
    public void healthDeplete(int damage  ){
        this.health -= damage;

    }
}
