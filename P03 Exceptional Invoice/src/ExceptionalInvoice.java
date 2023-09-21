//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Exceptional Invoice
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
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * A class of utility methods for creating an invoice at a bicycle repair shop. This is intended as
 * an exercise in using oversize arrays, String parsing, basic conditionals and arithmetic
 * operations for CS 300 students to familiarize themselves with Java syntax, and is not intended as
 * an example of necessarily GOOD or EFFICIENT program design :P
 * 
 * Note that the invoice array and its corresponding size variable will be created and stored in a
 * DIFFERENT class than this one - this class only uses the variables provided as arguments. Do not
 * add any additional class variables to this code.
 * 
 */
public class ExceptionalInvoice {

  /**
   * A list of parts offered by this bike repair shop. All parts are formatted as Strings with the
   * part description first, followed by the price in USD. Do not modify this array.
   * 
   * Because this array's access modifier is "protected", you will be able to access it directly in
   * your BikeInvoiceTester class.
   */
  protected static String[] parts;

  public static void loadParts(String filename) throws FileNotFoundException {
    // if it does not exist, allow the FileNotFoundException to be thrown from Scanner
    try {
      Scanner input = new Scanner(new File(filename));
      int partsNum = 0;
      if (input.hasNextLine()) {
        partsNum = Integer.valueOf(input.nextLine());
        parts = new String[partsNum];
        for (int i = 0; i < partsNum; i++) {
          parts[i] = input.nextLine();
        }
      }
    } catch (FileNotFoundException e) {
      throw e;
    }
  }

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
    // with a message describing what went wrong
    if (parts == null) {
      throw new IllegalStateException("the parts array has not yet been initialized");
    }

    // with a message describing what went wrong
    if (parts.length <= partNum || partNum < 0) {
      throw new IndexOutOfBoundsException("the partNum corresponds to an invalid part");
    }

    // verify that there is room in the invoice array to add the new part
    if (size >= invoice.length) {
      return size;
    }

    // add the new part to the invoice array and return the size of the modified array
    // note: after the above checks are added, this should be a safe operation
    invoice[size] = partNum;
    return size + 1;
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
    // with a message describing what went wrong
    if (parts == null) {
      throw new IllegalStateException("the parts array has not yet been initialized");
    }

    // verify that there is room in the invoice array to add the labor cost
    if (size >= invoice.length) {
      return size;
    }

    // if the number of minutes is 0 or less, don't add it to the invoice array
    if (numMins <= 0) {
      return size;
    }

    // add the number of minutes to the length of the parts array and THEN add it to the invoice
    invoice[size] = parts.length + numMins;
    return size + 1;
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
    // with a message describing what went wrong
    if (parts == null) {
      throw new IllegalStateException("the parts array has not yet been initialized");
    }

    // verify that the partIndex provided is valid (not negative or off the end of the parts array)
    if (parts.length <= partIndex || partIndex < 0) {
      throw new IndexOutOfBoundsException("the partNum corresponds to an invalid part");
    }

    // get the cost of the part and return it
    int startIndex = parts[partIndex].indexOf('$') + 1;
    String cost = parts[partIndex].substring(startIndex);
    return Double.parseDouble(cost);
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
   * @param discountType     one of three discount types that can be applied to the total, or
   *                         anything else if no discount is to be applied
   * @return the total cost represented by all current entries in the invoice, with discount applied
   */
  public static double getTotalCostDiscount(int[] invoice, int size, double laborCostPerHour,
      int discountType) {
    // with a message describing what went wrong
    if (parts == null) {
      throw new IllegalStateException("the parts array has not yet been initialized");
    }

    double total = 0;
    double partsDiscount = (discountType == 3) ? .7 : 1; // note: this is called a ternary operator

    // add the cost of each element to a variable containing the running total, with the relevant
    // discount applied to parts and/or labor
    for (int i = 0; i < size; i++) {
      if (invoice[i] < parts.length) {
        // for part entries, add the cost of the part to the total
        total += partsDiscount * getCost(invoice[i]);
      } else if (discountType != 2) {
        // for labor entries, get the time and multiply times the labor cost
        double time = (invoice[i] - parts.length) / 60.0;
        total += time * laborCostPerHour;
      }
    }

    if (discountType == 1) {
      return total * .85;
    }
    return total;
  }

  /**
   * NOTE: The current contents of this correspond to the BikeInvoice method getPrintedInvoice and
   * will need to be changed/replaced!!
   * 
   * This method creates the string representation of the invoice as before, but instead of
   * returning the String, writes the invoice to the file indicated in the last parameter value. If
   * the file cannot be created, the method should allow the IOException to be thrown.
   * 
   * If you need help writing to files, check out zyBooks chapter 21, section 5!
   * 
   * @param invoice          the oversize array of parts and labor
   * @param size             the current number of valid entries in the invoice array
   * @param laborCostPerHour the cost of 60 minutes of labor in USD
   * @param discountType     one of three discount types that can be applied to the total, or
   *                         anything else if no discount is to be applied
   * @param filename         the name of the file to write the invoice into
   * @return a String representation of the current invoice
   * @throws FileNotFoundException 
   */
  public static void printInvoice(int[] invoice, int size, double laborCostPerHour,
      int discountType, String filename) throws FileNotFoundException {
    // with a message describing what went wrong
    if (parts == null) {
      throw new IllegalStateException("the parts array has not yet been initialized");
    }

    String retval = "";
    int totalLabor = 0;

    // go through each of the valid entries in the invoice array
    for (int i = 0; i < size; i++) {
      if (invoice[i] < parts.length) {
        // for part entries, add the part description/cost followed by a newline character
        retval += parts[invoice[i]] + "\n";
      } else {
        // for labor entries, add the number of minutes to a running total
        totalLabor += invoice[i] - parts.length;
      }
    }

    // add a final line with the number of labor minutes
    retval += "labor: " + totalLabor + " minutes";

    //System.out.println(retval);
    try{PrintWriter pw = new PrintWriter(new File(filename));
    pw.println(retval);
    pw.println("===");
    double totalCost = 0;
    totalCost = getTotalCostDiscount(invoice, size,  laborCostPerHour,
         discountType);
    switch(discountType) {
      case 1:   pw.println("total: $"+totalCost+" (student discount applied)");
        break;
      case 2:   pw.println("total: $"+totalCost+" (friends and family discount applied)");
        break;
      case 3:   pw.println("total: $"+totalCost+" (vendor discount discount applied)");
        break;
      default:  pw.println("total: $"+totalCost+" (no discount applied)");
    }
    pw.close();
    }
    catch(IOException e) {
      throw e;
    }
    
    
    
    
  }

}
