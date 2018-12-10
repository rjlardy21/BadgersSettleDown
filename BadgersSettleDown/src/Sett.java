//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Sett.java
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
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized as a
 * BST of Badger nodes.
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class Sett {
  // Sett field for the top badger in the BST
  private Badger topBadger;

  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    // initiate top badger variable to null
    topBadger = null;
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    // set top badger variable to null to erase BST
    topBadger = null;
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return this.topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    // if the top badger is null, we return true because the BST is empty
    if (this.topBadger == null) {
      return true;
      // otherwise, return false
    } else {
      return false;
    }
  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST).
   * 
   * @param size - The size of the new Badger that will be settled.
   * @throws IllegalArgumentException - When a Badger with the specified size already exists within
   *         this Sett. The message in this exception must read: "WARNING: failed to settle the
   *         badger with size {size}, as there is already a badger with the same size in this sett",
   *         where {size} needs to be replaced with the specified size parameter.
   */
  public void settleBadger(int size) throws IllegalArgumentException {
    // Initiate the current badger as the top badger, and the new badger as a new badger object with
    // inputted size
    Badger current = topBadger;
    Badger newBadger = new Badger(size);
    // If the tree is empty, make the new badger the top badger
    if (current == null) {
      topBadger = newBadger;
      // otherwise, call recursive method to add a badger to the tree
    } else {
      settleHelper(current, newBadger);
    }
  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * @param current - The current Badger (previously settled within this Sett) that we are
   *        considering settling the newBadger beneath (either to its left or right).
   * @param newBadger - The new Badger that needs to be settled within this Sett.
   * @throws IllegalArgumentException - When a Badger with the specified size already exists within
   *         this Sett. The message in this exception must read: "WARNING: failed to settle the
   *         badger with size {size}, as there is already a badger with the same size in this sett",
   *         where {size} needs to be replaced with the specified size parameter.
   */
  private void settleHelper(Badger current, Badger newBadger) throws IllegalArgumentException {
    // if the current badger in the tree is bigger than the new badger
    if (current.getSize() > newBadger.getSize()) {
      // if the current badger does not have a LL neighbor
      if (current.getLeftLowerNeighbor() == null) {
        // settle the new badger as the current badger's LL neighbor
        current.setLeftLowerNeighbor(newBadger);
      } else {
        // otherwise, call the method again with the current badger's LL neighbor as the new current
        // badger
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
      } // if the current badger is smaller than the new badger
    } else if (current.getSize() < newBadger.getSize()) {
      // if the current badger does not have a LR neighbor
      if (current.getRightLowerNeighbor() == null) {
        // settle the new badger as the current badger's LR neighbor
        current.setRightLowerNeighbor(newBadger);
      } else {
        // otherwise, call the method again with the current badger's RL neighbor as the new current
        // badger
        settleHelper(current.getRightLowerNeighbor(), newBadger);
      } // if the current badger is the same size as the current badger
    } else {
      // throw an illegal argument exception
      throw new IllegalArgumentException("WARNING: failed to settle the badger with size "
          + newBadger.getSize() + ", as there is already a badger with the same size in this sett");
    }
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws NoSuchElementException - When there is no Badger in this Sett with the specified size.
   *         The message within this exception must read "WARNING: failed to find a badger with size
   *         {size} in the sett", where {size} needs to be replaced with the specified size
   *         parameter.
   */
  public Badger findBadger(int size) throws NoSuchElementException {
    // create current badger referencing the top badger
    Badger current = topBadger;
    // if the tree is empty
    if (current == null) {
      // throw exception
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the sett");
      // if tree is not empty
    } else {
      // return a recursize call to the helper method
      return findHelper(current, size);
    }
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are searching for
   *        a Badger with the specified size within.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws NoSuchElementException - When there is no Badger in this Sett with the specified size.
   *         The message within this exception must read "WARNING: failed to find a badger with size
   *         {size} in the sett", where {size} needs to be replaced with the specified size
   *         parameter.
   */
  private Badger findHelper(Badger current, int size) throws NoSuchElementException {
    // if current badger is larger than input size
    if (current.getSize() > size) {
      // if current badger has no LL neighbor
      if (current.getLeftLowerNeighbor() == null) {
        // throw exception
        throw new NoSuchElementException(
            "WARNING: failed to find a badger with size " + size + " in the sett");
      } else {
        // otherwise, call the helper method recursively with the current badger's LL neighbor as
        // the new current badger
        return findHelper(current.getLeftLowerNeighbor(), size);
      } // if current badger is smaller than input size
    } else if (current.getSize() < size) {
      // if current badger has no RL neighbor
      if (current.getRightLowerNeighbor() == null) {
        // throw exception
        throw new NoSuchElementException(
            "WARNING: failed to find a badger with size " + size + " in the sett");
      } else {
        // otherwise, call the helper method recursively with the current badger's LL neighbor as
        // the new current badger
        return findHelper(current.getRightLowerNeighbor(), size);
      } // if current badger is the same size as input size
    } else {
      // return current badger
      return current;
    }
  }


  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    // Create current badger variable with reference to the top badger in the Sett
    Badger current = topBadger;
    // if the sett is empty
    if (current == null) {
      // return 0
      return 0;
      // if the sett is not empty
    } else {
      // return a recursive call to the helper method
      return countHelper(current);
    }
  }

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are counting the
   *        number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    // initialize count variable to 0
    int count = 1;
    // if the current badger has a LL neighbor
    if (current.getLeftLowerNeighbor() != null) {
      // count is incremented by a recursive call with the current badger's LL neighbor as the new
      // current badger
      count = count + countHelper(current.getLeftLowerNeighbor());
    }
    // if the current badger has a RL neighbor
    if (current.getRightLowerNeighbor() != null) {
      // count is incremented by a recursive call with the current badger's LL neighbor as the new
      // current badger
      count = count + countHelper(current.getRightLowerNeighbor());
    }
    // if the current badger has no lower neighbors, return the count
    return count;
  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers() {
    // create current badger as a reference to the top badger of the sett
    Badger current = topBadger;
    // create array list for storing all badgers in the sett
    java.util.List<Badger> allBadgers = new ArrayList<Badger>();
    // if the set is empty
    if (current == null) {
      // return the empty list
      return allBadgers;
      // if the set is not empty
    } else {
      // call the recursive helper method
      getAllHelper(current, allBadgers);
    }
    // return the list of badgers
    return allBadgers;
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param allBadgers - The list of all Badgers living in the Sett that is rooted at the current
   *        Badger node. The contents of this list should be in ascending order by Badger size.
   * @param current - The current Badger that is the root of a (sub) tree that we are collecting all
   *        contained Badgers within, into the allBadgers List.
   */
  private void getAllHelper(Badger current, List<Badger> allBadgers) {
    // if the current badger has a LL neighbor
    if (current.getLeftLowerNeighbor() != null) {
      // method makes a recursive call on itself with the current badger's LL neighbor as the new
      // current badger
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
    }
    // add the current badger to the list
    allBadgers.add(current);
    // if the current badger has a RL neighbor
    if (current.getRightLowerNeighbor() != null) {
      // method makes a recursive call on itself with the current badger's RL neighbor as the new
      // current badger
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
    }
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {
    // create current badger as a reference to the top badger in the sett
    Badger current = topBadger;
    // if the sett is empty
    if (current == null) {
      // return 0
      return 0;
      // if the sett is not empty
    } else {
      // call the recursive helper method
      return getHeightHelper(current);
    }
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are calculating
   *        the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    // initialize a left and a right count for each side of the tree
    int leftCount = 0;
    int rightCount = 0;
    // if the current badger badger has a LL neighbor
    if (current.getLeftLowerNeighbor() != null) {
      // increment the left count by a recursive call to itself with the current badger's LL
      // neighbor as the new current badger
      leftCount = leftCount + getHeightHelper(current.getLeftLowerNeighbor());
    }
    // if the current badger badger has a RL neighbor
    if (current.getRightLowerNeighbor() != null) {
      // increment the left count by a recursive call to itself with the current badger's RL
      // neighbor as the new current badger
      rightCount = rightCount + getHeightHelper(current.getRightLowerNeighbor());
    }
    // count is initialized to the larger of the right and left counts + 1
    int count = Math.max(rightCount, leftCount) + 1;
    // return count
    return count;
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    // create current badger as a reference to the top badger in the sett
    Badger current = topBadger;
    // if the sett is empty
    if (current == null) {
      // return null
      return null;
      // if the sett is not empty
    } else {
      // while the current badger has a RL neighbor
      while (current.getRightLowerNeighbor() != null) {
        // make the current badger's RL neighbor the new current badger
        current = current.getRightLowerNeighbor();
      }
    }
    // return the current badger
    return current;
  }



}
