package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import graph.Edge;

public class Graph {

	
	private Map<Node, List <Node>> adjNodes;
	private List<Edge> edgesList;
	
	
	private Node srcNode =new Node();
	private Node destNode =new Node();

	private Map<Integer,List<Prediction>> predictions = new HashMap<Integer,List<Prediction>>(); ;//day at index, list of predictions in list
	private Map<Integer,List<ActualTraffic>> actualTraffic = new HashMap<Integer,List<ActualTraffic>>(); //either map or class ActualTraffic !!!!!!!!!

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
			if (n.isSrc())
			{
				this.srcNode = n;
			}
			if (n.isGoal())
			{
				this.destNode = n;
			}
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
		
	
	
	public Edge findEdgeByNodes(Node n1, Node n2) {
		for (Edge e : this.getEdgesList()) {
			if (e.containsNode(n1) && e.containsNode(n2)) {
				return e;
			}
			
		}
		return null;
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


	
	
}
