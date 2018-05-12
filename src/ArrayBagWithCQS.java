/**
ArrayBag is a class that implements the Bag ADT using an array to 
hold the items in the bag
<p>
@author Alex Torres
<p>
Closely follows the array implemenation from  Frank M. 
Carrano's "Data Structures and abstractions with Java" 
(Third Edition)
*/

public class ArrayBagWithCQS<T> extends AbstractGuessingGame<T> implements BagWithCQS<T>
{
  private T[] bagItems;  // Array to hold items in bag
  
  private int itemCount, // Number of items in the bag
              capacity;  // Length of array
				  
  @SuppressWarnings("unused")
private static int DEFAULT_CAPACITY = 50;
    // Default capacity can be overridden by constructor 
	 
  /**
   Construct a bag with a specified maximum number of 
   items<br>
	The constructed bag will initially be empty
	<p>
	@param capacity - maximum number of items that fit 
   into bag
  */
  public ArrayBagWithCQS(int capacity, int maxValue, int numOfGuessesAllowed )
  {
	 super(capacity, maxValue, numOfGuessesAllowed);
     this.capacity = capacity;
     @SuppressWarnings("unchecked")
     T[] tempItems = (T[]) new Object[capacity];
	  bagItems = tempItems;
   
	  itemCount = 0; 	// bag is initially empty
  }
  
  /**
   Construct bag with the default capacity
  */
  
  // Removes all items from bag
  public void clear()
  {
    // Change no-longer used references to null
    //  for garbage collection
    for (int i = 0; i < itemCount; i++)
      bagItems[i] = null;
      
    itemCount = 0;
  }

  // Adds specified item to bag if not full
  public void add(T item) //2
  {
    if (isFull())
	 {
    	
	 }
	 else
	 {
	   bagItems[itemCount] = item;
		itemCount++;
	
	 }
  }  
  
  // Removes specified item from bag
  // T(n) is O(n) - worst case
  public void remove(T item) // instructor
  {   
    int itemIndex = getIndexOf(item);
    
    if(itemIndex != -1) {
      itemCount--;
      bagItems[itemIndex] = bagItems[itemCount];
      bagItems[itemCount] = null;
      
    }  
     
  }
  
  // Removes an unspecified item from bag
  public T remove()
  {
    if(!isEmpty())
    {
      itemCount--;
      T removedItem = bagItems[itemCount];
      bagItems[itemCount] = null;
      return removedItem;
    }
    else
      return null;
  } 
  
  // Returns number of items in bag
  public int getCount()
  {
    return itemCount;
  }
  
  // Returns true iff the number of items is 0
  public boolean isEmpty()
  {
    return itemCount == 0;
  }
  
  // Returns true iff the bag is filled to capacity
  public boolean isFull()
  {
	  if ( itemCount == capacity){
		  return true;
	  }
	  else{
		return false;  
	  }
	  
  }
  
  // Returns true if the bag contains an occurrence of item
  public boolean contains (T item)
  {
    // Use getIndexOf to determine if item is present
    if(getIndexOf(item) != -1)
      return true;
    else
      return false;
  }

  // Returns number of occurrences of specified item
  public int getFrequencyOf(T item)
  {
    int counter = 0;  // number of occurrences of item
    
    // Traverse array, incrementing counter for each occurrence
    for(int index = 0; index < itemCount; index++)
    {
      if(bagItems[index].equals(item))
        counter++;
    }
    
    return counter;
  }
  
  public T[] toArray()
  {     
     /* Returning the array bagItems directly would allow 
         outside access to a private attribute.  (Also, unless
         the bag is full, the array bagItems will have more slots
         than items, contrary to the specs for this operation) 
        So we need to construct a new array
     */
        
     @SuppressWarnings("unchecked")
     T[] returnArray = (T[]) new Object[bagItems.length];
     
     for (int i = 0; i < bagItems.length; i++){
       returnArray[i] = bagItems[i];
     }
      
     return returnArray;     
  }
  
  // Returns index of the specified item
  // Returns -1 if the bag contains no occurrences of item
  // Used in contains and remove(item)
  // Worst case time complexity is O(n)
  private int getIndexOf(T item) //instructor
  { 
    int index = itemCount-1;
    
    /* Traversing the array backwards so that index
       will automatically reach -1 if the item is not found.
    */
    while (index >= 0 && !bagItems[index].equals(item))
      index--;
      
    return index; 
  }


}
