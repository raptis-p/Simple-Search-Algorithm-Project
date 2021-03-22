package graph;

public class Edge {

	
	private String roadName;
	private Node srcNode;
	private Node destNode;
	private double weight;
	
	
	private double predictedWeight;
	private double realWeight;
	
	//Constructor
	public Edge(String rN, Node s, Node d, double w)
	{
		this.destNode = d;
		this.roadName = rN;
		this.srcNode = s;
		this.weight = w;
	}


	public String toString() {
		return "Starting Node: "+this.srcNode.getName()+" with destination Node: "+this.destNode.getName()+" are connected with road: "+this.roadName+" and its weight is: "+this.weight;
	}
	
	public String toStringPred() {
		return "Starting Node: "+this.srcNode.getName()+" with destination Node: "+this.destNode.getName()+" are connected with road: "+this.roadName+" and its weight is: "+this.weight + " and predicted weight is: "+ this.predictedWeight;
	}
	
	//ContainsNode method
	public boolean containsNode(Node n) {
		if (this.destNode.getName().equals(n.getName()) || this.srcNode.getName().equals(n.getName())) {
			return true;
		} else {
			return false;
		}
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


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getPredictedWeight() {
		return predictedWeight;
	}


	public void setPredictedWeight(double predictedWeight) {
		this.predictedWeight = predictedWeight;
	}


	public double getRealWeight() {
		return realWeight;
	}


	public void setRealWeight(double realWeight) {
		this.realWeight = realWeight;
	}
	
	
	
	
	
}
