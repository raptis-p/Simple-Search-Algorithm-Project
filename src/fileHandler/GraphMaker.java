package fileHandler;

import graph.Edge;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graph.Graph;
import graph.Node;
import graph.Prediction;

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
		boolean isRoads = false,isPredictions = false ,isTraffic = false,isDay = false;
		
		String line;
		
		
		int daysCount = 0, t;
		String rn;
		
		
		while ((line=rdr.readLine() )!=null)  {	
			Node n1 = new Node(),n2 =new Node();
			String[] data= line.split("[><;]");
			//System.out.println(data[1]);
			switch(data[1]) {
			
			case "Source" :
				Node src = new Node(data[2],true,false,g);
				g.setSrcNode(src);
				g.addNode(src);
				break;
			case "Destination" :
				
				g.setDestNode(new Node(data[2], false, true,g));
				g.addNode(g.getDestNode());
				break;
			case "Roads" :   //start roads reading
				isRoads=true;
				break;
			case "/Roads" : 
				isRoads = false;
				break;
			case "Predictions" : 
				isPredictions = true;
				break;
			case "/Predictions" :
				isPredictions = false;
				break;
			case "ActualTrafficPerDay" : 
				isTraffic = true;
				daysCount=0;
				//System.out.println("INTO ACTUAL TRAFFIC");
				break;
			case "/ActualTrafficPerDay" :
				
				isTraffic = false;
				break;

			case "Day" :   //start roads reading
				if (isPredictions == true) {
				g.initDayPred(daysCount);
				} else {
				g.initDayTraffic(daysCount);
				}
				isDay=true;
				break;
			case "/Day" : 
				isDay = false;
				
				daysCount++;
				break;
			default :
//				System.out.printf("%b \t %b\n" ,isTraffic, isPredictions);
				if (isRoads) {
					
					//kathe fora ginontai new node, prepei an iparxei idi to node apla na vazoyme sto addneigbors aytou oxi na kanoyme new node kai na ta vazoyme ekei
					
					n1 = new Node(data[1],g);
					n2 = new Node(data[2],g);
					g.addNode(n1);
					g.addNode(n2);
//					n1.addNeighbor(n2);
//					n2.addNeighbor(n1);

					Edge e = new Edge(data[0],n1,n2,Double.parseDouble(data[3]));
					g.addEdge(e);
					
				}
				else if (isPredictions) {
					rn = data[0];
					if (data[1].equals(" low")) {
						t = -1;
					}
					else if (data[1].equals(" normal")) {
						t = 0;
					} else {
						t= 1;
					}
					g.addPrediction(daysCount, rn, t);
					
					
				}
				else if (isTraffic) {
					
					rn = data[0];
					if (data[1].equals(" low")) {
						t = -1;
					}
					else if (data[1].equals(" normal")) {
						t = 0;
					} else {
						t= 1;
					}
					//System.out.println(daysCount);
					g.addTraffic(daysCount, rn, t);
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
