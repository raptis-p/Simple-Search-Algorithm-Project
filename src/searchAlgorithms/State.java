package searchAlgorithms;

import java.util.ArrayList;

import graph.Edge;
import graph.Node;

public class State {

	
	private Node current;
	private ArrayList<Node> children = new ArrayList<Node>();
	private double cost;
	private ArrayList<Edge> pathFromSrc = new ArrayList<Edge>();;
	
	
	
	//Constructor
	public State(Node n, ArrayList<Node> a, double c, ArrayList<Edge> p) {
		
		this.current = n;
		this.children = a;
		this.cost = c;
		this.pathFromSrc = p;
			
	}



	
	public Node getCurrent() {
		return current;
	}



	public void setCurrent(Node current) {
		this.current = current;
	}



	public ArrayList<Node> getChildren() {
		return children;
	}



	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public ArrayList<Edge> getPathFromSrc() {
		return pathFromSrc;
	}



	public void setPathFromSrc(ArrayList<Edge> pathFromSrc) {
		this.pathFromSrc = pathFromSrc;
	}
	
	
}
