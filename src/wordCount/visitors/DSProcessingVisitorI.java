package wordCount.visitors;

import wordCount.dsForStrings.*;


public class DSProcessingVisitorI implements Visitor{

	private BSTNode root;
	private BST bst1 = null;
	
	
	public void cloneTree(){
		cloneTree(root);
	}
	    
    private void cloneTree(BSTNode r)
    {
        if (r != null)
        {
            BSTNode node1 = (BSTNode) r.clone();
            bst1.insertCloneNode(node1);
            r.registerObserver(node1);
            cloneTree(r.getLeft());             
            cloneTree(r.getRight1());
        }
    }

	@Override
	public void visit(BST bst) {
		bst1 = bst;
		root = bst.getRoot();
		cloneTree();
//		bst.preorder();
	}

}
