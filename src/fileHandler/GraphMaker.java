package fileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class GraphMaker {

	
	BufferedReader rdr = null;
	FileHandler fH = null;
	//Constructor of GraphMaker
	public GraphMaker(String filename) throws FileNotFoundException {
		FileHandler fH = FileHandler.getFileHandler(filename);
		fH.instansiateReader();
		rdr = FileHandler.getBuffReader();
	}
	
	public Graph createGraph() throws IOException {
		Graph g = new Graph();
		boolean isRoads,isPredictions,isTraffic = false;
		
		String line;
		
		while ((line=rdr.readLine() )!=null)  {	
			
			String[] data= line.split("[><;]");
			
			switch(data[1]) {
			
			case "Source" :
				g.addNode(new Node(data[2], true, false));
			case "Destination" :
				g.addNode(new Node(data[2], false, true));
			case "Roads" :   //start roads reading
				isRoads=true;
				while (isRoads) {
					//read roads
					Edge e = new Edge(data[0],new Node(data[1]),new Node(data[2]),data[3]);
					g.addNode(new Node(data[1]));
					g.addNode(new Node(data[2]));
					g.addEdge(e);
					
					if (data[1].equals("/Roads")) {
						isRoads = false;
					}
				}
			case "Predictions" :  //predictions reading per day
				isPredictions= true;
		
				while (isPredictions) {
				
				
					if (data[1].equals("/Predictions")) {
						isPredictions = false;
					}
			}
			case "ActualTrafficPerDay" :  //actual traffic reading per day
				isTraffic= true;
		
				while (isTraffic) {
				
				
					if (data[1].equals("/ActualTrafficPerDay")) {
						isTraffic = false;
					}
			}
			
		}
	
	}
		return g;
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
