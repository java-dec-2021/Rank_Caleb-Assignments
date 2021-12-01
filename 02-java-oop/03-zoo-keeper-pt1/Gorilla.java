public class Gorilla extends Mammal {
    
    // Methods
    public void throwSomething() {
        System.out.println( "Gorilla has used 5 energy to throw something." );
        super.setEnergy( super.getEnergy() - 5 );
    }
    public void eatBananas() {
        System.out.println( "Gorilla has eaten a banana and gained 10 energy." );
        super.setEnergy( super.getEnergy() + 10 );
    }
    public void climb() {
        System.out.println( "Gorilla has climbed a tree and lost 10 energy." );
        super.setEnergy( super.getEnergy() - 10 );
    }
}
