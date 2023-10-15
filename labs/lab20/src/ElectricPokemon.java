public class ElectricPokemon implements Pokemon{
    private String name;
    private int level;
    ElectricPokemon(){

    }
    ElectricPokemon(String name, int level){
        this.name = name;
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    public void attack(){
        int choice = (int) Math.ceil(3*Math.random());
        if(choice == 1){
            System.out.println(this.name + " has used Thunder Shock");
        }
        else if(choice ==2){

            System.out.println(this.name + " has used Shock Wave");
        } else if (choice ==3) {

            System.out.println(this.name + " has used Charge Beam");

        }

    }
    public void levelUp(){
        level++;
    }
    public void displayInfo(){
        System.out.println("Name: " +name);
        System.out.println("Type: Electric");
        System.out.println("Level "+ level);
    }
}
