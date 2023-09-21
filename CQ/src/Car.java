///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:Wenpei Shao
// Campus ID:
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

/**
 * This class models the Car data type.
 * 
 * NOTES: 
 * You may NOT add any additional data fields to this class NOT specified in the TODO tags.
 * You may NOT add any additional methods to this class whether private or public. 
 * You may NOT need to implement any tester for this class.
 * 
 */
public class Car {
  // TODO
  // 1. Declare a private instance field of type String named model
  private String model;

  // 2. Declare a protected instance field of type int named speed
  protected int speed;

  // 3. Declare a private static data field of type int named carCount initialized to zero
  // carCount represents the total number of Car objects created by the constructor of this class
  private static int carCount=0;

  /**
   * Creates a new Car with a given model and speed.
   * 
   * @param model model name to be assigned to this car
   * @param speed speed to be assigned to this car
   * @throws IllegalArgumentException if model is null or speed is less than ( < ) 0.
   */
  public Car(String model, int speed) throws IllegalArgumentException {
    // TODO
    // 4. Check the validity of the input parameters
    if(model==null||speed<0) {
      throw new IllegalArgumentException();
    }

    // 5. Set the instance data fields to the provided input parameters
    this.model=model;
    this.speed=speed;
    // 6. Increments the total number of created Car objects
    carCount++;

  }

  // MAKE SURE TO SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) before submitting it to Gradescope

  /**
   * Sets the speed of this bike to the provided speed
   * 
   */
  public void setSpeed(int speed) {
    // TODO:
    // 7. Complete the implementation of this mutator
    this.speed=speed;


  }

  /**
   * Gets the total number of cars
   * 
   * @return the total number of cars
   */
  public static int getCarCount() {
    // TODO
    // 8. Complete the implementation of this accessor

    return carCount; // default return statement added to avoid compiler errors. Feel free to change it.

  }


  /**
   * Returns a string representation of this car. The returned string must have the following
   * format: model + ": " + speed
   * 
   * @Return a String representation of this car
   */
  @Override
  public String toString() {
    // TODO
    // 9. Implement this method

    return model + ": " + speed; // default return statement added to avoid compiler errors. Feel free to change it.
  }

}
