public class TestHuman {
    public static void main( String[] args ) {
        Human h1 = new Human();
        Human h2 = new Human();
        Human h3 = new Human();

        h1.showStats();
        h2.showStats();
        h3.showStats();

        h1.attack( h2 );
        h1.attack( h3 );
        h2.attack( h1 );
        h2.attack( h3 );
        h3.attack( h1 );
        h3.attack( h2 );
        
        h1.showStats();
        h2.showStats();
        h3.showStats();
    }
}
