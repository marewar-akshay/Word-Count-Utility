package wordCount.visitors;

import wordCount.dsForStrings.*;
import wordCount.util.*;

public class DSProcessingVisitorII implements Visitor{

	private FileProcessor F;
	private String inputfile;
	private String firstfile;
	private String secondfile;
	private BSTNode root = null;
	
	/**
	 * This is constructor which sets the filename.
	 * @param infile is input file name
	 * @param firstfile is first file name
	 * @param secondfile is second file name
	 */
	public DSProcessingVisitorII(String infileIn, String firstfileIn, String secondfileIn) {
		super();
		inputfile = infileIn;
		firstfile = firstfileIn;
		secondfile = secondfileIn;
		F = new FileProcessor(inputfile, firstfile, secondfile);
	}

	public void updateTreeCount(int count){
	       updateCount(root,count);		
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

	/**
	 * This method shows that observer pattern is working 
	 * @param bst is the BST data structure.
	 */
	@Override
	public void visit(BST bst) {
		root = bst.getRoot();
		
		updateTreeCount(1);
//		bst.updateCount(1);
		bst.displayFirstTree(F);
		bst.displaySecondTree(F);
	}

}
