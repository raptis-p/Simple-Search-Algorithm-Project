package fileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class GraphMaker {

	
	BufferedReader rdr = null;
	FileHandler fH = null;
	
	private Map<String, String[]>  predictions; //String day to String[roadname,traffic] or String roadname to String [day,traffic]
	private Map<String, String[]>  actualTraffic; //same logic as above
	
	
	//Constructor of GraphMaker
	public GraphMaker(String filename) throws FileNotFoundException {
		FileHandler fH = FileHandler.getFileHandler(filename);
		fH.instansiateReader();
		rdr = FileHandler.getBuffReader();
	}
	
	
	public Graph createGraph() throws IOException {
		Graph g = new Graph();
		boolean isRoads = false,isPredictions = false ,isTraffic = false;
		
		String line;
		
		while ((line=rdr.readLine() )!=null)  {	
			
			String[] data= line.split("[><;]");
			
			switch(data[1]) {
			
			case "Source" :
				g.addNode(new Node(data[2], true, false));
				
				break;
			case "Destination" :
				g.addNode(new Node(data[2], false, true));
				
				break;
			case "Roads" :   //start roads reading
				
				isRoads=true;
				while (isRoads) {
					//read roads
					System.out.println(data[0]);
					System.out.println(data[1]);
					System.out.println(data[2]);
					System.out.println(data[3]);
					
					Edge e = new Edge(data[0],new Node(data[1]),new Node(data[2]),data[3]); //not working
					
					g.addNode(new Node(data[1]));
					g.addNode(new Node(data[2]));
					g.addEdge(e);
					
					if (data[1].equals("/Roads")) {
						isRoads = false;
					}
				}
				
				break;
			case "Predictions" :  //predictions reading per day
				isPredictions= true;
		
				while (isPredictions) {
					
				
					if (data[1].equals("/Predictions")) {
						isPredictions = false;
					}
			}
				break;
			case "ActualTrafficPerDay" :  //actual traffic reading per day
				isTraffic= true;
		
				while (isTraffic) {
				
				
					if (data[1].equals("/ActualTrafficPerDay")) {
						isTraffic = false;
					}
			}
				break;
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
