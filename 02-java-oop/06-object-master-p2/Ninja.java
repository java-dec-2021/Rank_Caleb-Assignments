public class Ninja extends Human {

    // Attributes
    // public int health = 100;
    // public int strength = 3;
    // public int stealth = 10;
    // public int intelligence = 3;

    public Ninja() {
        this.stealth = 10;
    }

    // Methods
    public void steal( Human target ) {
        target.health -= this.stealth;
        this.health += this.stealth;
    }
    public void runAway() {
        this.health -= 10;
    }
}
