public class Samurai extends Human {

    // Attributes
    // public int health = 200;
    // public int strength = 3;
    // public int stealth = 3;
    // public int intelligence = 3;

    // Class/Static Attributes
    public static int numOfSamurai = 0;

    // Constructors
    public Samurai() {
        this.health = 200;
        numOfSamurai++;
    }

    // Methods
    public void deathBlow( Human target ) {
        target.health = 0;
        this.health /= 2;
    }
    public void meditate() {
        this.health += this.health / 2;
    }
    public static int howMany() {
        return numOfSamurai;
    }
}
