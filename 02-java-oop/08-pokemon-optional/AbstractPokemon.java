public abstract class AbstractPokemon implements PokemonInterface {
    
    public Pokemon createPokemon( String name, int health, String[] type ) {
        return new Pokemon( name, health, type );
    }
    public String pokemonInfo( Pokemon pokemon ) {
        String result = pokemon.getName();
        result += " " + Integer.toString(pokemon.getHealth());
        String[] types = pokemon.getType();
        for ( String type : types ) {
            result += type;
        }
        return result;
    }
}
