//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Water Fountain
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
import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * This program is designed to present a water fountain with motion water.The idea behind this
 * technique is to use several small images or shapes that together give the appearance of a large
 * amorphous object that does not necessarily have a clearly defined surface.
 * 
 * @author wenpeishao
 *
 */
public class Fountain {
  private static Random randGen;
  private static PImage fountainImage;
  private static int positionX;
  private static int positionY;
  private static Droplet[] droplets;
  private static int startColor; // blue: Utility.color(23,141,235)
  private static int endColor; // lighter blue: Utility.color(23,200,255)

  public Fountain() {
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. Creates a single
   * droplet at position (3,3) with velocity (-1,-2). Then checks whether calling updateDroplet() on
   * this droplet’s index correctly results in changing its position to (2.0, 1.3).
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateDroplet() {
    droplets = new Droplet[3];
    droplets[0] = new Droplet();
    droplets[0].setPositionX(3);
    droplets[0].setPositionY(3);
    droplets[0].setVelocityX(-1);
    droplets[0].setVelocityY(-2);
    updateDroplet(0);
    // Debug
    // System.out.println(droplets[0].getPositionX());
    // System.out.println(droplets[0].getPositionY());

    if (Math.abs(droplets[0].getPositionX() - 2.0) > 0.00001
        && Math.abs(droplets[0].getPositionY() - 1.3) > 0.00001) {
      return false;
    }

    return true;
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. Calls
   * removeOldDroplets(6) on an array with three droplets (two of which have ages over six and
   * another that does not). Then checks whether the old droplets were removed and the young droplet
   * was left alone.
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldDroplets() {
    droplets = new Droplet[3];
    for (int i = 0; i < droplets.length; i++) {
      droplets[i] = new Droplet();
    }
    droplets[0].setAge(1);
    droplets[1].setAge(10);
    droplets[2].setAge(8);
    removeOldDroplets(6);
    if (droplets[0].getAge() == 1 || droplets[1] == null || droplets[2] == null) {
      return true;
    }
    return false;
  }


  /**
   * Within this method, call Utility.save("screenshot.png") whenever the key pressed happened to be
   * the s-key (either ’s’ or ’S’). This is another callback method that will be called at the
   * appropriate time by the Utility class, and so should never be called from your Fountain class.
   * 
   * @param key the char to Trigger the Utility.save
   */
  public static void keyPressed(char key) {
    if (key == 's' || key == 'S') {
      Utility.save("screenshot.png");
    }
  }


  /**
   * The job of this new method is to search through the droplets array for references to droplets
   * with an age that is greater than the specified max age and remove them. Be careful to null
   * references in the droplets array while searching for the old droplets. To remove an old
   * droplet, you can simply set its reference to null. You do not need to make any shift operation.
   * Null references can be at any position of a perfect size array. Implementing this correctly
   * should allow your water fountain to continue running forever.
   */
  private static void removeOldDroplets(int age) {
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] == null) {
        continue;
      }
      if (droplets[i].getAge() >= 80) {
        droplets[i] = null;
      }

    }
  }


  /**
   * Move the Fountain.positionX and Fountain.positionY to match the position of the mouse whenever
   * the mouse button is pressed.
   * 
   * 
   */
  public static void mousePressed() {
    Fountain.positionX = Utility.mouseX();
    Fountain.positionY = Utility.mouseY();

  }

  /**
   * This method should begin stepping through indexes of the droplets array in ascending order. As
   * it does so, it will be looking for null references within this array that can be changed to
   * reference newly created droplets. This loop will continue to do this until either:
   * 
   * @param number number of the New Droplets going to create
   */
  private static void createNewDroplets(int number) {
    int count = 0;

    for (int i = 0; i < droplets.length; i++) {
      if (count == number) {
        break;
      }
      if (droplets[i] == null) {
        float x_position = positionX + randGen.nextFloat() * 6 - 3;
        float y_position = positionY + randGen.nextFloat() * 6 - 3;
        int xV = randGen.nextInt(3) - 1;
        int yV = randGen.nextInt(5) - 10;
        int ageR = randGen.nextInt(40);
        int transparencyR = randGen.nextInt(95) + 32;
        float modColor = randGen.nextFloat();

        float size = randGen.nextFloat() * 7 + 4;
        int color = Utility.lerpColor(startColor, endColor, modColor);
        droplets[i] = new Droplet(x_position, y_position, size, color);
        droplets[i].setVelocityX(xV);
        droplets[i].setVelocityY(yV);
        droplets[i].setAge(ageR);
        droplets[i].setTransparency(transparencyR);
        count++;
      }
    }
  }

  /**
   * The index passed as input represents the index of a specific droplet within the droplets array.
   * This method should do all of the moving (by setting positions x and y), accelerating (updating
   * the y-velocity by adding 0.3f to it), and drawing of a droplet (by calling Utility.fill() and
   * Utility.circle()) that we already used them in the draw() method, but should be able to do that
   * with whatever droplet is specified through the provided index.
   * 
   * @param index the index of the droplet in the droplets array.
   */
  private static void updateDroplet(int index) {
    float xPosition = droplets[index].getPositionX();
    float yPosition = droplets[index].getPositionY();
    int color = droplets[index].getColor();
    int transparency = droplets[index].getTransparency();


    droplets[index].setVelocityY(droplets[index].getVelocityY() + 0.3f);
    xPosition += droplets[index].getVelocityX();
    yPosition += droplets[index].getVelocityY();



    Utility.fill(color, transparency);
    Utility.circle(xPosition, yPosition, droplets[index].getSize());
    droplets[index].setPositionY(yPosition);
    droplets[index].setPositionX(xPosition);
    droplets[index].setAge(droplets[index].getAge() + 1);
    droplets[index].setTransparency(transparency);
    droplets[index].setColor(color);
  }

  /**
   * This method is automatically called by Utility.runApplication() when the program begins. It
   * creates and initializes the different data fields defined in your program, and configures the
   * different graphical settings of your application, such as loading the background image, setting
   * the dimensions of the display window, etc.
   * 
   */
  public static void setup() {
    if (!testUpdateDroplet()) {
      System.out.println("test#1 fail");
    }
    if (!testRemoveOldDroplets()) {
      System.out.println("test#2 fail");
    }
    randGen = new Random(123);
    // set the initial position of the fountain to the center of the screen.
    positionX = Utility.width() / 2;
    positionY = Utility.height() / 2;
    // load the image of the fountain
    fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");
    droplets = new Droplet[800];
    startColor = Utility.color(23, 141, 235); // blue: Utility.color(23,141,235)
    endColor = Utility.color(23, 200, 255); // lighter blue: Utility.color(23,200,255)


    // for(int i=0;i<droplets.length;i++) {
    // droplets[i] = new Droplet();
    // droplets[i].setVelocityX(-6);
    // droplets[i].setVelocityY(-6);
    //
    // }

  }

  /**
   * This method continuously executes the lines of code contained inside its block until the
   * program is stopped. It continuously draws the application display window and updates its
   * content with respect to any change or any event which affects its appearance.
   * 
   */
  public static void draw() {
    Utility.background(Utility.color(253, 245, 230));
    Utility.fill(Utility.color(23, 141, 235));
    // Draw the fountain image to the screen at position (positionX, positionY)
    Utility.image(fountainImage, positionX, positionY);
    // System.out.print(droplets[0].getPositionX());
    createNewDroplets(10);
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null) {
        updateDroplet(i);
      }
    }
    removeOldDroplets(80);
  }

  /**
   * This is the main method of program use to start the application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Utility.runApplication(); // starts the application


  }

}
