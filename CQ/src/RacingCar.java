///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:Wenpei Shao
// Campus ID:9083215211
// WiscEmail:wshao33@wisc.edu
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//
// BE CAREFUL!! This file contains TWO classes. You will need to complete the
// implementation of BOTH classes with respect to the provided requirements
// in the TODO tags for full credit.
//
// When creating new exception objects, including messages within these objects 
// is optional.
////////////////////////////////////////////////////////////////////////////////
class RacingCar extends Car {

  private String driver; // name of the driver of this racing car
  private boolean isWinner; // true if this racing car wins the race, and false otherwise


  /**
   * Creates a new RacingCar with provided driver, model, and speed. When created, the RacingCar
   * object is NOT a winner.
   * 
   * @param driver the name of the driver of this racing car
   * @param model  the model of this car
   * @param speed  the speed to be assigned to this car
   * @throws IllegalStateException    if driver is null
   * @throws IllegalArgumentException if model is null, or speed is less than zero
   */
  public RacingCar(String driver, String model, int speed) {
    // TODO:
    // 10. call the constructor of the super class with the passed model and speed as
    // input). Hint: Do not catch the IllegalArgumentException which may be thrown by the call of
    // the constructor of the super class. Let the exception propagates.
    super(model,speed);

    // 11. Check the validity of the driver input parameter
    if(driver==null) {
      throw new IllegalStateException();
    }
    // 12. Set the driver of this racing car to the driver passed as input to this constructor
    this.driver=driver;
    // 13. Set the isWinner data field to false (optional since the default value of a boolean is false).
    isWinner = false;
  }

  // You are NOT allowed to add any additional methods to this class

  /**
   * Increments the speed of this racing car by the amount passed as input. We assume that amount is
   * positive (VALID).
   * @param amount amount by which to increment the speed of this racing car
   */
  public void speedUp(int amount) {
    // TODO:
    // 14. Complete the implementation of this method
    speed+=amount;

  }

  /**
   * Changes the state of this RacingCar object to reflect that this car finished the race at the
   * first position (won the race).
   * 
   */
  public void finishFirst() {
    // TODO:
    // 15. Complete the implementation of this method
    isWinner=true;

  }

  /**
   * Returns a string representation of this RacingCar object. The returned string must have the
   * following format: driver + " (winner: " + isWinner + ") " +  model + ": " speed
   * 
   * @Return a String representation of this BCycle object
   */
  @Override
  public String toString() {
    // TODO:
    // 16. Complete the implementation of this method. Notice carefully that the model of the car is
    // a private data field with no getter defined in the super class Car. 
    // Think of using the toString() method implemented in the super class Car

    return driver + " (winner: " + isWinner + ") " +  super.toString(); // default return statement added to avoid compiler errors. Feel free to change it.
  }

  // MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) before submitting it to Gradescope

}
