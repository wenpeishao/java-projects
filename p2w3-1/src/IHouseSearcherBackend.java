// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Carrig
// Email: acarrig@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.util.List;

/**
 * An interface to implement the search and filter functionality
 * for House objects.
 */
public interface IHouseSearcherBackend {

  /**
   * Removes a house from the binary search tree using algo engineer
   */
  public void removeHouse(House house);

  /**
   * Adds a house to RB tree
   */
  public void addHouse(House house);

  /**
   * returns the size of the rb tree
   * @return - size of tree as int
   */
  public int getNumberOfHouses();

  /**
   * Set the filter for number of baths a house must have
   * @param numBaths - num of baths a house must have
   */
  public void setNumBaths(int numBaths);

  /**
   * A filter for # of Bedrooms a house must have
   * @param numBedrooms - # of bedrooms in a house
   */
  public void setNumBedrooms(int numBedrooms);

  /**
   * get the # of baths a user wants a house to have
   * @return - # of bathrooms a house must have
   */
  public int getNumBaths();

  /**
   * get the # of bedrooms a user wants a house to have
   * @return - # of bedrooms a house must have
   */
  public int getNumBedrooms();

  /**
   * reset the filter for numBaths (reset setNumBaths)
   */
  public void resetNumBaths();

  /**
   * reset the filter for number of bedrooms
   */
  public void resetNumBedrooms();

  /**
   * Search for house with specific criteria
   * This method will use the above numBaths and numBedrooms filters as well as
   *    the price parameters to only add houses with all the criteria
   *    to a list of House objects
   *
   * @param minPrice - min price of house to look for
   * @param maxPrice - max price of house to look for
   * @return - A list of houses meeting ALL the criteria
   */
  public List<House> searchByPrice(int minPrice, int maxPrice, boolean filterBaths, boolean filterBeds);
  
//    /**
//     * set the address filter
//     */
//    public void setAddress(String address);
//
//    /**
//     * get the address filter
//     * @return
//     */
//    public String getAddress();

//    /**
//     * This method will return a list of houses (or likely just one house)
//     * that has the desired address
//     * @param address - the string address a house must have to be returned
//     * @return - The house with address as specified by the string parameter
//     */
//    public House searchByAddress(String address);

}

