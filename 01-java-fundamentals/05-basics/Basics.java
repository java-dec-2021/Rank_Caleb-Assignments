import java.util.ArrayList;

public class Basics {

    public static void main(String[] args) {
        int[] myArray = {4, 8, 8, 5, 9, -10, 2, 15, -20, -2, 0};

        System.out.println( myArray );
        System.out.println( "Main assignment ------------" );
        printOdd();
        System.out.println( sigma() );
        printArray( myArray );
        findMax( myArray );
        System.out.println( createOdd() );

        System.out.println( "Ninja Bonus ------------" );
        findAvg( myArray );
        System.out.println( greaterThanY( myArray, 6 ) );
        System.out.println( squareVal( myArray ) );
        System.out.println( elimNeg( myArray ) );
    }

    public static void printOdd() {
        for ( int i = 1; i <= 255; i = i+2 ) {
            System.out.println( i );
        }
    }

    public static int sigma() {
        int sum = 0;
        for ( int i = 1; i <= 255; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void printArray( int[] X ) {
        for ( int x : X ) {
            System.out.println( x );
        }
    }

    public static void findMax( int[] X ) {
        int max = X[0];
        for ( int x : X ) {
            if ( x > max ) {
                max = x;
            }
        }
        System.out.println( max );
    }

    public static ArrayList<Integer> createOdd() {
        ArrayList<Integer> y = new ArrayList<Integer>(); 
        for ( int i = 1; i <= 255; i = i+2 ) {
            y.add( i );
        }
        return y;
    }

    public static void findAvg( int[] X ) {
        int sum = 0;
        for ( int x : X ) {
            sum = sum + x;
        }
        int l = X.length;
        System.out.println( sum / l );
    }

    public static int greaterThanY( int[] X, int Y ) {
        int y = 0;
        for ( int x : X ) {
            if ( x > Y ) {
                y++;
            }
        }
        return y;
    }

    public static int[] squareVal( int[] X ) {
        for ( int x : X ) {
            x = x * x;
        }
        return X;
    }

    public static int[] elimNeg( int[] X ) {
        for ( int x : X ) {
            if ( x < 0 ) {
                x = 0;
            }
        }
        return X;
    }
}