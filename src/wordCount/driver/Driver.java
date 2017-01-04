package wordCount.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.dsForStrings.BST;
import wordCount.util.FileProcessor;
import wordCount.visitors.CloneObserverVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.TetstVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

/**
 * @author Sunil
 *
 */
public class Driver {

	static String inputFile;
	static String outputFile;
	static int NUM_ITERATIONS;
	
	public static void main(String args[]){
		// Argument error handling
				if (args.length != 3) {
					System.out.println("Missing Run time arguments(InputFile/OutputFile/Iteration Count).. Existing Program.");
					System.exit(-1);
				}
				else{
					inputFile = args[0];
					outputFile = args[1];
					NUM_ITERATIONS = Integer.parseInt(args[2]);
					
					if (NUM_ITERATIONS < 1 ){
						System.out.println("NUM_ITERATIONS cannot be less than 1..Existing Program.");
						System.exit(-1);
						}
								
				}
		
		String outCloneFile = "outputClone.txt";
		String outActualFile = "outputActual.txt";
		long avgTime;
		long finishTime=0, startTime=0;
		BST dstree=null;
		FileWriter fw=null, fwClone=null, fwActual=null;

		
		try {

			startTime = System.currentTimeMillis();			
			for (int i =0; i< NUM_ITERATIONS; i++){

				BufferedReader br = new BufferedReader(new FileReader(inputFile));	
				fw = new FileWriter(outputFile);
				fwClone = new FileWriter(outCloneFile);
				fwActual = new FileWriter(outActualFile);
				fw.write("Word count details of text file: " + "\"" + inputFile + "\"" + "\n");
				FileProcessor fileObj= new FileProcessor( fw );
				FileProcessor fileObjTest = new FileProcessor( fwClone );
				FileProcessor fileObjActual = new FileProcessor( fwActual );
				
				fileObj.setBufferObj(br);
	
				dstree = new BST(fileObj, fileObjTest, fileObjActual);
				Visitor populateVisitor = new PopulateVisitor();
				Visitor wordCountVisitor = new WordCountVisitor();
				
				
				dstree.accept(populateVisitor);
				dstree.accept(wordCountVisitor);
				
				br.close();
				fw.close();
				
			}
						
			
			finishTime = System.currentTimeMillis();
			avgTime = (finishTime - startTime)/ NUM_ITERATIONS;
			System.out.println("Avg execution time : "+ avgTime + " ms");
			
			
			Visitor cloneObserverVisitor = new CloneObserverVisitor();
			dstree.accept(cloneObserverVisitor);
			
			// Fourth visitor (Test part)
			
			Visitor testVisitor = new TetstVisitor();
			dstree.accept(testVisitor);
			
			fwClone.close();
			
			
				    
		}
		catch (FileNotFoundException  e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} finally{
			
		}
		

		
	}
	
}
