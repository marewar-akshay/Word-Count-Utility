package wordCount.visitors;

import wordCount.dsForStrings.*;
import wordCount.util.*;

public class WordCountVisitor implements Visitor{

	private FileProcessor F;
	private String inputfile;
	private String outfile;
	private BSTNode root = null;
    private int dCount = 0;
    private int tChar = 0;
    private int nodes = 0;
 
	
	
	public WordCountVisitor(String inputfileIn, String outfileIn) {
		super();
		inputfile = inputfileIn;
		outfile = outfileIn;
		F = new FileProcessor(inputfile, outfile);
	}


	public String countWords(){
		return countWords(root);
	}
	
	private String countWords(BSTNode r) {
		if (r != null)
        {
            countWords(r.getLeft());
            dCount += r.getCount();
            nodes++;
//            tChar += (r.getData().length() * r.getCount());
            tChar += r.getData().length();
            countWords(r.getRight1());
            return Integer.toString(nodes)+" "+Integer.toString(dCount)+" "+Integer.toString(tChar);
        }
		return Integer.toString(nodes)+" "+Integer.toString(dCount)+" "+Integer.toString(tChar) ;
	}


	@Override
	public void visit(BST bst) {
		root = bst.getRoot();
		String str = countWords();
		String[] count = str.split(" ");
		F.write("No of distinct words: " + count[0]);
		F.write("No of words: " + count[1]);
		F.write("No of characters: " + count[2]);
		F.closeFile();
	}

}
