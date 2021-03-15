package fileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class GraphMaker {

	
	BufferedReader rdr = null;
	FileHandler fH = null;
	//Constructor of Graph
	public GraphMaker(String filename) throws FileNotFoundException {
		FileHandler fH = FileHandler.getFileHandler(filename);
		fH.instansiateReader();
		rdr = FileHandler.getBuffReader();
	}
	
	
	
}
