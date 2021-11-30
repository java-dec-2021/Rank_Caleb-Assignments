import java.util.ArrayList;

public class TestProject {
    public static void main(String[] args) {
        Project project1 = new Project();
        Project project2 = new Project( "Caleb Rank" );
        Project project3 = new Project( "John Doe", "John's Project Desc", 1500.25 );
        Project project4 = new Project( "Jane Doe", "Jane's Project Desc", 10.25 );
        Project project5 = new Project( "Jack Doe", "John's Project Desc", 100.00 );

        System.out.println( project1.elevatorPitch() );
        
        ArrayList<Project> p = new ArrayList<Project>();
        p.add( project1 );
        p.add( project2 );
        p.add( project3 );
        p.add( project4 );
        p.add( project5 );

        Portfolio portfolio = new Portfolio( p );
        portfolio.showPortfolio();
    }
}
