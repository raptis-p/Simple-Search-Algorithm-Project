package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if (!adjNodes.containsKey(n))
			adjNodes.putIfAbsent( n, new ArrayList<>());
	}
	
	public void addAdjNode(Node n1, Node n2) {
		if (this.adjNodes.get(n1).isEmpty()) {
			this.adjNodes.put(n1, new ArrayList<Node>());
		}
		this.adjNodes.get(n1).add(n2);
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
