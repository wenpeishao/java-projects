
public class Room {
  /**
   * Building and room numbers, e.g. "Noland 168".
   */
  private String location;
  /**
   * Maximum number of people that can be in the hall at one time
   */
  private int capacity;
  /**
   * Initializes the data field to the value of the parameter.
   * @param location
   * @param capacity
   */
  public Room(String location, int capacity) {
    if(capacity<0) {
      throw new IllegalArgumentException("the provided integer is negative (<0)");
    }
    this.capacity = capacity;
    this.location = location;

  }

  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @return the capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * returns a NEW Room object with the same location as this done,but with a capacity less than
   * this one’s by the argument’s amount. For example, if Room r has a capacity of 10, calling
   * r.reduceCapacity(3) will return a new Room object with the same location as r but a capacity of
   * 7. If the argument is greater than the given Room’s capacity, this method should throw an
   * IllegalArgumentException with a descriptive error message.
   * 
   * @param numberToReduce
   * @return returns a NEW Room object with the same location as this done,but with a capacity less
   *         than this one’s by the argument’s amount.
   */
  public Room reduceCapacity(int numberToReduce) {
    if(numberToReduce>capacity) {
      throw new IllegalArgumentException("the argument is greater than the given Room’s capacity");
    }
    return new Room(location, capacity - numberToReduce);

  }


}
