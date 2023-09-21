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
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author wenpeishao TreasureHunt extends PApplet defining an is-a inheritance relationship. The
 *         TreasureHunt class is of type PApplet. This means that it models the display window of
 *         our graphic adventure game.
 */
public class TreasureHunt extends PApplet {
  private PImage backgroundImage; // PImage object which represents the background image
  private ArrayList<Clickable> gameObjects; // list storing objects instances of Clickable

  /**
   * Sets the size of the application display window
   */
  @Override
  public void settings() {
    size(800, 600);
  }

  /**
   * Defines initial environment properties, loads background images and fonts , loads the clues,
   * and initializes the instance fields, as the program starts.
   */
  @Override
  public void setup() {

    this.focused = true; // Confirms that this graphic display window is "focused," meaning that it
    // is active and will accept mouse or keyboard input.
    this.imageMode(PApplet.CORNERS); // Interprets the x and y position of an image to the position
                                     // of its upper-left corner on the screen
    this.getSurface().setTitle("Treasure Hunt"); // Displays the title of the display window
    this.rectMode(PApplet.CORNERS); // Sets the location from which rectangles are drawn.
    // rectMode(CORNERS) interprets the first two parameters of rect() method as the position of the
    // upper left corner, and the third and fourth parameters as the position of the opposite
    // corner.
    // rect() method draws a rectangle to the display window

    this.textSize(13); // sets the text font size to 13
    this.textAlign(PApplet.CENTER, PApplet.CENTER); // sets the text alignment to center
    InteractiveObject.setProcessing​(this);

    initGame();
  }

  /**
   * Initializes the game settings and list of objects
   */
  public void initGame() {
    // TODO load the background image using PApplet.loadImage() method and assign the returned
    // PApplet reference to backgroundImage instance data field
    backgroundImage = loadImage("images" + File.separator + "background.png");

    // TODO
    // Create a new ArrayList of Clickable and assign its reference to the gameObjects instance
    // field
    gameObjects = new ArrayList<Clickable>();
    gameObjects.add(new InteractiveObject("koala", 350, 65,
        "What a cute stuffed koala! It looks like a real one!"));
    gameObjects.add(new InteractiveObject("coinTarget", 65, 510,
        "This is where the gold coin must be dropped."));
    gameObjects.add(new InteractiveObject("map", 330, 550,
        "The map says to drop the gold coin there.",(InteractiveObject)(gameObjects.get(1))));


  }

  /**
   * Adds a Clickable object, giving its reference, to the list of game objects
   * 
   * @param clickableObject reference to an object instance of Clickable to add
   */
  public void add(Clickable clickableObject) {
    // TODO complete the implementation of this method
    gameObjects.add(clickableObject);

  }

  /**
   * Updates the treasure hunt game display window. Draws the background image, draws all clickable
   * objects stored in the list of game objects, then removes all the interactive objects which are
   * no longer active.
   */
  @Override
  public void draw() {
    // TODO
    // 1. draw background image to the position (0, 0) of this display window
    image(backgroundImage, 0, 0);

    // TODO
    // 2. traverse the list of gameObjects and draw all clickable objects
    for (int i = 0; i < gameObjects.size(); i++) {
      gameObjects.get(i).draw();
      // TODO
      // 3. traverse the list of gameObjects and remove deactivated interactive objects
      if (gameObjects.get(i) instanceof InteractiveObject) {
        if (!((InteractiveObject) (gameObjects.get(i))).isActive()) {
          gameObjects.remove(i);
        }
      }
    }
  }

  /**
   * Operates each time the mouse is pressed
   */
  @Override
  public void mousePressed() {
    // TODO traverse the list of gameObjects and call mousePressed() method of each object stored in
    // the list
    for (int i = 0; i < gameObjects.size(); i++) {
      if (gameObjects.get(i).isMouseOver()) {
        gameObjects.get(i).mousePressed();
      }
    }

  }

  /**
   * Operates each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // TODO traverse the list of gameObjects and call mouseReleased() method of each object stored
    // in the list
    for (int i = 0; i < gameObjects.size(); i++) {
      if (gameObjects.get(i).isMouseOver()) {
        gameObjects.get(i).mouseReleased();;
      }
    }
  }

  /**
   * Helper method to retrieve the reference to the iteractive object whose name matches the name
   * passed as input from the gameObjects list names (case-sensitive comparison). If multiple
   * objects have that name, this method will return the first (lowest-index) reference found.
   * 
   * @param name is the name of the object that is being found
   * @return a reference to an interactive object with the specified name, or null when none is
   *         found
   */
  protected InteractiveObject findObjectByName​(java.lang.String name) {
    for(int i=0;i<gameObjects.size();i++) {
      if (gameObjects.get(i) instanceof InteractiveObject) {
        if (((InteractiveObject) (gameObjects.get(i))).hasName​(name)) {
          return ((InteractiveObject) (gameObjects.get(i)));
        }
      }
    }
    return null;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    PApplet.main("TreasureHunt"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class.


  }

}
