public class Human {

    // Attributes
    public int health = 100;
    public int strength = 3;
    public int stealth = 3;
    public int intelligence = 3;

    // Methods
    public void attack( Human opponent ) {
        opponent.health -= this.strength;
    }
    public void showStats() {
        System.out.println( "Health: " + this.health );
        System.out.println( "Strength: " + this.strength );
        System.out.println( "Stealth: " + this.stealth );
        System.out.println( "Intelligence: " + this.intelligence );
    }
}