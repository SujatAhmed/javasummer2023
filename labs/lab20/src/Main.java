public class Main {
    public static void main(String[] args) {
        Pokemon Blaziken = new FirePokemon("Blaziken" , 96);
        Pokemon Gyrados   = new WaterPokemon("Gyrados" , 20);
        Pokemon Charizard = new FirePokemon("Charizard" , 96);
        Pokemon Emporium   = new WaterPokemon("Emporium" , 20);
        Blaziken.attack();
        Charizard.attack();
        Gyrados.attack();
        Emporium.attack();
        Blaziken.displayInfo();
        Charizard.displayInfo();
        Emporium.displayInfo();
        Gyrados.displayInfo();


    }
}
