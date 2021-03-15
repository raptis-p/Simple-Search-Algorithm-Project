package graph;

public class Edge {

	
	private String roadName;
	private Node srcNode;
	private Node destNode;
	private String weight;
	
	
	//Constructor
	public Edge(String rN, Node s, Node d, String w)
	{
		this.destNode = d;
		this.roadName = rN;
		this.srcNode = s;
		this.weight = w;
	}


	public String toString() {
		return "Starting Node: "+this.srcNode.getName()+" with destination Node: "+this.destNode.getName()+" are connected with road: "+this.roadName+" and its weight is: "+this.weight;
	}
	
	
	
	
	
	
	
	
	//Getters-Setters
	public String getRoadName() {
		return roadName;
	}


	public void setRoadName(String roadName) {
		this.roadName = roadName;
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


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
	
	
	
}
