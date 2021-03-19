package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import graph.Edge;

public class Graph {

	
	private Map<Node, List <Node>> adjNodes;
	private List<Edge> edgesList;

	
	

	private Map<Integer,List<Prediction>> predictions = new HashMap<Integer,List<Prediction>>(); ;//day at index, list of predictions in list
	private Map<Integer,List<ActualTraffic>> actualTraffic = new HashMap<Integer,List<ActualTraffic>>(); // either map or class ActualTraffic !!!!!!!!!

	//Constructor
	public Graph() {
		adjNodes= new HashMap<Node, List <Node>>();
		setEdgesList(new ArrayList<Edge>());
	}
	
	
	
	public void addEdge(Edge e) {
		if (!edgesList.contains(e)) {
			edgesList.add(e);
		}
	}
	
	
	public void addNode(Node n) {
		boolean flag=false;
		for (Node n1:this.adjNodes.keySet()) {
			if(n1.getName().equals(n.getName())) {
				flag=true;
			}
		}
		if(flag==false) {
			this.adjNodes.put(n, new ArrayList<Node>());
		}else {
		}
		
		
	}
	
	
	public void addAdjNode(Node n1, Node n2) {		
		boolean flag=false;
		
		for (Node list:this.adjNodes.keySet()) {
			if(n1.getName().equals(list.getName())) {
				flag=true;
				this.adjNodes.get(list).add(n2) ;
			}			
		}
				
	}
		
		
//		if(flag==false) {
//			this.adjNodes.get(list).add(n2) ;
//		}

	public void initDayPred(int day) {
		this.predictions.put(day, new ArrayList<Prediction>());
	}
	
	public void addPrediction(int day, String rn, int tr) {
		

		
		for (int d : this.predictions.keySet()) {
			if(day == d) {
				
				this.predictions.get(d).add(new Prediction(rn, tr)) ;
			}			
		}
		

		
	}
	
	
	public void initDayTraffic(int day) {
		this.actualTraffic.put(day, new ArrayList<ActualTraffic>());
	}
	
	
	
	public void addTraffic(int day, String rn, int tr) {
		

		
		for (int d : this.actualTraffic.keySet()) {
			if(day == d) {
				
				this.actualTraffic.get(d).add(new ActualTraffic(rn, tr)) ;
			}			
		}
		

		
	}
	
	
	//Setters-Getters
	public Map<Node, List<Node>> getAdjNodes() {
		return adjNodes;
	}


	public void setAdjNodes(Map<Node, List<Node>> adjNodes) {
		this.adjNodes = adjNodes;
	}



	public List<Edge> getEdgesList() {
		return edgesList;
	}



	public void setEdgesList(List<Edge> edgesList) {
		this.edgesList = edgesList;
	}

	public Map<Integer, List<Prediction>> getPredictions() {
		return predictions;
	}



	public void setPredictions(Map<Integer, List<Prediction>> predictions) {
		this.predictions = predictions;
	}



	public Map<Integer, List<ActualTraffic>> getActualTraffic() {
		return actualTraffic;
	}



	public void setActualTraffic(Map<Integer, List<ActualTraffic>> actualTraffic) {
		this.actualTraffic = actualTraffic;
	}


	
	
}
