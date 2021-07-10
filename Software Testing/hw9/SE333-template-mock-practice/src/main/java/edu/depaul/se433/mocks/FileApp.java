package edu.depaul.se433.mocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Demonstrate how the FileMonitor works
 */
public class FileApp {

	public static void main(String[] args) throws FileNotFoundException {
	    try (PrintWriter writer = new PrintWriter(new File("./junk0510b.tmp"))) {  
	    	writer.write("Testing...");                                                   
	    	writer.flush(); 
	    }
	     
		FileService fs = new FileService();
		FileMonitor monitor = new FileMonitor(fs);
		monitor.clean(".");
		
		System.out.println("first clean finished, starting second clean");
		
		monitor.clean(".");

	}

}
