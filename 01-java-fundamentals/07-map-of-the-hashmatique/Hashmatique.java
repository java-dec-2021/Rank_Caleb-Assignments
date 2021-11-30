import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main( String[] args ) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put( "Song 1", "Lyrics to song 1..." );
        trackList.put( "Song 2", "Lyrics to song 2..." );
        trackList.put( "Song 3", "Lyrics to song 3..." );
        trackList.put( "Song 4", "Lyrics to song 4..." );

        System.out.println( trackList.get("Song 3") );

        Set<String> keys = trackList.keySet();
        for ( String key : keys ) {
            System.out.println( key + " :" );
            System.out.println( trackList.get( key ) );
        }
    }
}