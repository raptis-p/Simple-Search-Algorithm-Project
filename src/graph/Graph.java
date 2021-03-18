package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {

	
	private Map<Node, List <Node>> adjNodes;
	private List<Edge> edgesList;


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
			if(n1.equals(n)) {
				flag=true;
			}
		}
		if(flag==false) {
			this.adjNodes.put(n, new ArrayList<Node>());
		}
		
	}
	
	
	public void addAdjNode(Node n1, Node n2) {
		
		for (Node help:this.adjNodes.keySet()) {
			if(n1.equals(help)) {
				this.adjNodes.get(n1).add(n2);
				this.adjNodes.get(n1).add(n2);
				this.adjNodes.get(n1).add(n2);
			}
		}
//		
		
		boolean flag=false;
		
		if( this.adjNodes.get(n1).isEmpty()){
			this.adjNodes.put(n1,new ArrayList<Node>());
		}
		for (Node list:this.adjNodes.get(n1)) {
			if(list.equals(n2)) {
				flag=true;
				
			}
		}
		
		if(flag==false) {
			this.adjNodes.get(n1).add(n2) ;
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

	
	
	
}
