package fileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@SuppressWarnings("unused")
public class FileHandler {

	private String filename;
	private static BufferedReader buffReader = null;
	

	// Singleton Model
	private static FileHandler fHandler = null;
	
	private FileHandler(String filename) throws FileNotFoundException {
		File f = new File(filename);
		this.filename = filename;
		
		
	}
	
	public static FileHandler getFileHandler(String filename) throws FileNotFoundException {
		if (fHandler == null) {
			fHandler = new FileHandler(filename);
		}
		return fHandler;
	}

	public void instansiateReader() throws FileNotFoundException {
		FileReader reader = new FileReader(this.filename);
		FileHandler.buffReader = new BufferedReader(reader);
	}

	
	
	
	//Getters-Setters
	public static BufferedReader getBuffReader() {
		return buffReader;
	}

	public static void setBuffReader(BufferedReader buffReader) {
		FileHandler.buffReader = buffReader;
	}


	
	
	
}
