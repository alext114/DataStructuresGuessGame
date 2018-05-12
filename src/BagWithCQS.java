/**

 BagCQS.java defines a parameterized interface Bag for the 
 Bag Abstract Data Type that conforms (with one exception)
 to the principle of Command-Query-Separation
 <p>
 The Bag ADT is an unordered collection that allows for
  multiple occurrences of any item.
 <p>
 This interface is closely modeled on Frank Carrano's Bag 
 interface in "Data Structures and Abstractions in Java" 
 (3rd Edition)
  <p>
  <b>Invariants:</b>
  <p>
  if (isEmpty() == true) <br>
   then getCount() == 0 <br>
   else getCount() > 0
  <p>
  if (contains(item) == true)<br>
   then getFrequencyOf(item) > 0 <br>
   else getFrequencyOf(item) == 0	 
  <p>
  <p>
  <b>Creation constraints:</b>
  <p>
  The constructor for any class the implements the Bag ADT
  must create an initially empty bag.<br>
  So, immediately after contruction,<br>
  isEmpty() == true<br>
  AND<br>
  getCount() == 0
  <p>  
  @author J.W. Benham   
 */

public interface BagWithCQS<T> 
{
	
	
  public void add(T item);
	 /**
		 * Adds the specified item to the bag
		 * <p>
		 * <b>pre-condition:</b> NOT isFull()
		 * <p>
		 * <b>post-condition:</b>
	    *  getFrequencyOf(item) ==
		 *  getFrequencyOf(item)@pre + 1  <br>
		 *  AND<br>
		 *  getCount() == getCount()@pre + 1<br>
	    * <p>
		 * @param item -- the item to be added to the bag
		 *                 
		 */                 
 
  public int getCount();
  
  /**
   *  Returns the total number of items in the bag.
   *
   *  @return number of items in the bag (counting duplicates)
   */
    
  public void clear();
  /**
  Removes all items from the bag
  <p>
  <b>pre-condition: none (true)<br>
  <p>post-condition: getCount() == 0
  
 */ 
  /**

  public void remove(T item);
    * Removes one occurrence of the specified item from the 
  *  bag, if there is one
  * <p>
  * <b>pre-condition:</b> EXERCISE
  * <br>
  * <b>post-condition:</b><br> EXERCISE
  * 
  * @param item - the item to be removed
  */

  public T remove();
  /**
  *  Removes an occurrence of an unspecified item from the
  *   bag and returns it.  Returns null if the bag is empty
  *  <p>
  *  <b>pre-condition: NOT isFull() AND Contains(item)</b>
  *  
  *  else  
  *  return null
  *  <br> 
  *  <b>post-condition: getCount==getCount@pre-1
  *;
  *  @return removed item - note that this is a (minor)
  *   violation of command query separation
  */

	  
  public boolean isEmpty();
  /**
  Checks whether the bag is empty
	pre-condition: NOT isEmpty()
  <p>
  
  post-condition: getCount()== getCount()@pre-1
  @return if getCount() == 0 true else false
*/

  public boolean isFull();
  
  /**
    Checks whether the bag is full (i.e., no item can be
     added), false otherwise
    <p>
    @return if bag is full then true else false
  */

  public boolean contains (T item);
  /**
  Checks whether the bag contains an occurrence of
  the specified item
  <p>
  @return if getFrequencyOf(item) > 0 then true else false
*/

  public int getFrequencyOf(T item);
  /**
  Returns the number of occurrences of the specified item
  in the bag
  <p>
  @return the number of occurrences of item in the bag
*/

  public T[] toArray();     
  /**
   * Returns an array version of the bag
   * 
   */
} // interface Bag