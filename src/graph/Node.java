package graph;

import java.util.ArrayList;

import fileHandler.GraphMaker;

public class Node {

	private String name;
	private boolean isSrc;
	private boolean isGoal;
	
	
	//Constructors
	public Node(String name,Graph g) {
		this.name = name;
		this.isSrc = false;
		this.isGoal = false;
		g.getAdjNodes().put(this, new ArrayList<Node>());
	}
	
	public Node(String name,boolean src, boolean goal,Graph g) {
		this.name =" "+name;
		this.isSrc = src;
		this.isGoal = goal;
		g.getAdjNodes().put(this, new ArrayList<Node>());
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
	
	
	
}
