public class Pokemon {

    // Attributes
    private String name;
    private int health;
    private String[] type;

    // Static Variables
    static int count = 0;

    public Pokemon() {
        this.name = "Unamed";
        this.health = 100;
        this.type = new String[1];
        this.type[0] = "Normal";
    }
    public Pokemon( String name, String[] type ) {
        this( name, 100, type );
    }
    public Pokemon( String name, int health, String[] type ) {
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth( int health ) {
        this.health = health;
    }
    public String[] getType() {
        return this.type;
    }
    public void setType( String[] type ) {
        this.type = type;
    }

    // Methods
    void attackPokemon( Pokemon pokemon ) {
        pokemon.health -= 10;
    }
}