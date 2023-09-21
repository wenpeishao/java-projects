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
 * A class of utility methods for creating an invoice at a bicycle repair shop. This is intended as
 * an exercise in using oversize arrays, String parsing, basic conditionals and arithmetic
 * operations for CS 300 students to familiarize themselves with Java syntax, and is not intended as
 * an example of necessarily GOOD or EFFICIENT program design :P
 * 
 * Note that the invoice array and its corresponding size variable will be created and stored in a
 * DIFFERENT class than this one - this class only uses the variables provided as arguments. Do not
 * add any additional class variables to this code.
 */
public class BikeInvoice {

  /**
   * A list of parts offered by this bike repair shop. All parts are formatted as Strings with the
   * part description first, followed by the price in USD. Do not modify this array.
   * 
   * Because this array's access modifier is "protected", you will be able to access it directly in
   * your BikeInvoiceTester class.
   */
  protected static String[] parts =
      new String[] {"basic pedals $12.50", "upgraded pedals $39.99", "leather seat $150.00",
          "basic seat $31.99", "bmx seat $249.00", "brake pads $19.99", "aero wheel $400.00",
          "road bike innertube $5.99", "mountain bike innertube $5.99", "mountain bike tire $80.00",
          "road bike tire $150.00", "winter tire $241.50", "fat bike tire $168.00", "chain $7.95"};

  /**
   * Adds the index of a part in the parts array to the invoice array, if the provided index
   * corresponds to a valid part.
   * 
   * @param invoice the oversize array of parts and labor
   * @param size    the current number of valid entries in the invoice array
   * @param partNum the index of the part to add in the parts array
   * @return the number of valid entries in the invoice array after the method is complete
   */
  public static int addPart(int[] invoice, int size, int partNum) {

    // verify that there is room in the invoice array to add the new part
    // if there is not, just return the size of the unmodified array
    if (invoice.length <= size) {
      return size;
    }



    // if there is room AND the part number corresponds to a valid entry in the parts array
    // add the new part to the invoice array and return the size of the modified array
    if (partNum < BikeInvoice.parts.length && partNum >= 0) {
      invoice[size] = partNum;
      size++;
      // System.out.println(size);
      return size;
    } else
      return size;
    // otherwise, don't modify the array and return its current size
  }

  /**
   * Adds the number of minutes of labor required to the invoice array, as though it were the last
   * index of the parts array + the number of minutes of labor
   * 
   * Note: there may be multiple labor entries in the invoice array. Do not combine them.
   * 
   * @param invoice the oversize array of parts and labor
   * @param size    the current number of valid entries in the invoice array
   * @param numMins the number of minutes of labor to add to the invoice array
   * @return the number of valid entries in the invoice array after the method is complete
   */
  public static int addLabor(int[] invoice, int size, int numMins) {

    // verify that there is room in the invoice array to add the labor cost
    // if there is not, just return the size of the unmodified array
    if (invoice.length <= size) {
      return size;
    }



    // if the number of minutes is 0 or less, don't add it to the invoice array
    // just return the size of the unmodified array
    if (numMins <= 0) {
      return size;
    }

    // add the number of minutes to the length of the parts array and THEN add it to the invoice
    // return the size of the modified invoice array
    invoice[size] = numMins + BikeInvoice.parts.length;
    size++;
    // System.out.println(size);
    return size;

  }

  /**
   * A utility method to help parse out the cost of a part from its String representation in the
   * parts array. All parts are formatted as Strings with the part description first, followed by
   * the price in USD.
   * 
   * DON'T just hard-code all of the prices here in one big if statement. You're trying to learn
   * Java, aren't you??
   * 
   * @param partIndex the index of the part in question
   * @return the cost of the part in USD
   */
  public static double getCost(int partIndex) {

    // verify that the partIndex provided is valid (not negative or off the end of the parts array)
    // if it is invalid, return -1.0
    if (partIndex < 0 || partIndex >= BikeInvoice.parts.length) {
      return -1.0;
    }

    // find the index of the $ in the parts array description of this part - the rest of the String
    // will contain the cost of this part
    int idx = BikeInvoice.parts[partIndex].indexOf('$');
    String Cost = BikeInvoice.parts[partIndex].substring(idx + 1);

    // System.out.println(Cost);


    // use the index of the $ to get JUST the portion of the string with the numeric cost
    // that is, if the part is "part name $5.99", get just the "5.99" part of the string


    // convert this number to a double-type value and return it
    // that is, if you had "5.99" as your string, you should return the double value 5.99
    return Double.parseDouble(Cost);
    // return -1; // included to prevent errors; fix this
  }

  /**
   * Calculates the total cost of all parts and labor currently present in the invoice array.
   * 
   * @param invoice          the oversize array of parts and labor
   * @param size             the current number of valid entries in the invoice array
   * @param laborCostPerHour the cost of 60 minutes of labor in USD
   * @return the total cost represented by all current entries in the invoice
   */
  public static double getTotalCost(int[] invoice, int size, double laborCostPerHour) {

    // go through each of the valid entries in the invoice array
    // add the cost of that element to a variable containing the running total
    double totalCost = 0;
    for (int i = 0; i < size; i++) {
      if (invoice[i] < BikeInvoice.parts.length) {
        totalCost += getCost(invoice[i]);
      } else
        totalCost += (((double) invoice[i] - BikeInvoice.parts.length) / 60) * laborCostPerHour;
    }

    // for part entries, add the cost of the part to the total

    // for labor entries, get the time and multiply times the labor cost

    // be careful! the labor cost is given by the hour and the labor time is given in minutes
    // if labor time is 45 minutes, convert to .75 hours before calculating labor cost


    // return your running total
    return totalCost;
  }

  /**
   * Calculates the total cost of all parts and labor currently present in the invoice array, and
   * applies one of three possible discount types:
   * 
   * 1. student discount, reduces total cost by 15% 2. friends and family discount, all labor costs
   * are free 3. vendor discount, reduces parts cost by 30%
   * 
   * Any discount type that is not 1, 2, or 3 is invalid and the total is calculated normally.
   * 
   * @param invoice          the oversize array of parts and labor
   * @param size             the current number of valid entries in the invoice array
   * @param laborCostPerHour the cost of 60 minutes of labor in USD
   * @param discountType     one of three discount types that can be applied to the total
   * @return the total cost represented by all current entries in the invoice, with discount applied
   */
  public static double getTotalCostDiscount(int[] invoice, int size, double laborCostPerHour,
      int discountType) {

    // go through each of the valid entries in the invoice array
    // add the cost of that element to a variable containing the running total, with the relevant
    // discount applied to parts and/or labor
    double totalCost = 0;
    if (discountType == 1) {
      for (int i = 0; i < size; i++) {
        if (invoice[i] < BikeInvoice.parts.length) {
          totalCost += getCost(invoice[i]);
        } else
          totalCost += (((double) invoice[i] - BikeInvoice.parts.length) / 60) * laborCostPerHour;
      }
      totalCost *= .85;
    } else if (discountType == 2) {
      for (int i = 0; i < size; i++) {
        if (invoice[i] < BikeInvoice.parts.length) {
          totalCost += getCost(invoice[i]);
        }
        // else totalCost += (((double) item-BikeInvoice.parts.length)/60)*laborCostPerHour;
      }
    } else if (discountType == 3) {
      for (int i = 0; i < size; i++) {
        if (invoice[i] < BikeInvoice.parts.length) {
          totalCost += (getCost(invoice[i])) * 0.7;
        } else
          totalCost += (((double) invoice[i] - BikeInvoice.parts.length) / 60) * laborCostPerHour;
      }
    }

    // for part entries, add the cost of the part to the total

    // for labor entries, get the time and multiply times the labor cost
    // be careful! the labor cost is given by the hour and the labor time is given in minutes
    // if labor time is 45 minutes, convert to .75 hours before calculating labor cost

    // return your running total
    return totalCost;
  }

  /**
   * Creates and returns a string representation of the current invoice, with each part on a
   * separate line and the total estimated labor time (not cost) as the last entry
   * 
   * @param invoice the oversize array of parts and labor
   * @param size    the current number of valid entries in the invoice array
   * @return a String representation of the current invoice
   */
  public static String getPrintedInvoice(int[] invoice, int size) {

    // go through each of the valid entries in the invoice array
    String printedIvnoice = "";
    int laborMinutes = 0;
    for (int i = 0; i < size; i++) {
      // for part entries, add the part description/cost followed by a newline character
      if (invoice[i] < BikeInvoice.parts.length) {
        printedIvnoice += BikeInvoice.parts[invoice[i]] + "\n";

      }
      // for labor entries, add the number of minutes to a running total
      else
        laborMinutes += invoice[i] - BikeInvoice.parts.length;


      // but don't add anything to your string representation yet
    }

    // once you've added all the parts and totaled all labor times, add a final line to the String
    // with the total labor time, as "labor: NNN minutes" where you replace NNN with the number of
    // labor minutes in the invoice array. this number may have more or less than 3 digits.
    printedIvnoice += "labor: " + laborMinutes + " minutes";


    // return the string representation of the invoice
    return printedIvnoice; // included to prevent errors; fix this
  }

}
