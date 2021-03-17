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
		boolean isRoads = false,isPredictions = false ,isTraffic = false,isDay = false;
		
		String line;
		String d_temp = "Day";
		Node n1,n2;
		int daysCount = 1;
		
		while ((line=rdr.readLine() )!=null)  {	
			
			String[] data= line.split("[><;]");
			//System.out.println(data[1]);
			switch(data[1]) {
			
			case "Source" :
				g.addNode(new Node(data[2], true, false));
				break;
			case "Destination" :
				g.addNode(new Node(data[2], false, true));
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
				break;
			case "/ActualTrafficPerDay" :
				isTraffic = false;
				break;

			case "Day" :   //start roads reading
				isDay=true;
				break;
			case "/Day" : 
				isDay = false;
				d_temp += Integer.toString(daysCount);
				daysCount++;
				break;
			default :
				
				if (isRoads) {
					n1 = new Node(data[1]);
					n2 = new Node(data[2]);
					
					Edge e = new Edge(data[0],n1,n2,data[3]); 
					
					g.addNode(n1);
					g.addNode(n2);
					
					g.addAdjNode(n1, n2);
					
					g.addEdge(e);
					
				}
				else if (isPredictions) {
					
				}
				else if (isTraffic) {
					
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
