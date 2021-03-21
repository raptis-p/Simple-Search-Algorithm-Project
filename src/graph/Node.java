package graph;

import java.util.ArrayList;



public class Node {

	private String name;
	private boolean isSrc;
	private boolean isGoal;
	private boolean isVisited;
	
	
	private ArrayList<Edge> pathFromSrc;
	private double costFromSrc;
	
	
	//Constructors
	public Node() {
		this.pathFromSrc = new ArrayList<Edge>();
		this.costFromSrc = 0;
	}
	
	
	public Node(String name,Graph g) {
		this.name = name;
		this.isSrc = false;
		this.costFromSrc = 0;
		this.isGoal = false;
		this.pathFromSrc = new ArrayList<Edge>();
	}
	
	public Node(String name,boolean src, boolean goal,Graph g) {
		this.name =" "+name;
		this.costFromSrc = 0;
		this.isSrc = src;
		this.isGoal = goal;
		this.pathFromSrc = new ArrayList<Edge>();
	}
	
	
	public boolean equals(Node n) {
	
		if (this.name.equals(n.name)) {
			return true;
		}
		return false;
	}


	
	//Getters-Setters
	public String getName() {
		return name;
	}

	public boolean isSrc() {
		return isSrc;
	}

	public void setSrc(boolean isSrc) {
		this.isSrc = isSrc;
	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

	public void setName(String name) {
		this.name = name;
	}


	public boolean isVisited() {
		return isVisited;
	}


	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public ArrayList<Edge> getPathFromSrc() {
		return pathFromSrc;
	}


	public void setPathFromSrc(ArrayList<Edge> pathFromSrc) {
		this.pathFromSrc = pathFromSrc;
	}


	public double getCostFromSrc() {
		return costFromSrc;
	}


	public void setCostFromSrc(double costFromSrc) {
		this.costFromSrc = costFromSrc;
	}
	
	
	
	
}
