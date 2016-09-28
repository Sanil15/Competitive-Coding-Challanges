package com.codetest.main;
import java.io.*;
import java.util.ArrayList;;

public class JavaIO {

	// Function will take name of file that is path and 
	// read the text file and return ArrayList<String> with 
	// its element as every new line in the fileName 
	public ArrayList<String> readInput(String fileName) {

		ArrayList<String> inputList=new ArrayList<String>();
        
		// This will reference one line at a time
		// and add it to inputList
        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                inputList.add(line);
            }   

            bufferedReader.close();
 
        }
        catch(FileNotFoundException ex) {
        		ex.printStackTrace();               
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
        
        return inputList;
    }
	
	// Function appends the content paramaeter to the end of a file 
	// output.txt
	public void writeOutput(String content){
		
		// The name of the file to open.
        String fileName = "output.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.newLine();// append a newline character
            bufferedWriter.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
	
}
          

	

