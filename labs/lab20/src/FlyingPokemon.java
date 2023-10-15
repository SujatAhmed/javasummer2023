public class FlyingPokemon implements Pokemon{
    private String name;
    private int level;
    FlyingPokemon(){

    }
    FlyingPokemon(String name, int level){
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
            System.out.println(this.name + " has used Wing attack");
        }
        else if(choice ==2){

            System.out.println(this.name + " has used Gust");
        } else if (choice ==3) {

            System.out.println(this.name + " has used Drill peck");

        }

    }
    public void levelUp(){
        level++;
    }
    public void displayInfo(){
        System.out.println("Name: " +name);
        System.out.println("Type: Flying");
        System.out.println("Level "+ level);
    }
}

