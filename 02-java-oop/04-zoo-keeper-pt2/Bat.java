public class Bat extends Mammal {
    
    // Attributes
    private int energyLevel = 300;

    // Methods
    public void fly() {
        System.out.println( "Flap flap flap...." );
        this.energyLevel -= 50;
    }
    public void eatHumans() {
        this.energyLevel += 25;
    }
    public void attackTown() {
        System.out.println( "Flames flames flames...." );
        this.energyLevel -= 100;
    }
}
