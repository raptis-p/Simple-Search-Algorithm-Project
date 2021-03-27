package fileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class FileHandler {

	private String filename;
	private  BufferedReader buffReader = null;
	private  BufferedWriter buffWriter = null;

	
	
	public FileHandler(String filename) throws FileNotFoundException {
		File f = new File(filename);
		this.filename = filename;
		
		
	}
	


	public void instansiateReader() throws FileNotFoundException {
		FileReader reader = new FileReader(this.filename);
		this.buffReader = new BufferedReader(reader);
	}

	public void instansiateWriter() throws IOException {
		FileWriter writer = new FileWriter(this.filename);
		this.buffWriter = new BufferedWriter(writer);
	}
	
	
	//Getters-Setters
	public BufferedReader getBuffReader() {
		return buffReader;
	}

	public void setBuffReader(BufferedReader buffReader) {
		this.buffReader = buffReader;
	}



	public BufferedWriter getBuffWriter() {
		return buffWriter;
	}



	public void setBuffWriter(BufferedWriter buffWriter) {
		this.buffWriter = buffWriter;
	}


	
	
	
}
