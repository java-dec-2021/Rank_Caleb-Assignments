public class TestHumans {
    public static void main( String[] args ) {
        Human h = new Human();
        Wizard w = new Wizard();
        Ninja n = new Ninja();
        Samurai s = new Samurai();

        h.showStats();
        w.showStats();
        n.showStats();
        s.showStats();

        System.out.println("> ---------- <");

        h.attack( w );
        h.attack( s );
        w.fireball( s );
        w.fireball( s );
        w.fireball( s );
        w.heal( h );
        n.steal( h );
        n.runAway();
        s.deathBlow( w );
        s.meditate();
        System.out.println(s.howMany() + " Samurai.");

        System.out.println("> ---------- <");

        h.showStats();
        w.showStats();
        n.showStats();
        s.showStats();
    }
}
