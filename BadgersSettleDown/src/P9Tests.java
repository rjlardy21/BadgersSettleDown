//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Badger.java
// Files: Sett.java, P9tests.java, BadgersSettleDown.java, SettVisualizer.jar
// Course: CS300 Fall 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Alexander Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Nick Hayden
// Partner Email: nhayden@wisc.edu
// Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class contains a series of tests that ensure that Badger.java and Sett.java work as expected
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class P9Tests {

  public static void main(String[] args) {
    /**
     * This main method calls the two runAll test methods for badger.java and sett.java
     */
    // initialize a boolean representing the status of all the tests
    boolean allTests = true;
    // if the method call returns false
    if (!runAllBadgerTests()) {
      // all tests is false
      allTests = false;
      // print an error message
      System.out.println("badger test failed");
    }
    // if the method call returns false
    if (!runAllSettTests()) {
      // all tests is false
      allTests = false;
      // print an error message
      System.out.println("set test failed");
    }
    // if all tests is true after calling the test methods
    if (allTests)
      // print a message saying that all tests have passed
      System.out.println("All tests passed!");
  }

  /**
   * Calls every test method for badger.java
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean runAllBadgerTests() {
    // if method call returns false
    if (!testBadgerConstructor()) {
      // print error message
      System.out.println("testBadgerConstructor did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testBadgersetLeftLowerNeighbor()) {
      // print error message
      System.out.println("testBadgersetLeftLowerNeighbor() did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testBadgergetSize()) {
      // print error message
      System.out.println("testBadgergetSize() did not work");
      // return false
      return false;
    }
    // returns true when all Badger.java tests pass
    return true;
  }

  /**
   * Calls every test method for sett.java
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean runAllSettTests() {
    // if method call returns false
    if (!testSettConstructor()) {
      // print error message
      System.out.println("testSettConstructor did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettisEmpty()) {
      // print error message
      System.out.println("testSettisEmpty did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettClear()) {
      // print error message
      System.out.println("testSettClear did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettgetTopBadger()) {
      // print error message
      System.out.println("testSettgetTopBadger did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettsettleBadger()) {
      // print error message
      System.out.println("testSettsettleBadger did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettfindBadger()) {
      // print error message
      System.out.println("testSettfindBadger did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettcountBadger()) {
      // print error message
      System.out.println("testSettcountBadger did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettgetAllBadgers()) {
      // print error message
      System.out.println("testSettgetAllBadgers did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettgetHeight()) {
      // print error message
      System.out.println("testSettgetHeight did not work");
      // return false
      return false;
    }
    // if method call returns false
    if (!testSettgetLargestBadger()) {
      // print error message
      System.out.println("testSettgetLargestBadger did not work");
      // return false
      return false;
    }
    // returns true when all Sett tests pass
    return true;
  }

  /**
   * Tests the functionality of Badger.java Badger constructor
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testBadgerConstructor() {
    // initiate a size variable of 4
    int size = 4;
    // create a test badger of size 4
    Badger test = new Badger(size);
    // if badger has a LL neighbor
    if (test.getLeftLowerNeighbor() != null) {
      // return false
      return false;
    }
    // if badger has a RL neighbor
    if (test.getRightLowerNeighbor() != null) {
      // return false
      return false;
    }
    // if badger getSize doesnt return 4
    if (test.getSize() != size) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java Sett constructor
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettConstructor() {
    // create test Sett
    Sett test = new Sett();
    // if the top badger in the sett is not null
    if (test.getTopBadger() != null) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Badger.java setLLNeighbor()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testBadgersetLeftLowerNeighbor() {
    // create two badgers of size 4
    int size = 4;
    Badger test = new Badger(size);
    Badger next = new Badger(size);
    // set next badger as test badger's LL neighbor
    test.setLeftLowerNeighbor(next);
    // if the test badger's LL neighbor is not the next badger
    if (test.getLeftLowerNeighbor() != next) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Badger.java getSize()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testBadgergetSize() {
    // create two badgers of size 4
    int size = 4;
    Badger test = new Badger(size);
    // if getSize does not the correct size
    if (test.getSize() != 4) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java isEmpty()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettisEmpty() {
    // create a new sett
    Sett sett = new Sett();
    // if sett is not empty
    if (!sett.isEmpty()) {
      // return false
      return false;
    }
    // add a badger of size 3 to the sett
    sett.settleBadger(3);
    // if set is empty
    if (sett.isEmpty()) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java clear()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettClear() {
    // create a sett and add two badgers to it
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(5);
    // clear the set
    sett.clear();
    // if sett is not empty
    if (!sett.isEmpty()) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java getTopBadger()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettgetTopBadger() {
    // create a new sett and add a badger of size 3
    Sett sett = new Sett();
    sett.settleBadger(3);
    // if the sett's top badger does not have a size of 3
    if (sett.getTopBadger().getSize() != 3)
      // return false
      return false;
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java settleBadger()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettsettleBadger() {
    // create and add 3 badgers of sizes 3, 6, and 5
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    // if the badger of size 6 does not have a LL neighbor of size 5
    if (sett.findBadger(6).getLeftLowerNeighbor().getSize() != 5)
      // return false
      return false;
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java findBadger()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettfindBadger() {
    // create a new sett
    Sett sett = new Sett();
    // try the following code
    try {
      // search the empty sett for a badger of size 2
      sett.findBadger(2);
      // return false
      return false;
      // catch exception
    } catch (NoSuchElementException e) {
    }
    // add 3 badgers of sizes 3, 6, and 5
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    // if there is not a badger of size 5 in the sett
    if (sett.findBadger(5).getSize() != 5) {
      // return false
      return false;
    }
    try {
      // try and find a badger that is not in the sett
      sett.findBadger(2);
      // return false
      return false;
    } catch (NoSuchElementException e) {
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java countBadger()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettcountBadger() {
    // create a new sett with 3 badgers of sizes 3, 6, and 5
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    // if there are not 3 badgers in the sett
    if (sett.countBadger() != 3) {
      // return false
      return false;
    }
    // add a badger of size 1 to the sett
    sett.settleBadger(1);
    // if there are not 4 badgers in the sett
    if (sett.countBadger() != 4) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java getAllBadgers()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettgetAllBadgers() {
    // create a new sett with 3 badgers of sizes 3, 6, and 5
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    // create a test list with the value of the get all badgers method call
    java.util.List<Badger> test = sett.getAllBadgers();
    // if the first element in get all badgers is not smaller than the second
    if (!(test.get(0).getSize() < test.get(1).getSize())) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java getHeight()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettgetHeight() {
    // create a new sett with 3 badgers of sizes 3, 6, and 5
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    // if the sett's height is not 3
    if (sett.getHeight() != 3) {
      // return false
      return false;
    }
    // add a badger of size 7 to the sett
    sett.settleBadger(7);
    // if the sett's height is not 3
    if (sett.getHeight() != 3) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }

  /**
   * Tests the functionality of Sett.java getLargestBadger()
   * 
   * @return true if test passed, false otherwise
   */
  public static boolean testSettgetLargestBadger() {
    // create a new sett with 6 badgers of sizes 3, 6, 5, 10, 12, and 11
    Sett sett = new Sett();
    sett.settleBadger(3);
    sett.settleBadger(6);
    sett.settleBadger(5);
    sett.settleBadger(10);
    sett.settleBadger(12);
    sett.settleBadger(11);
    // if the largest badger in the sett is not the badger of size 12
    if (sett.getLargestBadger() != sett.findBadger(12)) {
      // return false
      return false;
    }
    // return true when test passes
    return true;
  }
}
