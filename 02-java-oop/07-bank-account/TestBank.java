public class TestBank {
    public static void main( String[] args ) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount( 1500.75, 10524.98 );

        b1.viewAccountTotal();
        System.out.println( "B2 Checking: " + b2.getChecking() );
        System.out.println( "B2 Savings: " + b2.getSavings() );
        b2.viewAccountTotal();
    }
}
