package wordCount.util;
 
public class ArgumentException extends Exception
{
	private String expName;
	public ArgumentException(String expNameIn)
	{
		expName=expNameIn;
	}
	
	public String getExpName()
	{
		return expName;
	}
}