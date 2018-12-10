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
/**
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a BST (known as a Sett).
 * 
 * @author Reece Lardy & Nick Hayden
 */
public class Badger {
  // Initialize fields
  private Badger leftLowerNeighbor;
  private Badger rightLowerNeighbor;
  private int size;

  /**
   * Creates a new Badger with specified size.
   * 
   * @param size - The size of the newly constructed Badger object.
   */
  public Badger(int size) {
    // assign input size to badger size variable
    this.size = size;
    // initiate both of the new badger's neighbors to null
    this.leftLowerNeighbor = null;
    this.rightLowerNeighbor = null;
  }

  /**
   * Retrieves neighboring badger that is smaller than this one.
   * 
   * @return The left lower neighbor of current badger.
   */
  public Badger getLeftLowerNeighbor() {
    return this.leftLowerNeighbor;
  }

  /**
   * Retrieves neighboring badger that is larger than this one.
   * 
   * @return The right lower neighbor of current badger.
   */
  public Badger getRightLowerNeighbor() {
    return this.rightLowerNeighbor;
  }

  /**
   * Retrieves the size of this badger.
   * 
   * @return The size of current badger.
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Changes this badger's lower left neighbor.
   * 
   * @param badger - The new left lower neighbor of current badger.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }

  /**
   * Changes this badger's lower right neighbor.
   * 
   * @param badger - The new right lower neighbor of current badger.
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }
}
