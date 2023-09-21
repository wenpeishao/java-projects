// --== CS400 Fall 2022 File Header Information ==--
// Name: <Abdullah Aljohani>
// Email: <aaljohani@wisc.edu>
// Team: <DE>
// TA: <April Roszkowski>
// Lecturer: <Florian Heimerl >
// Notes to Grader: <optional extra notes>
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Scanner;

import  org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class FrontendDeveloperTests {

    @Test
    /**
     * testing the exit command
     */
    public static void testingExit() {
        try {
            TextUITester tester = new TextUITester("5");
            SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
            frontend.runCommandLoop();
            String output = tester.checkOutput();
            String expected = "Welcome to the Subway Stations Application!" +
                    "\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"

                    + "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "Goodbye!\n";
            assertEquals(expected, output);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    /**
     * testing search for shortest path
     */
    public void testingSearchShortest() {
        try {
            TextUITester tester = new TextUITester("1\nStart\nDestination\n5");
            SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
            frontend.runCommandLoop();
            String output = tester.checkOutput();
            String expected = "Welcome to the Subway Stations Application!" +
                    "\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"

                    + "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "You are in the Search for best route Menu:"
                    + "\n—-----------------------------------"
                    + "\nEnter starting station: " + "\nEnter destination station: "
                    + "\nThe shortest path: "
                    + "\n                   a -> b -> c\n" +
                    "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "Goodbye!\n";
            ;
            assertEquals(expected, output);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    /**
     * testing search best route
     */
    public void testingSearchBest() {
        try {
            TextUITester tester = new TextUITester("2\nStart\n123\n5");
            SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
            frontend.runCommandLoop();
            String output = tester.checkOutput();
            String expected = "Welcome to the Subway Stations Application!" +
                    "\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"

                    + "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "You are in the Search for best route with a maximum price Menu:"
                    + "\n—-----------------------------------"
                    + "\nEnter starting station: " + "\nEnter maximum price: "
                    + "\nThe available stations: "
                    + "\n                   a -> b -> c\n" +
                    "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "Goodbye!\n";
            ;
            assertEquals(expected, output);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    /**
     * testing adding a station
     */
    public void testingAddStation() {
        try {
            TextUITester tester = new TextUITester("3\nStart\n0\n5");
            SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
            frontend.runCommandLoop();
            String output = tester.checkOutput();
            String expected = "Welcome to the Subway Stations Application!" +
                    "\nx+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n\n"

                    + "You are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "You are in the Add Subway Station Station Menu:"
                    + "\n—-----------------------------------"
                    + "\nWhat is the name of your station? " + "\nHow many routes does your station have? "

                    +"\nYou are in the Main Menu:\n"
                    + "          1) Search for shortest route\n"
                    + "          2) Search for best routes with a maximum price\n" +
                    "          3) Add Subway Station\n" +
                    "          4) Remove Subway Station\n" +
                    "          5) Exit Application\n\n" +
                    "Goodbye!\n";
            ;
            assertEquals(expected, output);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    /**
     * testing search best route with an invalid input
     */
    public void testingSearchBestInavlidInput() {
        try {
            TextUITester tester = new TextUITester("2\nStart\nprice\n5");
            SubwayFrontend frontend = new SubwayFrontend(new Scanner(System.in), new SubwayBackend());
            frontend.runCommandLoop();
            fail();
        } catch (Exception e) {
        }
    }
}
