// Email: acarrig@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

/**
 * An interface to implement a House Object with properties
 * price, numBaths, and numBedrooms
 */
public interface HouseADT<T extends Comparable<T>>  {

  /**
   * Returns the price of the house object
   * @return - the price as a string
   */
  int getPrice();

  /**
   * The number of bathrooms in the house -- assumes there are no half baths
   * @return - The number of bathrooms as an int
   */
  int getNumBaths();

  /**
   * Gets the number of bedrooms in the house
   * @return - The number of bedrooms in the house as an int
   */
  int getNumBedrooms();

//    /**
//     * House address
//     * @return - address of house as a string
//     */
//    String getAddress();
}
