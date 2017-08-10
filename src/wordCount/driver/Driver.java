package wordCount.driver;

import wordCount.util.*;
import wordCount.visitors.*;
import wordCount.dsForStrings.*;

public class Driver {

	private static BST bst= null;
	
	public static void main(String[] args) {
		try{
			if(!(args.length == 5))
			{
				throw new ArgumentException("Exception::Invalid Number of Arguments!");
			}
			
			int iteration = Integer.parseInt(args[4]);
			final long startTime = System.currentTimeMillis();
			for(int i=0;i<iteration;i++){
				bst = new BST();
				Visitor PV = new PopulateVisitor(args[0]);
				bst.accept(PV);
				WordCountVisitor WCV = new WordCountVisitor(args[0], args[1]);
				bst.accept(WCV);
			}
			final long finishTime = System.currentTimeMillis();
			System.out.println("Total time: " + (finishTime - startTime)/iteration);
			DSProcessingVisitorI DSP = new DSProcessingVisitorI();
			bst.accept(DSP);
			DSProcessingVisitorII DSP1 = new DSProcessingVisitorII(args[0], args[2], args[3]);
			bst.accept(DSP1);
			
		}
		catch(ArgumentException e){
			System.err.println(e.getExpName());
			System.exit(1);
		}
	
	}
}
