package graph;

import java.util.ArrayList;

import fileHandler.GraphMaker;

public class Node {

	private String name;
	private boolean isSrc;
	private boolean isGoal;
	private boolean isVisited;
	
	private ArrayList<Node> neighbors;
	private ArrayList<Node> pathFromSrc;
	private double cost;
	private double realCost;
	
	
	
	
	
	
	
	
	public double getRealCost() {
		return realCost;
	}


	public void setRealCost(double realCost) {
		this.realCost = realCost;
	}


	private double heuristic;
	
	//Constructors
	public Node() {
		this.isVisited = false;
		neighbors = new ArrayList<Node>();
		pathFromSrc = new ArrayList<Node>();
		this.heuristic = 0;
	}
	
	
	public Node(String name,Graph g) {
		this.name = name;
		this.isSrc = false;
		this.isGoal = false;
		neighbors = new ArrayList<Node>();
		this.isVisited = false;
		pathFromSrc = new ArrayList<Node>();
		this.heuristic = 0;
	}
	
	public Node(String name,boolean src, boolean goal,Graph g) {
		this.name =" "+name;
		this.isSrc = src;
		this.isGoal = goal;
		this.isVisited = false;
		neighbors = new ArrayList<Node>();
		pathFromSrc = new ArrayList<Node>();
		this.heuristic = 0;
	}
	
//	public void setNode(Node n) {
//		this.name = n.name;
//		this.isSrc = n.isSrc;
//		this.isGoal = n.isGoal;
//		neighbors = n.neighbors;
//		this.isVisited = n.isVisited;
//		pathFromSrc = n.pathFromSrc;
//		this.cost = n.cost;
//	}
	
	
	public void addPath(Node cur)
	{
		if(!this.pathFromSrc.contains(cur))
			this.pathFromSrc.add(cur);
	}
	
	
	
	public void addNeighbor(Node n) {
		boolean flag =true;
		for (int i=0; i<this.neighbors.size();i++) {
			if (this.neighbors.get(i).getName().equals(n.getName())) {
				flag = false;
			}
		}
		if (flag) {
			this.neighbors.add(n);
			
		}
	}
	
	public boolean equals(Node n) {
	
		if (this.name.equals(n.name)) {
			return true;
		}
		return false;
	}


	
	public void resetNodePathAndCost() {
		this.pathFromSrc.clear();
		this.cost = 0;
		this.realCost = 0;
		this.isVisited=false;
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


	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}


	public void setNeighbors(ArrayList<Node> neighbors) {
		this.neighbors = neighbors;
	}


	public ArrayList<Node> getPathFromSrc() {
		return pathFromSrc;
	}


	public void setPathFromSrc(ArrayList<Node> pathFromSrc) {
		this.pathFromSrc = pathFromSrc;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public double getHeuristic() {
		return heuristic;
	}


	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}
	
	

	
	
}
