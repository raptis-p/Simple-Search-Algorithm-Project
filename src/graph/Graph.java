 package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import graph.Edge;

public class Graph {

	
	private List<Edge> edgesList;
	private List<Node> nodesList;

	
	
	
	
	
	private Node srcNode =new Node();
	private Node destNode =new Node();

	private Map<Integer,List<Prediction>> predictions = new HashMap<Integer,List<Prediction>>(); ;//day at index, list of predictions in list
	private Map<Integer,List<ActualTraffic>> actualTraffic = new HashMap<Integer,List<ActualTraffic>>(); //either map or class ActualTraffic !!!!!!!!!

	//Constructor
	public Graph() {
		setEdgesList(new ArrayList<Edge>());
		setNodesList(new ArrayList<Node>());
	}
	
	public void addNode(Node n) {
		boolean flag =true;
		for (int i=0; i<this.nodesList.size();i++) {
			if (this.nodesList.get(i).getName().equals(n.getName())) {
				flag = false;
			}
		}
		if (flag) {
			this.nodesList.add(n);
		}
		
	}
	public void addEdge(Edge e) {
		if (!edgesList.contains(e)) {
			edgesList.add(e);
		}
	}
	
	
	public void initializeNeighbors() {
		for (Edge e : this.edgesList) {
			Node n1 = e.getDestNode();
			Node n2 = e.getSrcNode();
			boolean flag = false;
			for (Node n : this.nodesList) {
				if (n.getName().equals(n1.getName())) {
					n.addNeighbor(n2);
					n2.addNeighbor(n);
					flag = true;
					
				}
				if (n.getName().equals(n2.getName())) {
					n.addNeighbor(n1);
					n1.addNeighbor(n);
					flag = true;
					
				} 
			}
		if (!flag) {
			n1.addNeighbor(n2);
			n2.addNeighbor(n1);
		}
		}
	}
	
	
	public void predictTrafficInDay(int day) {
		for (Edge e : this.edgesList) {
			Prediction p = findPredByNameAndDay(e.getRoadName(), day);
			if (p.getTraffic() == -1) {
				//low traffic
				e.setPredictedWeight(e.getWeight()-0.1*e.getWeight());
			} else if (p.getTraffic() == 0) {
				//normal traffic
				e.setPredictedWeight(e.getWeight());
			} else {
				//heavy traffic
				e.setPredictedWeight(e.getWeight()+0.25*e.getWeight());
			}
		}
	}
	
	
	public ActualTraffic findTrafficByNameAndDay(String name,int day) {
		for (ActualTraffic a : this.actualTraffic.get(day)) {
			if (a.getRoadName().equals(name)) {
				return a;
			}
		}
		return null; //if it didnt find it
	}
	
	public void setActualTrafficInDay(int day) {
		for (Edge e : this.edgesList) {
			ActualTraffic p = findTrafficByNameAndDay(e.getRoadName(), day);
			if (p.getTraffic() == -1) {
				//low traffic
				e.setRealWeight(e.getWeight()-0.1*e.getWeight());
			} else if (p.getTraffic() == 0) {
				//normal traffic
				e.setRealWeight(e.getWeight());
			} else {
				//heavy traffic
				e.setRealWeight(e.getWeight()+0.25*e.getWeight());
			}
		}
	}
	

	
	public Prediction findPredByNameAndDay(String name,int day) {
		for (Prediction p : this.predictions.get(day)) {
			if (p.getRoadName().equals(name)) {
				return p;
			}
		}
		return null; //if it didnt find it
	}
		

	
	public double findWeight(Node n1, Node n2)  ////////////////// FINDDDD MIIIIINNNNN
	{
		double min=999999999;
		for(Edge e:this.edgesList)
		{
			if(e.containsNode(n1) && e.containsNode(n2))
			{
				if(e.getPredictedWeight()<min)
				{
					min=e.getPredictedWeight();
				}
			}
		}
		return min;
		
	}
	
	
	
	public double findRealWeight(Node n1, Node n2) {

		double min=999999999;
		for(Edge e:this.edgesList)
		{
			if(e.containsNode(n1) && e.containsNode(n2))
			{
				if(e.getRealWeight()<min)
				{
					min=e.getRealWeight();
				}
			}
		}
		return min;
		
	}
	
	public void calculateHeuristic() {
		
		Stack<Node> stack = new Stack<Node>();
		Node current;
		
		stack.push(this.destNode);
		
		while (!stack.isEmpty()) {
			
			current = stack.pop();
			
			if (!current.isVisited()) {
				current.setVisited(true);
				
				//System.out.println("-----------------");
				for (Node n : this.getNodesList()) {
					if (n.getName().equals(current.getName())) {
						for (Node n1 : n.getNeighbors()) {
							//System.out.println(n1.getName());
							for(Node help:this.getNodesList())
							{
								if(help.getName().equals(n1.getName()))
								{
									n1=help;
								}
							}
							if (!n1.isVisited()) {
								n1.setHeuristic(n1.getHeuristic() + 20);
							}
							stack.push(n1);	
						}
					}
				}
			}
		}
		//this.resetCosts_Path();
	}
	
	
	public void resetVisitsAndPath() {
		for (Node n : this.nodesList) {
			n.setVisited(false);
			n.getPathFromSrc().clear();
		}
	}
	
	
	public void resetCosts_Path()
	{
		for (Node n:this.nodesList)
		{
			n.resetNodePathAndCost();
			for(Node n1:n.getNeighbors())
			{
				n1.setCost(0);
				n1.setVisited(false);
			}
		}
	}
	
	public void resetCosts()
	{
		for (Node n:this.nodesList)
		{
			
			n.setCost(0);
			n.setVisited(false);
			for(Node n1:n.getNeighbors())
			{
				n1.setCost(0);
				n1.setVisited(false);
			}
		}
	}
	
	

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



	public Node getSrcNode() {
		return srcNode;
	}



	public void setSrcNode(Node srcNode) {
		this.srcNode = srcNode;
	}



	public Node getDestNode() {
		return destNode;
	}



	public void setDestNode(Node destNode) {
		this.destNode = destNode;
	}



	public List<Node> getNodesList() {
		return nodesList;
	}



	public void setNodesList(List<Node> nodesList) {
		this.nodesList = nodesList;
	}


	
	
}
