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
import java.util.ArrayList;

/**
 * Represents a flight that can be booked in our system. Maintains a list of all Bookings made for
 * the given flight.
 */
public class Flight {

  // data fields associated with a single Flight object
  private String origin;
  private String destination;
  private String flightNo;
  private ArrayList<Booking> bookings;
  private ArrayList<String> seats; // filled using the generateSeats() method

  /**
   * Constructs a new Flight object with a given origin, destination, and flight number, and uses a
   * helper method to generate the seats available to be booked.
   * 
   * @param origin      where the flight will take off
   * @param destination where the flight will land
   * @param flightNo    the flight's identifier
   * @param capacity    the number of seats on the flight
   */
  public Flight(String origin, String destination, String flightNo, int capacity) {
    this.origin = origin;
    this.destination = destination;
    this.flightNo = flightNo;
    seats = generateSeats(capacity);
    bookings = new ArrayList<Booking>();
  }

  /**
   * Accessor method to retrieve this flight's number
   * 
   * @return the flight's identifier
   */
  public String getFlightNo() {
    return flightNo; //
  }

  /**
   * Calculates the total capacity of this flight based on the number of bookings + the number of
   * available seats.
   * 
   * @return the total capacity of this flight
   */
  public int getCapacity() {
    return seats.size() + bookings.size();
  }

  /**
   * Removes and returns the next available seat from this flight's seats list.
   * 
   * @return the generated seat identifier of the next available seat, e.g. "A12"
   * @throws IllegalStateException if no more seats are available
   */
  public String getNextAvailableSeat() throws IllegalStateException {
    if (seats.size() > 0) {
      String seatNum = seats.get(0);
      seats.remove(0);
      return seatNum;
    } else
      throw new IllegalStateException("no more seats are available");
  }

  /**
   * Looks through the list of bookings for this flight to determine whether any of them contain the
   * provided confirmation number.
   * 
   * @param confirmationNo the confirmation number to search for
   * @return the Booking corresponding to the confirmation number if found; null otherwise
   */
  public Booking getBooking(String confirmationNo) {
    for (int i = 0; i < bookings.size(); i++) {
      if (bookings.get(i).getConfirmationNo().equals(confirmationNo)) {
        return bookings.get(i);
      }
    }
    return null;
  }

  /**
   * Records that a Booking has been made on this flight. Does NOT call getNextAvailableSeat(). Must
   * verify that the Booking in question has not already been added to the list (hint: use
   * getBooking() to check).
   * 
   * @param b the booking to add, which has already been properly constructed.
   * @throws IllegalArgumentException if the Booking has already been added to this flight
   */
  public void addBooking(Booking b) throws IllegalArgumentException {
    if (getBooking(b.getConfirmationNo()) == null) {
      bookings.add(b);
    } else {
      throw new IllegalArgumentException("the Booking has already been added to this flight");
    }
  }

  /**
   * Creates and returns a String representation of this flight for printing, for example:
   * 
   * Flight Number: A234 Origin: MSN Destination: PDX Capacity: 50 Available Seats: 43
   * 
   * @return a String representation of this flight
   */
  @Override
  public String toString() {

    return "Flight Number: " + flightNo + "\nOrigin: " + origin + "\nDestination: " + destination
        + "\nCapacity: " + getCapacity() + "\nAvailable Seats: " + seats.size(); 
  }

  /**
   * Determines whether a provided object is equal to this flight. This implementation is provided
   * for you.
   * 
   * @param o the object to compare with
   * @return true if the object is a Flight with the same flightNo as this one, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Flight) {
      return ((Flight) o).getFlightNo().equals(this.flightNo);
    }
    return false;
  }

  /**
   * A class method to generate the seat identifiers for the flight. All seats begin with one of {A,
   * B, C, D} followed by the row number, beginning at 1 and going until all of the capacity has
   * been accounted for. This implementation is provided for you.
   * 
   * @param capacity the number of seat numbers to generate
   * @return an ArrayList of the generated seat numbers
   */
  protected static ArrayList<String> generateSeats(int capacity) {
    ArrayList<String> s = new ArrayList<String>(capacity);
    String seatLetters = "ABCD";
    int seatCounter = 0;
    int rowCounter = 1;

    while (s.size() < capacity) {
      s.add("" + seatLetters.charAt(seatCounter++) + rowCounter);
      seatCounter %= seatLetters.length();
      if (seatCounter == 0)
        rowCounter++;
    }

    return s;
  }
}


