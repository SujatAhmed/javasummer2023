public class WaterPokemon implements Pokemon{
    private  String name;
    private int level;

    WaterPokemon(){

    }
    WaterPokemon(String name, int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public void levelUp(){
        level++;
    }
    @Override
    public void attack(){
        int choice = (int) Math.ceil(3*Math.random());
        if(choice == 1){
            System.out.println(this.name + " has used Water Gun");
        }
        else if(choice ==2){

            System.out.println(this.name + " has used Bubble");
        } else if (choice ==3) {

            System.out.println(this.name + " has used Aqua Jet");

        }
    }

    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Type: Water");
        System.out.println("Level " + this.level );
    }
}


