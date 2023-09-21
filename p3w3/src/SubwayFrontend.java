// --== CS400 Fall 2022 File Header Information ==--
// Name: <Abdullah Aljohani>
// Email: <aaljohani@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubwayFrontend implements ISubwayFrontend {
    Scanner userInputScanner;
    SubwayBackend backend;

    public SubwayFrontend(Scanner userInputScanner, SubwayBackend backend) {
        this.userInputScanner = userInputScanner;
        this.backend = backend;
    }

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     * @throws Exception 
     */
    public void runCommandLoop() throws Exception {
        System.out.println("Welcome to the Subway Stations Application!\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n");
        while (true) {
            displayMainMenu();
            int input = userInputScanner.nextInt();
            System.out.println();
            if (input == 1) {
                searchForRouteFE();
            } else if (input == 2) {
                searchForCustomRoute();
            } else if (input == 3) {
                addStation();
            } else if (input == 4) {
                removeStation();
            } else if (input == 5) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    // to help make it easier to test the functionality of this program,
    // the following helper methods will help support runCommandLoop():

    /**
     * prints command options to System.outÏ
     */
    public void displayMainMenu() {
        System.out.println("You are in the Main Menu:");
        System.out.println("          1) Search for shortest route");
        System.out.println("          2) Search for best routes with a maximum price");
        System.out.println("          3) Add Subway Station");
        System.out.println("          4) Remove Subway Station");
        System.out.println("          5) Exit Application");
    }

    /**
     * reads starting station and destionation station
     * and displays shortest path from starting to destination
     */
    public void searchForRouteFE() {
        System.out.println("You are in the Search for best route Menu:");
        System.out.println("—-----------------------------------");
        System.out.print("Enter starting station: ");
        String starting = userInputScanner.next();
        System.out.print("\nEnter destination station: ");
        String destination = userInputScanner.next();
        List<String> stations = backend.findShortestPath(backend.searchGraph(starting),
                backend.searchGraph(destination));
        System.out.println("\n" + "The shortest path: ");
        System.out.print("                   ");
        for (int i = 0; i < stations.size(); i++) {
            System.out.print(stations.get(i));
            if (i != stations.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * reads price from System.in, displays results
     */
    public void searchForCustomRoute() {
        System.out.println("You are in the Search for best route with a maximum price Menu:");
        System.out.println("—-----------------------------------");
        System.out.print("Enter starting station: ");
        String starting = userInputScanner.next();
        System.out.print("\nEnter maximum price: ");
        String price = userInputScanner.next();
        List<String> stations = backend.findBestPath(backend.searchGraph(starting), Integer.parseInt(price));
        System.out.println("\n" + "The available stations: ");
        System.out.print("                   ");
        for (int i = 0; i < stations.size(); i++) {
            System.out.print(stations.get(i));
            if (i != stations.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    /**
     * add station from System.in, displays results
     * @throws Exception 
     */
    public void addStation() throws Exception {
        System.out.println("You are in the Add Subway Station Station Menu:");
        System.out.println("—-----------------------------------");
        System.out.print("What is the name of your station? ");
        String station = userInputScanner.next();
        System.out.print("\nHow many routes does your station have? ");
        int numOfRoutes = userInputScanner.nextInt();
        List<String> stations = new ArrayList<String>();
        List<Integer> prices = new ArrayList<Integer>();
        for (int i = 0; i < numOfRoutes; i++) {
            System.out.println("Route #" + (i + 1) + ":");
            System.out.print("Insert destination: ");
            String destination = userInputScanner.next();
            System.out.print("Insert price: ");
            int price = Integer.parseInt(userInputScanner.next());
            stations.add(backend.searchGraph(destination));
            prices.add(price);
        }
        backend.addStation(station, stations, prices);
        System.out.println();
    }

    /**
     * remove station from System.in, displays results
     */
    public void removeStation() {
        System.out.println("You are in the Remove Subway Station Station Menu:");
        System.out.println("—-----------------------------------");
        System.out.print("Enter station to be removed: ");
        String station = userInputScanner.next();
        backend.removeStation(station);
        System.out.println();
    }

    /**
     * this method displays a list of stations
     */
    public void displayStation(List<Station> station) {

    }
    /**
     * main method to run the program locally
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        SubwayFrontend subway = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
        subway.runCommandLoop();
    }
}
