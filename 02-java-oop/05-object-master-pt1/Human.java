public class Human {

    // Attributes
    int health = 100;
    int strength = 3;
    int stealth = 3;
    int intelligence = 3;

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