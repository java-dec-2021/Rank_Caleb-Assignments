import java.util.Random;

public class Puzzling {
    public static void main(String[] args) {
        int[] rolls = getTenRolls();
        for ( int roll : rolls ) {
            System.out.println( roll );
        }
        String[] passwords = getNewPasswordSet( 10 );
        for ( String password : passwords ) {
            System.out.println( password );
        }
    }

    public static int[] getTenRolls() {
        Random rand = new Random();
        int[] X = new int[10];
        for ( int i = 0; i < 10; i++ ) {
            X[i] = rand.nextInt( 20 ) + 1;
        }
        return X;
    }

    public static String getRandomLetter() {
        Random rand = new Random();
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int index = rand.nextInt( 26 );
        return letters[index];
    }

    public static String generatePassword() {
        String password = "";
        String letter = new String();
        for ( int i = 0; i < 8; i++ ) {
            letter = getRandomLetter();
            password = password.concat( letter );
        }
        return password;
    }

    public static String[] getNewPasswordSet( int x ) {
        String[] passwords = new String[x];
        for ( int i = 0; i < x; i++ ){
            passwords[i] = generatePassword();
        }
        return passwords;
    }
}