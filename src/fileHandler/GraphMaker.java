package fileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class GraphMaker {

	
	BufferedReader rdr = null;
	FileHandler fH = null;
	//Constructor of GraphMaker
	public GraphMaker(String filename) throws FileNotFoundException {
		FileHandler fH = FileHandler.getFileHandler(filename);
		fH.instansiateReader();
		rdr = FileHandler.getBuffReader();
	}
	
	public void createGraph() {
		BufferedReader rd = this.getRdr();
		
		
	}
	
	
	
	
	
	//Getters-Setters
	public BufferedReader getRdr() {
		return rdr;
	}
	public void setRdr(BufferedReader rdr) {
		this.rdr = rdr;
	}
	public FileHandler getfH() {
		return fH;
	}
	public void setfH(FileHandler fH) {
		this.fH = fH;
	}
	
	
	
	
}
