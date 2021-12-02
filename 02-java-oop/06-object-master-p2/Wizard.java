public class Wizard extends Human {

    // Attributes
    // public int health = 50;
    // public int strength = 3;
    // public int stealth = 3;
    // public int intelligence = 8;

    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }

    // Methods
    public void heal( Human target ) {
        target.health += this.intelligence;
    }
    public void fireball( Human target ) {
        target.health -= this.intelligence * 3;
    }
}
