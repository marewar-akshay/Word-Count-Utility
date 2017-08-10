package wordCount.dsForStrings;

import java.util.ArrayList;

public class BSTNode implements Cloneable, Subject, Observer{
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
    BSTNode left, right;
    String data;
    int count;
    
   
    public BSTNode()
    {
        left = null;
        right = null;
        data = null;
        count = 0;
    }
   
    public BSTNode(String n)
    {
        left = null;
        right = null;
        data = n;
        count++;
    }
   
    /**
     * This function sets the left child.
     * @param n is BST node
     */
    public void setLeft(BSTNode n)
    {
        left = n;
    }
    
    /**
     * This function sets the right child.
     * @param n is BST node
     */
    public void setRight(BSTNode n)
    {
        right = n;
    }
   
    /**
     * this method return the left node.
     * @return the BST node
     */
    public BSTNode getLeft()
    {
        return left;
    }
   
    /**
     * this method return the right node.
     * @return the BST node
     */
    public BSTNode getRight1()
    {
        return right;
    }
   
    /**
     * This method sets the String in data structure
     * @param d is the word from file 
     */
    public void setData(String d)
    {
        data = d;
    }
   
    /**
     * This method get the String from data structure
     * @param d is the word from file 
     */
    public String getData()
    {
        return data;
    }

	/**
	 * this function gets the word count.
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * this method sets the word count.
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}  
    
	
	/* this method clone the node.
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone(){
			BSTNode node = new BSTNode();
			node.data = this.data;
			node.count = this.count;
			return node;
	}

	/**
	 * This method update the count of observer node word
	 * @param countIn count of the word. 
	 */
	@Override
	public void update(int countIn) {
		this.count = countIn;
	}

	/**
	 * This method register the observer into arraylist
	 * @param observer is the node.
	 */
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);	
	}

	/**
	 * This method remove the observer into arraylist
	 * @param observer is the node.
	 */
	@Override
	public void removeObserver(Observer observer) {
		 observers.remove(observer);
		
	}

	/**
	 * this method notify that original data structure has changed
	 */
	@Override
	public void notifyObservers() {
		for (Observer ob : observers) {
            ob.update(this.count);
     }
		
	}
    
}
