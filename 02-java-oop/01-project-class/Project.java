public class Project {
    
    private String name;
    private String description;
    private double initialCost;

    // Constructors
    public Project() {
        this( "<Insert Name>", "<Insert Description>", 0.00 );
    }
    public Project( String name ) {
        this( name, "<Insert Description>", 0.00 );
    }
    public Project( String name, String desc, double initCost ) {
        this.name = name;
        this.description = desc;
        this.initialCost = initCost;
    }

    // Methods
    public String elevatorPitch() {
        return this.name + " (" + Double.toString(this.initialCost) + "): " + this.description;
    }
    public String getName() {
        return this.name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription( String desc ) {
        this.description = desc;
    }
    public double getInitialCost() {
        return this.initialCost;
    }
    public void setInitialCost( double initCost ) {
        this.initialCost = initCost;
    }
}