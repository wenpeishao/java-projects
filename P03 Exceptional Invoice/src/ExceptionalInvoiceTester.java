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

/**
 * This is a tester class, called ExceptionalInvoiceTester. This tester is design to test the p03
 * exceotional invoice
 * 
 * @author wenpeishao
 *
 */
public class ExceptionalInvoiceTester {

  public static boolean testLoadParts() {
    // Normal behavior: provide the name of a file that exists and is formatted correctly (such as
    // parts.txt). Verify that the parts array has the expected length and contents (you may hard
    // code these values). If any exception is thrown here, the test fails.
    try {
      ExceptionalInvoice.loadParts("parts.txt");
      if (ExceptionalInvoice.parts.length != 14) {
        return false;
      }
      if (ExceptionalInvoice.parts[0].equals("basic pedals $12.50")
          || ExceptionalInvoice.parts[13].equals("chain $7.95")) {

      }
    } catch (FileNotFoundException e) {
      return false;
    }
    // File not found: provide the name of a file that does not exist. Verify that the method threw
    // a FileNotFoundException; if it does not throw an exception, or throws anything other than a
    // FileNotFoundException, the test fails.
    try {
      ExceptionalInvoice.loadParts("part.txt");
    } catch (FileNotFoundException e) {
      return true;
    }
    return false;
  }
    
  public static boolean testAdd() {
    boolean flag_1=false;
    boolean flag_2=false;
    ExceptionalInvoice.parts = null;

    int[] invoice = new int[10];
    int size =0;
    
    //Uninitialized parts array
    try {
      ExceptionalInvoice.addPart(invoice,size,0);
      ExceptionalInvoice.addLabor(invoice, size, 10);
    }catch(IllegalStateException e) {
      flag_1 = true;
    }
    //Invalid part number
    try {
      ExceptionalInvoice.loadParts("parts.txt");
      ExceptionalInvoice.addPart(invoice,size,100);
    }catch(IndexOutOfBoundsException | FileNotFoundException e) {
      flag_2 = true;
    }
    //Valid part number
    try {
      ExceptionalInvoice.addPart(invoice,size,0);
      ExceptionalInvoice.addLabor(invoice, size, 10);
      if(flag_1&&flag_2) {
        return true;
      }
      
    }catch(IndexOutOfBoundsException e) {
      
    }catch(IllegalStateException e) {
      
    }
    
    return false;
  }
  public static boolean testGetCost() {
    //Uninitialized parts array
    boolean flag_1=false;
    boolean flag_2=false;
    ExceptionalInvoice.parts = null;
    try {
      ExceptionalInvoice.getCost(0 );
    }catch(IllegalStateException e){
      flag_1 = true;
    }
    //Invalid part number
    try {
      ExceptionalInvoice.loadParts("parts.txt");
      ExceptionalInvoice.getCost(100);
    }catch(IndexOutOfBoundsException | FileNotFoundException e) {
      flag_2 = true;
    }
    //Valid part number
    try {
      double cost = ExceptionalInvoice.getCost(0);
      if(flag_1&&flag_2&&cost==12.50) {
        return true;
      }
      
    }catch(IndexOutOfBoundsException e) {
      
    }catch(IllegalStateException e) {
      
    }
    

    return false;
  }
  
  public static boolean testPrintInvoice()  {
    //Uninitialized parts array
    boolean flag_1=false;
    boolean flag_2=false;
    ExceptionalInvoice.parts = null;
    try {
      ExceptionalInvoice.printInvoice(null, 0, 0, 0, null );
    }catch(IllegalStateException e){
      flag_1 = true;
    } catch (FileNotFoundException e) {

    }
    //No discount
    try {
      ExceptionalInvoice.loadParts("parts.txt");
      int [] invoice = {11,5,44};
      int size = 3;
      ExceptionalInvoice.printInvoice(invoice,size,60,0,"invoice.txt");
      Scanner input = new Scanner(new File("invoice.txt"));
      String context="";
      while(input.hasNextLine()) {
        context+=(input.nextLine()+"\n");
      }
      String expected =
          "winter tire $241.50\n" + 
          "brake pads $19.99\n" + 
          "labor: 30 minutes\n" + 
          "===\n" + 
          "total: $291.49 (no discount applied)\n";
      if (context.equals(expected)) {
        flag_2 = true;
        
      }
    } catch (FileNotFoundException e) {
       
    }
    
    //Other discount
    try {
      ExceptionalInvoice.loadParts("parts.txt");
      int [] invoice = {11,5,44};
      int size = 3;
      ExceptionalInvoice.printInvoice(invoice,size,60,2,"invoice.txt");
      Scanner input = new Scanner(new File("invoice.txt"));
      String context="";
      while(input.hasNextLine()) {
        context+=(input.nextLine()+"\n");
        
      }
      String expected =("winter tire $241.50\n" + 
          "brake pads $19.99\n" + 
          "labor: 30 minutes\n" + 
          "===\n" + 
          "total: $261.49 (friends and family discount applied)\n");
      //System.out.println(expected);
      //System.out.println(context);
      //System.out.println(expected.compareTo(context));
      if (context.equals(expected)&&flag_1&&flag_2) {
        return true;
      }
    } catch (FileNotFoundException e) {
       
    }
    
    return false;
    
  }

  /** This is the main method of the class used to run all tester
   * @param args
   */
  public static void main(String[] args) {
    
    if(!(testLoadParts())) {
      System.out.println("testLoadParts fail!");
    }
    if(!(testAdd())) {
      System.out.println("testAdd fail!");
    }
    if(!(testGetCost())) {
      System.out.println("testGetCost fail!");

    }
    if(!(testPrintInvoice())){
      System.out.println("testPrintInvoice fail!");
    }
    System.out.println("test end.");
  }

}
