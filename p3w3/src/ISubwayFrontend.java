// --== CS400 Fall 2022 File Header Information ==--
// Name: <Abdullah Aljohani>
// Email: <aaljohani@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>

import java.util.List;

public interface ISubwayFrontend {
    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     * @throws Exception 
     */
    public void runCommandLoop() throws Exception;

    // to help make it easier to test the functionality of this program, 
    // the following helper methods will help support runCommandLoop():

    /**
     * prints command options to System.outÏ
     */
    public void displayMainMenu(); 


    /**
     * reads price from System.in, displays results
     */ 
    public void searchForRouteFE(); 
    /**
     * add station from System.in, displays results
     * @throws Exception 
     */ 
    public void addStation() throws Exception; 
    /**
     * remove station from System.in, displays results
     */
    public void removeStation(); 

    /**
     * this method displays a list of stations
     */
    public void displayStation(List<Station> station);	
}

