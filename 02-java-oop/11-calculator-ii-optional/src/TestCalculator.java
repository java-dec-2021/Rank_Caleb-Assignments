public class TestCalculator {
	public static void main( String[] args ) {
		Calculator c = new Calculator();
		
		c.setOperand1( 10.5 );
		c.setOperation( "+" );
		c.setOperand2( 5.2 );
		c.performOperation();
		System.out.println( c.getResults() );
	}
}
