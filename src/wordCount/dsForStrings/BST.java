package wordCount.dsForStrings;

import wordCount.util.FileProcessor;
import wordCount.visitors.Visitor;

public class BST
{
	private BSTNode root, root1;

    public BST()
    {
        root = null;
        root1 = null;
    }
  
    public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public BSTNode getRoot1() {
		return root1;
	}

	public void setRoot1(BSTNode root1) {
		this.root1 = root1;
	}

	public void accept(Visitor visitor){
		visitor.visit(this);
	}
	  
    public void insert(String data)
    {
        root = insert(root, data);
    }
  
    private BSTNode insert(BSTNode node, String data)
    {
        if (node == null)
            node = new BSTNode(data);
        else
        {
            if (data.compareTo(node.getData()) < 0)
                node.left = insert(node.left, data);
            else if (data.compareTo(node.getData()) > 0)
                node.right = insert(node.right, data);
            else if (data.compareTo(node.getData()) == 0)
            	node.count++;
        }
        return node;
    }
  
    public void insertCloneNode(BSTNode node)
    {
        root1 = insert1(root1, node);
    }
  
    private BSTNode insert1(BSTNode node1, BSTNode node2)
    {
        if (node1 == null)
            node1 = node2;
        else
        {
            if (node2.getData().compareTo(node1.getData()) < 0)
                node1.left = insert1(node1.left, node2);
            else if (node2.getData().compareTo(node1.getData()) > 0)
                node1.right = insert1(node1.right, node2);
            
        }
        return node1;
    }
  
    
/*    public String inorder()
    {
       dCCount = inorder(root);
       return dCCount;
    }
    
    private String inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            dCount += r.getCount();
            nodes++;
//            tChar += (r.getData().length() * r.getCount());
            tChar += r.getData().length();
            inorder(r.getRight1());
            return Integer.toString(nodes)+" "+Integer.toString(dCount)+" "+Integer.toString(tChar);
        }
		return Integer.toString(nodes)+" "+Integer.toString(dCount)+" "+Integer.toString(tChar) ;
        
    }
    

    public void preorder()
    {
        preorder(root);
    }
    
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            BSTNode node1 = (BSTNode) r.clone();
            insertCloneNode(node1);
            r.registerObserver(node1);
            preorder(r.getLeft());             
            preorder(r.getRight1());
        }
    }
*/
    
/*    public String inorder1()
    {
       dCCount1 = inorder1(root1);
       return dCCount1;
    }
    
    private String inorder1(BSTNode r)
    {
        if (r != null)
        {
            inorder1(r.getLeft());
            dCount1 += r.getCount();
            nodes1++;
            tChar1 += r.getData().length();
            inorder1(r.getRight1());
            return Integer.toString(nodes1)+" "+Integer.toString(dCount1)+" "+Integer.toString(tChar1);
        }
		return Integer.toString(nodes)+" "+Integer.toString(dCount)+" "+Integer.toString(tChar) ;
        
    }
*/
/*    public void updateCount(int countIn)
    {
       updateCount(root,countIn);
       
    }
    
    private void updateCount(BSTNode r, int countIn)
    {
        if (r != null)
        {
            updateCount(r.getLeft(), countIn);
            r.setCount(r.getCount()+countIn);
            r.notifyObservers();
            updateCount(r.getRight1(), countIn);
            
        }
		 
    }
*/    
    public void displayFirstTree(FileProcessor F){
    	displayFirstTree(root, F);
    	F.closeFile1();
    }
    
    public void displayFirstTree(BSTNode r, FileProcessor F){
    	if(r != null){
	    	displayFirstTree(r.getLeft(), F);
	    	F.write1(r.getData()+" "+Integer.toString(r.getCount()));
	    	displayFirstTree(r.getRight1(), F);
    	}
    }
    
    
    public void displaySecondTree(FileProcessor F){
    	displaySecondTree(root1, F);
    	F.closeFile2();
    }
    
    public void displaySecondTree(BSTNode r, FileProcessor F){
    	if(r != null){
	    	displaySecondTree(r.getLeft(), F);
	    	F.write2(r.getData()+" "+Integer.toString(r.getCount()));
	    	displaySecondTree(r.getRight1(), F);
    	}
    }
    
}
