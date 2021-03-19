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
		
		Node n1,n2;
		int daysCount = 0, t;
		String rn;
		
		
		while ((line=rdr.readLine() )!=null)  {	
			
			String[] data= line.split("[><;]");
			//System.out.println(data[1]);
			switch(data[1]) {
			
			case "Source" :
				g.addNode(new Node(data[2], true, false,g));
				break;
			case "Destination" :
				g.addNode(new Node(data[2], false, true,g));
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
					n1 = new Node(data[1],g);
					n2 = new Node(data[2],g);
					
					Edge e = new Edge(data[0],n1,n2,data[3]); 

					g.addNode(n1);
					g.addNode(n2);
					

					
					g.addAdjNode(n1, n2);
					
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
			
//			case "Predictions" :  //predictions reading per day
//				
//				isPredictions= true;
//				int daysCount=1;
//				String d;
//				while (isPredictions) {
//					
//					while (!line.equals("/Day")) {
//						System.out.println(line);
//						d = "Day" + Integer.toString(daysCount);
//						System.out.println(d);
//					}
//					
//				
//					if (data[1].equals("/Predictions")) {
//						isPredictions = false;
//					}
//			}
//				break;
//			case "ActualTrafficPerDay" :  //actual traffic reading per day
//				isTraffic= true;
//		
//				while (isTraffic) {
//				
//				
//					if (data[1].equals("/ActualTrafficPerDay")) {
//						isTraffic = false;
//					}
//			}
//				break;
//		}
//	
//	}
//		return g;
//	}
	
	
	
	
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
