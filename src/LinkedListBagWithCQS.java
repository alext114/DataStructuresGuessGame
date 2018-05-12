

/**
*
*  LinkedListBag<T> is an implementation of the parameterized ADT Bag<T> 
*  using a linked list to hold the items in the bag.
*  <p>
*  This version uses and empty head node to simplify some operations
*  <p>
*  This implementation uses a version of the Bag ADT interface that
*  conforms to the interface in "Data Structures and Algorithms in Java"
*  by Frank M. Carrano.  
*  <p>
*  @author Alex Torres
*/
 
public class LinkedListBagWithCQS<T> extends AbstractGuessingGame<T> implements BagWithCQS<T>
{

  // Inner class for nodes of linked list
  class Node
  {
     private T item;		   // the item held by the node
	  private Node next;    // reference to next node in chain
	  
	  
	  // Constructor with both data value and link to next node
	  public Node(T data, Node link){
	     item = data;
		  next = link;
	  }
	  
	  // Constructor with data value -- no next node (end of list)
	  public Node(T data) {
	     this(data,null);
	  }
	  
	  // set and get methods
	  public void setData(T data)    { item = data; }
	  public void setNext(Node nxt)  { next = nxt;  }
	  public T getData()             { return item; }	 
	  public Node getNext()          { return next; }
     
	}// end of inner class Node
	
	private Node headNode;	/* Reference to an empty head node
                              that precedes the first content
                              node of the linked list
									*/
                           
	private int  itemCount; // Number of items in bag
	
	/**
	  Constructor creates empty bag
	*/
	public LinkedListBagWithCQS(int numOfValues,int maxValue, int numOfGuessesAllowed)
	{
      // Create empty head node
		 super(numOfValues, maxValue, numOfGuessesAllowed);
		
	   headNode = new Node(null,null);
	   
		itemCount = 0;
   }
	
   //Removes all items from bag
	public void clear()
	{
      headNode.setNext(null);
      // This makes the entire linked list into garbage for collection  
   }
	
   //Adds specified item to bag
	public void add(T item)
	{
     Node addNode = new Node(item,headNode.getNext());
     headNode.setNext(addNode);
     itemCount++;
   
	} 
	
   //Removes one occurrence of specified item
	public void remove(T item)
   {
      Node prevNode = findNode(item);
      Node nodeToRemove = prevNode.getNext();
      
      if(nodeToRemove == null){
        // item not in bag
      }
      else
      {
         prevNode.setNext(nodeToRemove.getNext());
    
       }
	}
	
   //Removes an unspecified item
	public T remove()
	{
     T returnItem = null;
       // to be changed if bag isn't empty
     Node firstNode = headNode.getNext();
       // Node to remove (null if empty)
     
     if(firstNode != null)
     {
        // There's a node to remove
        returnItem = firstNode.getData();
        headNode.setNext(firstNode.getNext());
     }
     
     return returnItem;
	}
	
   //Returns number of items in bag
	public int getCount()
	{
		return itemCount;
	}
	
   //Returns true iff the bag is empty
	public boolean isEmpty()
	{
     return headNode.getNext() == null;
	}
	
   //Returns false in all cases since a linked-list bag cannot be full
	public boolean isFull()
	{
	   return false;
	}
	
   //Returns true iff the bag contains an occurrence of specified item
	public boolean contains(T item)
	{
      Node prevNode = findNode(item);
      
      if (prevNode.getNext() != null)
        return true;
      else
        return false;
   }              
	
   //Returns the number of occurrences of specified item
	public int getFrequencyOf(T item)
   {
     int count = 0;
     Node currentNode = headNode.getNext();
     
     while (currentNode != null) {
       if(currentNode.getData().equals(item))
         count++;
     }
     return count;
     
   }
	
   //Returns array containing items in bag (including duplicates)
	public T[] toArray()
	{
	   @SuppressWarnings("unchecked")
	   T[] result = (T[]) new Object[itemCount];

      Node currentNode = headNode.getNext();
      int currentIndex=0;
      while (currentNode != null){      
        result[currentIndex] = currentNode.getData();
        currentIndex++;
        currentNode = currentNode.getNext();
      }
      
      return result;
  }
  
  // Returns node PRECEDING the node containing specified item
  private Node findNode(T item)
  {
      Node prevNode = headNode;
      
      while(prevNode.getNext() != null && !prevNode.getNext().getData().equals(item))
        prevNode = prevNode.getNext();
        
      return prevNode;  
  }


}