//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Bike Invoice
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
/**
 * A class for testing your BikeInvoice methods. We've provided some guidance for how to structure
 * these tests so you can verify that things are working, as well as some examples.
 * 
 * Your goal is to get everything here to return TRUE on your (working) code and FALSE on any buggy
 * code that your instructors might write... (so don't just change the tests to all return true all
 * the time)
 */
public class BikeInvoiceTester {

  /**
   * A tester to validate the behavior of the BikeInvoice.addPart() method. We have provided this
   * entire method for you, but strongly recommend that you read through it and use it to help
   * construct the other tester methods!
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testAddPart() {
    // create an empty oversize array for the invoice
    int[] invoice = new int[10];
    int size = 0;

    // SCENARIO 1: EMPTY + VALID
    // try adding a valid part to an empty array, make sure that the method returns 1
    // if it returns anything other than 1, return false! this is not expected behavior
    // if the method did not add the part's number to index 0 of your invoice array, return false!
    size = BikeInvoice.addPart(invoice, size, 2);
    // System.out.println(size);

    if (size != 1)
      return false;
    if (invoice[size - 1] != 2)
      return false;

    // SCENARIO 2: NON-EMPTY + VALID
    // try adding another valid part to the same array, and make sure that the size is updated and
    // the next element in the array gets set to the correct value
    size = BikeInvoice.addPart(invoice, size, 7);
    // System.out.println(size);

    if (size != 2)
      return false;
    if (invoice[size - 2] != 2 || invoice[size - 1] != 7)
      return false;

    // SCENARIO 3: VALID EDGE CASES
    // try adding the first part in the list and the last part in the list! these are what we call
    // "edge cases", which are still valid part numbers but might be incorrectly called invalid
    size = BikeInvoice.addPart(invoice, size, 0);
    // System.out.println(size);

    if (size != 3)
      return false;
    size = BikeInvoice.addPart(invoice, size, BikeInvoice.parts.length - 1);
    // System.out.println(size);

    if (size != 4)
      return false;
    if (invoice[size - 2] != 0 || invoice[size - 1] != BikeInvoice.parts.length - 1)
      return false;

    // SCENARIO 4: INVALID PART NUMBERS
    // try adding invalid parts: negative integers, or indexes beyond the length of the parts list
    // the method should return the SAME size it was passed, and the array should NOT change
    size = BikeInvoice.addPart(invoice, size, -10);
    // System.out.println(size);
    if (size != 4)
      return false;
    size = BikeInvoice.addPart(invoice, size, BikeInvoice.parts.length);
    // System.out.println(size);

    if (size != 4)
      return false;

    // SCENARIO 5: INVOICE ARRAY IS FULL
    // add enough parts (or make your invoice array small enough) that you have FILLED the array.
    // now try adding one more part. the method should return the SAME size it was passed,
    // and the array should NOT change
    int[] fullInvoice = new int[4];
    for (int i = 0; i < size; i++) {
      fullInvoice[i] = invoice[i];
    }
    size = BikeInvoice.addPart(fullInvoice, size, 5);
    if (size != 4)
      return false;

    // if your addPart() method passed ALL of these tests, you may NOW return true
    return true;
  }

  /**
   * A tester to validate the behavior of the BikeInvoice.addLabor() method. We have provided a
   * little starter code and some scenarios for you to test.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testAddLabor() {
    // create an empty oversize array for the invoice
    int[] invoice = new int[10];
    int size = 0;

    // SCENARIO 1: EMPTY + VALID
    // try adding a positive number of labor minutes to the empty array, make sure that the method
    // returns 1 and properly updates the invoice array
    size = BikeInvoice.addLabor(invoice, size, 15);
    if (size != 1)
      return false;
    // remember that labor minutes are recorded as the length of the parts array + numMinutes
    if (invoice[size - 1] != BikeInvoice.parts.length + 15)
      return false;

    // SCENARIO 2: NON-EMPTY + VALID
    // try adding some more labor minutes to the same array, and make sure the size and array are
    // updated accordingly
    size = BikeInvoice.addLabor(invoice, size, 20);
    if (size != 2)
      return false;
    // remember that labor minutes are recorded as the length of the parts array + numMinutes
    if (invoice[size - 1] != BikeInvoice.parts.length + 20)
      return false;

    // SCENARIO 3: INVALID LABOR MINUTES
    // try adding 0 or negative values for labor minutes and verify that the size and array do not
    // change
    size = BikeInvoice.addLabor(invoice, size, 0);
    if (size != 2)
      return false;

    // if your addLabor() method passed ALL of these tests, you may NOW return true
    return true;
  }

  /**
   * A tester to validate the behavior of the BikeInvoice.getCost() method. We have provided some
   * scenarios for you to test, but no starter code.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testGetCost() {
    Double Cost = 0.0;
    // SCENARIO 1: VALID
    // pick a valid index into the BikeInvoice.parts array and verify that BikeInvoice.getCost()
    // gives you the double value that you would expect from this array. if the value is incorrect,
    // return false
    Cost = BikeInvoice.getCost(0);
    if (Cost != 12.50)
      return false;
    // SCENARIO 2: INVALID
    // try a negative index or one beyond the length of the BikeInvoice.parts array. verify that
    // the method returns -1 in this case
    Cost = BikeInvoice.getCost(-1);
    if (Cost != -1.0)
      return false;


    // if your getCost() method passed ALL of these tests, you may NOW return true
    return true;
  }

  /**
   * A tester to validate the behavior of the BikeInvoice.getTotalCost() method. We have provided
   * some scenarios for you to test, but no starter code.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testGetTotalCost() {
    // SCENARIO 1: NON-EMPTY, PARTS ONLY
    // create an oversize invoice array and add some values to it (don't forget to update the size)
    // you can do this using the add methods, or just directly set its contents to int values that
    // are between 0 and the length of the parts array.
    // verify that BikeInvoice.getTotalCost() correctly adds up all of the values
    double cost = 0;
    int[] invoice = {0, 1, 2, 4};
    int size = 4;
    cost = BikeInvoice.getTotalCost(invoice, size, 10.0);
    // System.out.println(cost);
    if (cost != 451.49) {
      return false;
    }
    // SCENARIO 2: NON-EMPTY, LABOR ONLY
    // create an oversize invoice array and add some values to it (don't forget to update the size)
    // you can do this using the add methods, or just directly set its contents to int values that
    // are between greater than the length of the parts array.
    // verify that BikeInvoice.getTotalCost() correctly calculates the total labor costs
    invoice = new int[] {74, 74, 44, 44};
    size = 4;
    cost = BikeInvoice.getTotalCost(invoice, size, 10.0);
    // System.out.println(cost);
    if (cost != 30.0) {
      return false;
    }



    // SCENARIO 3: NON-EMPTY, MIXED PARTS AND LABOR
    // combine scenarios 1 and 2!
    invoice = new int[] {0, 74, 44, 1};
    size = 4;
    cost = BikeInvoice.getTotalCost(invoice, size, 10.0);
    // System.out.println(cost);
    if (cost != 67.49000000000001) {
      return false;
    }


    // SCENARIO 4: EMPTY ARRAY
    // what should happen if the invoice array doesn't have anything in it? make sure that happens.
    invoice = new int[10];
    size = 0;
    cost = BikeInvoice.getTotalCost(invoice, size, 10.0);
    // System.out.println(cost);
    if (cost != 0) {
      return false;
    }



    // if your getTotalCost() method passed ALL of these tests, you may NOW return true
    return true;
  }

  /**
   * A tester to validate the behavior of the BikeInvoice.getTotalCostDiscount() method. We have
   * provided some scenarios for you to test, but no starter code.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testDiscount() {
    // create an oversize array of parts and labor values. make sure to set the size
    // properly!
    // pick a standard hourly labor cost to use across your tests (for example,
    // $30.00)
    int[] invoice = new int[10];
    int size = 0;
    size = BikeInvoice.addLabor(invoice, size, 50);// 14+50=64
    size = BikeInvoice.addLabor(invoice, size, 20);// 14+20=34
    size = BikeInvoice.addPart(invoice, size, 8);// 5.99
    size = BikeInvoice.addPart(invoice, size, 10);// 150
    double totalCost = 0;

    // SCENARIO 1: STUDENT DISCOUNT
    // verify that the total with the discount type of 1 is what you expect (yes,
    // i'm making you
    // do your own math here), a 15% total discount
    totalCost = BikeInvoice.getTotalCostDiscount(invoice, size, 30, 1);
    // System.out.println(totalCost);
    if (totalCost != 162.3415)
      return false;
    // SCENARIO 2: FRIENDS AND FAMILY DISCOUNT
    // verify that the total with the discount type of 2 is what you expect, no
    // labor costs
    totalCost = BikeInvoice.getTotalCostDiscount(invoice, size, 30, 2);
    // System.out.println(totalCost);
    if (totalCost != 155.99)
      return false;
    // SCENARIO 3: VENDOR DISCOUNT
    // verify that the total with the discount type of 3 is what you expect, 30% off
    // parts but full
    // labor costs
    totalCost = BikeInvoice.getTotalCostDiscount(invoice, size, 30, 3);
    // System.out.println(totalCost);
    if (totalCost != 144.19299999999998)
      return false;
    // SCENARIO 4: INVALID DISCOUNT
    // verify that any other discount type does not result in a reduction of total
    // cost
    totalCost = BikeInvoice.getTotalCostDiscount(invoice, size, 30, 5);
    // System.out.println(totalCost);
    if (totalCost != 0.0)
      return false;
    // if your getTotalCostDiscount() method passed ALL of these tests, you may NOW
    // return true
    return true;
  }

  /**
   * A tester to validate the behavior of the BikeInvoice.getPrintedInvoice() method. We have
   * provided some scenarios for you test, and a little starter code.
   * 
   * @return true if and only if all tests pass
   */
  public static boolean testPrintInvoice() {
    String expected = "chain $7.95\nmountain bike innertube $5.99\nlabor: 20 minutes";

    // SCENARIO 1: ALL LABOR AT THE END
    // create an oversize array of parts and labor values such that the printed
    // invoice should
    // match the given expected value. include the labor time as one entry at the
    // end, and verify
    // that the result of getPrintedInvoice() matches the expected value exactly
    int[] invoice = new int[10];
    int size = 0;
    size = BikeInvoice.addPart(invoice, size, 8);// 5.99
    size = BikeInvoice.addPart(invoice, size, 10);// 150
    size = BikeInvoice.addLabor(invoice, size, 50);// 14+50=64
    size = BikeInvoice.addLabor(invoice, size, 20);// 14+20=34
    String info = BikeInvoice.getPrintedInvoice(invoice, size);
    // System.out.println(info);
    expected = "mountain bike innertube $5.99\n" + "road bike tire $150.00\n" + "labor: 70 minutes";
    if (!info.equals(expected))
      return false;
    // SCENARIO 2: ALL LABOR IN THE MIDDLE
    // change your invoice to include the labor time between the chain and innertube
    // entries.
    // verify that the result of getPrintedInvoice() still matches the expected
    // value exactly
    // invoice=new int[10];
    size = 0;
    size = BikeInvoice.addPart(invoice, size, 8);// 5.99
    size = BikeInvoice.addLabor(invoice, size, 50);// 14+50=64
    size = BikeInvoice.addLabor(invoice, size, 20);// 14+20=34
    size = BikeInvoice.addPart(invoice, size, 10);// 150
    info = BikeInvoice.getPrintedInvoice(invoice, size);
    // System.out.println(info);
    if (!info.equals(expected))
      return false;
    // SCENARIO 3: MULTIPLE LABOR ENTRIES
    // break the labor minutes up into at least two entries in the invoice.
    // verify that the result of getPrintedInvoice() still matches the expected
    // value exactly
    size = 0;   
    size = BikeInvoice.addPart(invoice, size, 8);// 5.99
    size = BikeInvoice.addLabor(invoice, size, 50);// 14+50=64
    size = BikeInvoice.addPart(invoice, size, 10);// 150
    size = BikeInvoice.addLabor(invoice, size, 20);// 14+20=34
    info = BikeInvoice.getPrintedInvoice(invoice, size);
    // System.out.println(info);

    if (!info.equals(expected))
      return false;
    // if your getPrintedInvoice() method passed ALL of these tests, you may NOW
    // return true
    return true;
  }

  /**
   * Provided method; calls your test methods and prints output for your usage.
   * 
   * @return true if and only if all test methods return true.
   */
  public static boolean runAllTests() {
    boolean test1 = false;
    boolean test2 = false;
    boolean test3 = false;
    boolean test4 = false;
    boolean test5 = false;
    boolean test6 = false;

    // This portion of the code will prevent your program from crashing when it runs.
    // If the output is ERROR! for any particular test, try calling that one individually from
    // the main method to see why it would have crashed.
    try {
      System.out.print("testAddPart(): ");
      test1 = testAddPart();
      System.out.println(test1);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    try {
      System.out.print("testAddLabor(): ");
      test2 = testAddLabor();
      System.out.println(test2);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    try {
      System.out.print("testGetCost(): ");
      test3 = testGetCost();
      System.out.println(test3);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    try {
      System.out.print("testGetTotalCost(): ");
      test4 = testGetTotalCost();
      System.out.println(test4);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    try {
      System.out.print("testDiscount(): ");
      test5 = testDiscount();
      System.out.println(test5);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    try {
      System.out.print("testPrintInvoice(): ");
      test6 = testPrintInvoice();
      System.out.println(test6);
    } catch (Exception e) {
      System.out.println("ERROR!");
    }

    return test1 && test2 && test3 && test4 && test5 && test6;
  }

  /**
   * Main method, where your program begins. Calls the runAllTests method.
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    runAllTests();
  }

}
