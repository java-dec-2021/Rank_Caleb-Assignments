public class Calculator implements java.io.Serializable {
	
	// Attributes
	private double operand1;
	private double operand2;
	private String operation;
	private double results;
	
	// Methods
	public void performOperation() {
		if ( this.operation == "+" ) {
			this.results = this.operand1 + this.operand2;
		}
		else if ( this.operation == "-" ) {
			this.results = this.operand1 - this.operand2;
		}
		else {
			this.results = 0.0;
		}
	}
	public double getResults() {
		return this.results;
	}
	
	// Setters
	public void setOperand1( double val ) {
		this.operand1 = val;
	}
	public void setOperand2( double val ) {
		this.operand2 = val;
	}
	public void setOperation( String op ) {
		this.operation = op;
	}
}
