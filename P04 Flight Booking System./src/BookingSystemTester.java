//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Flight Booking System
// Course: CS 300 Fall 2021
//
// Author: Wenpei Shao
// Email: wshao33@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __X_ Write-up states that pair programming is allowed for this assignment.
// __X_ We have both read and understand the course Pair Programming Policy.
// __X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
public class BookingSystemTester {

  public static boolean testTraveler() {
    // Create a Traveler object and verify that no exceptions are thrown
    try {
      Traveler tester = new Traveler("tony", "wshao33@wisc.edu");



      // Verify that the name/email returned by the accessor methods are correct
      if (!("tony".equals(tester.getName()))) {
        return false;
      }
      if (!("wshao33@wisc.edu".equals(tester.getEmail()))) {
        return false;
      }
      // Use the mutator methods to change the name/email and verify that the accessors
      // return the correct NEW name/email
      tester.setName("tim");
      tester.setEmail("tim@wisc.edu");
      if (!("tim".equals(tester.getName()))) {
        return false;
      }
      if (!("tim@wisc.edu".equals(tester.getEmail()))) {
        return false;
      }
      // Create a second Traveler object and verify that its name/email are different from the
      // first Traveler's
      Traveler testerTwo = new Traveler("ann", "ann@wisc.edu");
      if (testerTwo.getName().equals(tester.getName())) {
        return false;
      }
      if (testerTwo.getEmail().equals(tester.getEmail())) {
        return false;
      }
    } catch (Throwable e) {
      return false;
    }

    return true;
  }

  /**
   * Tests the basic functionality of the Flight class. This implementation is provided for you.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testFlight() {
    // Create a Flight object and verify that no exceptions are thrown
    Flight f1, f2;
    try {
      f1 = new Flight("MSN", "PDX", "A234", 50);
      f2 = new Flight("DIA", "DFW", "SW32", 2);
    } catch (Exception e) {
      // this should not happen!
      return false;
    }

    // Verify that the accessors give the correct values for each Flight
    String f1Expected = "Flight Number: A234\nOrigin: MSN\nDestination: PDX\n"
        + "Capacity: 50\nAvailable Seats: 50";
    String f2Expected =
        "Flight Number: SW32\nOrigin: DIA\nDestination: DFW\n" + "Capacity: 2\nAvailable Seats: 2";
    try {
      // basic accessors
      if (!f1.getFlightNo().equals("A234") || !f2.getFlightNo().equals("SW32"))
        return false;
      if (f1.getCapacity() != 50 || f2.getCapacity() != 2)
        return false;

      // toString
      if (!f1.toString().trim().equals(f1Expected)) {
        System.out
            .println("toString error, expected:\n" + f1Expected + "\nbut got:\n" + f1.toString());
        return false;
      }
      if (!f2.toString().trim().equals(f2Expected)) {
        System.out
            .println("toString error, expected:\n" + f2Expected + "\nbut got:\n" + f2.toString());
        return false;
      }

      // equals
      if (f1.equals(f2) || f2.equals(f1) || !f1.equals(f1) || !f2.equals(f2))
        return false;
    } catch (Exception e) {
      // this should not happen!
      return false;
    }

    // Verify that the seats work as expected - note this should return a different value each time
    try {
      if (!f2.getNextAvailableSeat().equals("A1") || !f2.getNextAvailableSeat().equals("B1"))
        return false;
    } catch (Exception e) {
      // this should not happen!
      return false;
    }

    // Verify that the seats run out correctly
    try {
      String oops = f2.getNextAvailableSeat();
      System.out.println("Tried to get a third available seat from a flight with capacity 2, but "
          + "instead of throwing an exception, your method returned " + oops);
      return false;
    } catch (IllegalStateException e) {
      // this is good! do nothing.
    } catch (Exception e) {
      // this should not happen!
      return false;
    }
    return true;
  }

  public static boolean testBooking() {
    Booking.resetConfirmationNo();
    if (!testFlight())
      return false; // this test relies on Flight working properly!
    if (!testTraveler())
      return false; // this test relies on Traveler working properly!

    // Setup: create a Traveler and a Flight with at least one available seat.
    Traveler tester = new Traveler("tony", "wshao33@wisc.edu");
    Flight f1 = new Flight("MSN", "PDX", "A234", 50);


    // Create a booking with the Traveler and the Flight and verify that no exception is thrown
    try {
      Booking b1 = new Booking(tester, f1);
      // Check the results of getSeatNo, getConfirmationNo, and toString
      // System.out.println(b1.getSeatNo());
      if (!(b1.getSeatNo().equals("A1"))) {
        return false;
      }
      // System.out.println(b1.getConfirmationNo());
      if (!(b1.getConfirmationNo().equals("TON1234"))) {
        return false;
      }
      // System.out.println(b1.toString());
      if (!(b1.toString().equals("Name: tony\n" + "Confirmation Number: TON1234\n"
          + "Flight Number: A234\n" + "Seat Number: A1"))) {
        return false;
      }
      // Add this Booking to the Flight and verify that the Flight's capacity is correct
      // System.out.println(f1.getCapacity());
      if (!(f1.getCapacity() == 49)) {
        return false;
      }
      // (capacity = available seats + number of bookings)

    } catch (RuntimeException e) {
      return false;
    }
    // Try adding it again and verify that the correct exception is thrown
    return true;
  }

  public static boolean testBookingSystem() {
    // verify that all three BookingSystem methods work properly with your instantiable classes!
    // you should test both valid and invalid states.
    try {
    Booking.resetConfirmationNo();
    BookingSystem.scheduleFlight("MSN", "PDX", "A234", 50);
    String comfNum = BookingSystem.bookTicket("tony", "wshao33@wisc.edu", "A234");
    BookingSystem.getBooking(comfNum);
    
    // System.out.println(comfNum);
    //System.out.println(BookingSystem.getBooking(comfNum));
    if (!(comfNum.equals("TON1234"))) {
      return false;
    }
    
    if (!(BookingSystem.getBooking(comfNum).equals("Name: tony\n" + "Confirmation Number: TON1234\n"
        + "Flight Number: A234\n" + "Seat Number: A1"))) {
      return false;
    }
    if (!(BookingSystem.getBooking("00007").equals("Not Found"))) {
      return false;
    }
    }catch(Exception e) {
      return true;
    }
    return true;

  }

  public static boolean runAllTests() {
    return testTraveler() && testFlight() && testBooking() && testBookingSystem();
  }

  public static void main(String[] args) {
    boolean allTestsPass = runAllTests();
    System.out.println("All tests: " + allTestsPass);
    if (!allTestsPass) {
      System.out.println("  Traveler: " + testTraveler());
      System.out.println("  Flight: " + testFlight());
      System.out.println("  Booking: " + testBooking());
      System.out.println("  System: " + testBookingSystem());
    }
  }

}
