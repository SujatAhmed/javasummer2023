public class FirePokemon implements Pokemon{
    private  String name;
    private int level;

    FirePokemon(){

    }
    FirePokemon(String name, int level){
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
            System.out.println(this.name + " has used ember");
        }
        else if(choice ==2){

            System.out.println(this.name + " has used Fire Spin");
        } else if (choice ==3) {

            System.out.println(this.name + " has used Flame Charge");

        }
    }
    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Type: Fire");
        System.out.println("Level " + this.level );
    }
}
