//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Treasure Hunt Adventure Game
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
 * @author wenpeishao most of the objects in the backyard are clickable. A clickable object responds
 *         to the mouse being pressed (while it is over the object) and released. All these objects
 *         are repeatedly drawn to the display window in different ways, and respond differently to
 *         the mouse events (when the mouse is over them, pressed, or released).
 */
public interface Clickable {
  public void draw(); // draws this Clickable object to the screen

  public void mousePressed(); // defines the behavior of this Clickable object
                              // each time the mouse is pressed

  public void mouseReleased(); // defines the behavior of this Clickable object
                               // each time the mouse is released

  public boolean isMouseOver(); // returns true if the mouse is over this clickable object

}
