// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Carrig
// Email: acarrig@wisc.edu
// Team: DE
// TA: April Roszkowski
// Lecturer: Florian Heimerl 
// Notes to Grader: N/A

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BackendDeveloperTests {

  /**
   * Test the HouseADT to make sure it is properly created
   * This tests creating a House object as well as testing values from the expected getters
   */
  @Test
  public void test1() {
    // Check the values of our created house
    House house1 = new House(1000000, 3, 2);
    assertEquals(1000000, house1.getPrice());
    assertEquals(3, house1.getNumBaths());
    assertEquals(2, house1.getNumBedrooms());
  //    assertEquals("1234 Main St.", house1.getAddress());
  }

  /**
   * Test setting and resetting the filters
   * for # beds, # bathrooms
   * These filters are used to influence the searchByPrice method to make it more specific
   * They can be reset to hold a value of 0
   */
  @Test
  public void test2() {
    // Set the filters for backend
    HouseSearcherBackend backend = new HouseSearcherBackend();
    //    backend.setAddress("101 Wisconsin Ave");
    backend.setNumBaths(2);
    backend.setNumBedrooms(4);

    // Check the filters for backend
    //    assertEquals("101 Wisconsin Ave", backend.getAddress());
    assertEquals(2, backend.getNumBaths());
    assertEquals(4, backend.getNumBedrooms());

    // Make sure resetting the filters works
    backend.resetNumBaths();
    backend.resetNumBedrooms();
    assertEquals(0, backend.getNumBaths());
    assertEquals(0, backend.getNumBedrooms());
  }

  /**
   * Test the house compareTo() so we can properly compare houses
   * This tests comparing houses with the same prices, # of baths, and # of bedrooms
   * There is a tier system to how they are compared, explained in the house compareTo method
   */
  @Test
  public void test3() {
    House house1 = new House(1000000, 3, 2);
    House house2 = new House(999999, 3, 2);

    // Compare house1 and house2 (different prices)
    assertEquals(1, house1.compareTo(house2));

    // Compare house1 and house3 (different # of bathrooms)
    House house3 = new House(1000000, 5, 2);
    assertEquals(-1, house1.compareTo(house3));

    // Compare house1 and house4 (different # of bedrooms)
    House house4 = new House(1000000, 3, 1);
    assertEquals(1, house1.compareTo(house4));

    // Compare house1 and house5 (same everything except address)
    House house5 = new House(1000000, 3, 2);
    assertEquals(0, house1.compareTo(house5));
  }

  /**
   * Test adding houses
   */
  @Test
  public void test4() {
    House house1 = new House(1000000, 4, 4);
    House house2 = new House(10, 1, 0);
    HouseSearcherBackend backend = new HouseSearcherBackend();

    // Add houses
    backend.addHouse(house1);
    backend.addHouse(house2);

    // Check if houses are actually added (and can be found)
    List<House> houseList = backend.searchByPrice(0, 10000000, false, false);
    assertEquals(2, houseList.size());

  //    // Remove house and check if there are now less houses in our list
  //    backend.removeHouse(house1);
  //    assertEquals(1, houseList.size());
  }

  /**
   * Test searchByPrice() method with specific # of baths and/or beds
   */
  @Test
  public void test5() {
    // Test searchByPrice() while ignoring # of beds/baths
    HouseSearcherBackend backend = new HouseSearcherBackend();
    House house1 = new House(1, 6, 9);
    House house2 = new House(12, 4, 1);
    House house3 = new House(1001, 2, 3);
    House house4 = new House(12345, 3, 2);

    backend.addHouse(house1);
    backend.addHouse(house2);
    backend.addHouse(house3);
    backend.addHouse(house4);

    List<House> result1 = backend.searchByPrice(0, 2, false, false);
    assertEquals(1, result1.size());

    List<House> result2 = backend.searchByPrice(0, 15, false, false);
    assertEquals(2, result2.size());

    List<House> result3 = backend.searchByPrice(0, 1234, false, false);
    assertEquals(3, result3.size());

    List<House> result4 = backend.searchByPrice(2, 12345, false, false);
    assertEquals(3, result4.size());

    // Test searchByPrice with specific #s of bathrooms and bedrooms
    backend.setNumBaths(4);
    backend.setNumBedrooms(1);

    List<House> result5 = backend.searchByPrice(0, 15, true, true);
    assertEquals(1, result5.size());
  }

  //  /**
  //   * Test backend searchByAddress() method
  //   */
  //  @Test
  //  public void test5() {
  //    House house1 = new House(1, 1, 1, "Address");
  //    HouseSearcherBackend backend = new HouseSearcherBackend();
  //
  //    // Test searchByAddress with no houses/a non-existing house
  //    assertNull(backend.searchByAddress("Address"));
  //
  //    // Test searchByAddress with a regular house
  //    backend.addHouse(house1);
  //    assertEquals(house1, backend.searchByAddress("Address"));
  //  }

}

