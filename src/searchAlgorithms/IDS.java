package searchAlgorithms;

import java.util.ArrayList;
import java.util.Stack;

import graph.Edge;
import graph.Graph;
import graph.Node;

@SuppressWarnings("unused")
public class IDS {

	
	
	
	private int limit;
	private Stack<Node> stack;
//	private ArrayList<Edge> optimalPath;
	
	
	public IDS(Graph g) {
		
		
		int minCost = Integer.MAX_VALUE;
		
		int depth = 0;
		stack = new Stack<>();
		
		Node srcNode = g.getSrcNode(), current;
		Node goal = g.getDestNode();
//		ArrayList<Edge> path = new ArrayList<>();
		
		
		stack.push(srcNode);
//		Node nT = new Node();
//		for (Node n : g.getNodesList()) {
//			if (n.getName().equals(" 11Node10e")) {
//				nT = n;
//			}
//		}
//		for (Node n1 : nT.getNeighbors()) {
//			System.out.println(n1.getName());
//		}
//		
//		
		Node nT= new Node();
		while (!stack.isEmpty()) {
			
			current = stack.pop();
			System.out.println("Current is : " + current.getName());
			if (current.getName().equals(goal.getName())) {
				System.out.println("GOAL");
			}
			
			if (!current.isVisited()) {
				current.setVisited(true);
				System.out.println("-----------------");
				for (Node n : g.getNodesList()) {
					if (n.getName().equals(current.getName())) {
						for (Node n1 : n.getNeighbors()) {
							if (n1.isVisited()) {
								continue;
							}
								System.out.println(n1.getName());
								stack.push(n1);
						}
					}
				}
			
			
			
			}
		
				
				
		}
		
		
	}
}

