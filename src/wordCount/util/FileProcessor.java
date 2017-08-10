package wordCount.util;


import java.io.*;

public class FileProcessor {

	private static String InputFile, inputFile1;
	private static String OutputFile;
	private static FileWriter filewriter = null, fileWriter1 = null, fileWriter2= null;
	private static BufferedWriter p = null, p1 = null, p2= null;
	private static File file = null, file1 = null, file2 = null;
	private static BufferedReader br = null;
	private static String outfilename1;
	private static String outfilename2;
	
	public FileProcessor(String inputfile2) {
		inputFile1 = inputfile2;
		try {
			br = new BufferedReader(new FileReader(inputFile1));
		}
		catch(Exception e) {
			System.err.println("ERROR: input file not present");
			System.exit(1);
		}
	}
	
	public FileProcessor(String FileNameIn,String outfileIn){
		InputFile = FileNameIn;
		OutputFile = outfileIn;
		try {
			br = new BufferedReader(new FileReader(InputFile));
		}
		catch(Exception e) {
			System.err.println("ERROR: input file not present");
			System.exit(1);
		}
		
		try {
			file = new File(OutputFile);
			filewriter = new FileWriter(file);
			p = new BufferedWriter(filewriter);
		} catch (IOException e) {
			System.err.println("ERROR: error in creating file.");
			System.exit(1);
		}
	
	}
	
	public FileProcessor(String inputfile, String filename1, String filename2){
		outfilename1 = filename1;
		outfilename2 = filename2;
		try {
			file1 = new File(outfilename1);
			fileWriter1 = new FileWriter(file1);
			p1 = new BufferedWriter(fileWriter1);
		} catch (IOException e) {
			System.err.println("ERROR: error in creating file.");
			System.exit(1);
		}
		
		try {
			file2 = new File(outfilename2);
			fileWriter2 = new FileWriter(file2);
			p2 = new BufferedWriter(fileWriter2);
		} catch (IOException e) {
			System.err.println("ERROR: error in creating file.");
			System.exit(1);
		}
		
	}
	

	

	public String Read(){
	    try {
			return br.readLine();
		}  catch (IOException e) {
			System.err.println("ERROR: error in reading file.");
			System.exit(1);
		}
		return null;
	}
	
	public void write(String line){
		try {
			p.write(line);
			p.newLine();

		}  catch (IOException e) {
			System.err.println("ERROR: error in writing file.");
			System.exit(1);
		}
		
	}

	public void write1(String line){
		try {
			p1.write(line);
			p1.newLine();

		}  catch (IOException e) {
			System.err.println("ERROR: error in writing file.");
			System.exit(1);
		}
		
	}

	public void write2(String line){
		try {
			p2.write(line);
			p2.newLine();

		}  catch (IOException e) {
			System.err.println("ERROR: error in writing file.");
			System.exit(1);
		}
		
	}

	
	public void closeFile(){
		try {
			p.flush();
			p.close();
		}  catch (IOException e) {
			System.err.println("ERROR: error in closing file.");
			System.exit(1);
		}
	}
	
	public void closeFile1(){
		try {
			p1.flush();
			p1.close();
		}  catch (IOException e) {
			System.err.println("ERROR: error in closing file.");
			System.exit(1);
		}
	}
	public void closeFile2(){
		try {
			p2.flush();
			p2.close();
		}  catch (IOException e) {
			System.err.println("ERROR: error in closing file.");
			System.exit(1);
		}
	}
	
}
