package wordCount.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	private BufferedReader bufferObj;
	private String modLine; 
	private FileWriter fw;
	
	public FileProcessor(FileWriter fwIn){
		fw = fwIn;				
		Logger.writeMessage("Logger: In File Processor Constructor:", Logger.DebugLevel.CONSTRUCTOR);

	}
	
	public BufferedReader getBufferObj() {
		return bufferObj;
	}

	public void setBufferObj(BufferedReader bufferObj) {
		this.bufferObj = bufferObj;
	}
	
	
	/**
	 * @param str String to write to file
	 */
	public void writeToFile(String str){
		try {
			fw.write(str);
					
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	

	/**
	 * @return String that contains the students course preference
	 * @throws IOException
	 */
	public String hasLine() throws IOException {

		modLine = bufferObj.readLine();
		//System.out.println(modLine);

		if (modLine != null){
			modLine = modLine.replaceAll("\\s+", " ");
			}
		
		else
			modLine = null; 
		
		return modLine;
	}
	
	



}
