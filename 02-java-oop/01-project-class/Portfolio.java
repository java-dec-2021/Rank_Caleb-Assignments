import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projects;

    // Constructors
    public Portfolio( ArrayList<Project> projects ) {
        this.projects = projects;
    }

    // Methods
    public double getPortfolioCost() {
        double cost = 0;
        for ( Project project : this.projects ) {
            cost += project.getInitialCost();
        }
        return cost;
    }
    public void showPortfolio() {
        for ( Project project : this.projects ) {
            System.out.println( project.elevatorPitch() );
        }
        System.out.println( this.getPortfolioCost() );
    }
}