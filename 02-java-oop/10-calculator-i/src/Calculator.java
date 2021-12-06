public class Calculator implements java.io.Serializable {
	
	// Attributes
	private String operation;
	private double currentVal;
	private double results;
	
	// Constructor
	public Calculator() {
		this.currentVal = 0.0;
	}
	
	// Methods
	public void performOperation( double val ) {
		if ( this.operation == "+" ) {
			this.currentVal += val;
			System.out.println( this.currentVal );
		}
		else if ( this.operation == "-" ) {
			this.currentVal -= val;
			System.out.println( this.currentVal );
		}
		else if ( this.operation == "*" ) {
			this.currentVal *= val;
			System.out.println( this.currentVal );
		}
		else if ( this.operation == "/" ) {
			this.currentVal /= val;
			System.out.println( this.currentVal );
		}
		else if ( this.operation == "=" ) {
			this.results = this.currentVal;
			System.out.println( this.currentVal );
		}
		else {
			this.currentVal = val;
			System.out.println( this.currentVal );
		}
	}
	public void performOperation( String op ) {
		this.operation = op;
	}
	
	// Getters
	public double getResults() {
		return this.results;
	}
}
