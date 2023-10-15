public class Main {
    public static void main(String[] args) {
        Pokemon Blaziken = new FirePokemon("Blaziken" , 96);
        Pokemon Gyrados   = new WaterPokemon("Gyrados" , 20);
        Pokemon Pickachu = new ElectricPokemon("Pickachu", 120);
        Pokemon Machomp = new FightingPokemon("Machomp", 50);
        Pokemon Bulbasaur = new GrassPokemon("Bulbasaur", 42);
        Pokemon Pidgey = new FlyingPokemon("Pidgey", 81);
        Blaziken.attack();
        Gyrados.attack();
        Pickachu.attack();
        Machomp.attack();
        Bulbasaur.attack();
        Pidgey.attack();
        Blaziken.displayInfo();
        Gyrados.displayInfo();
        Pickachu.displayInfo();
        Machomp.displayInfo();
        Bulbasaur.displayInfo();
        Pidgey.displayInfo();


    }
}
