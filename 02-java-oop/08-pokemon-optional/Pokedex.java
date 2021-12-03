import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {

    // Attributes
    ArrayList<Pokemon> myPokemon;

    public void listPokemon() {
        for ( Pokemon pokemon : myPokemon ) {
            System.out.println( pokemon.getName() );
        }
    }
}