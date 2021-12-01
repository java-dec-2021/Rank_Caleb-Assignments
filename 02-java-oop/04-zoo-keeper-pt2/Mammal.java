public class Mammal {

    // Attributes
    public int energyLevel = 100;

    // Methods
    public int displayEnergy() {
        System.out.println( this.energyLevel );
        return this.energyLevel;
    }
    public int getEnergy() {
        return this.energyLevel;
    }
    public void setEnergy( int energy ) {
        this.energyLevel = energy;
    }
}