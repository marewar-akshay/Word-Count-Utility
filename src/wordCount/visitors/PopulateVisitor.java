package wordCount.visitors;

import wordCount.dsForStrings.*;
//import wordCount.util.*;
import wordCount.util.FileProcessor;

public class PopulateVisitor implements Visitor{

	private FileProcessor F;
	private String inputfile;
	
	
	
	public PopulateVisitor(String inputfileIn) {
		super();
		inputfile = inputfileIn;
		F = new FileProcessor(inputfile);
	}
	
	@Override
	public void visit(BST bst) {
		String line = F.Read();
		while(line!=null)
		{
			String[] array = line.split(" +");
			
			for(int i=0;i<array.length;i++){
				if(array[i].length() > 0)
				{
					bst.insert(array[i]);
				}
			}
			line = F.Read();
		}
	}

}
