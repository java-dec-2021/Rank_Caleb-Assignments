import java.util.Random;

public class BankAccount {
    
    // Attributes
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    // Static Attributes
    private static int numAccounts = 0;
    private static double totalMoney = 0.0;

    // Constructors
    public BankAccount() {
        this.accountNumber = this.generateAccountNumber();
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        numAccounts++;
    }
    public BankAccount( double initCheck, double initSave ) {
        this.accountNumber = this.generateAccountNumber();
        this.checkingBalance = initCheck;
        this.savingsBalance = initSave;
        totalMoney += initCheck + initSave;
        numAccounts++;
    }

    // Public Methods
    public double getChecking() {
        return this.checkingBalance;
    }
    public double getSavings() {
        return this.savingsBalance;
    }
    public void viewAccountTotal() {
        System.out.println( "Account ".concat(this.accountNumber) + " Total: ".concat( Double.toString( this.checkingBalance + this.savingsBalance ) ) );
    }
    public void deposit( int account, int amount ){
        if ( account == 1 ) {
            this.checkingBalance += amount;
        }
        else if ( account == 2 ) {
            this.savingsBalance += amount;
        }
        else {
            System.out.println( "Error: Incorrect account chosen." );
            System.out.println( "-----> Options: (Checking) 1, (Savings) 2");
        }
    }
    public void withdraw( int account, int amount ){
        if ( account == 1 && this.checkingBalance > amount ) {
            this.checkingBalance -= amount;
        }
        else if ( account == 2 && this.savingsBalance > amount ) {
            this.savingsBalance -= amount;
        }
        else {
            System.out.println( "Error: Incorrect account or insufficient funds." );
            System.out.println( "-----> Options: (Checking) 1, (Savings) 2");
        }
    }

    // Private Methods
    private String generateAccountNumber() {
        Random rand = new Random();
        String accountNum = new String();

        for (int i = 0; i < 10; i++) {
            if ( i == 3 || i == 6 ) {
                accountNum += "-";
            }
            accountNum += Integer.toString( rand.nextInt( 10 ) );
        }
        return accountNum;
    }
}
