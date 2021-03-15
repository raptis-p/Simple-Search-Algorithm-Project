package graph;

public class Node {

	private String name;
	
	//Constructor
	public Node(String name) {
		this.name = name;
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

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
