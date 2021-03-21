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
	
	
	//Constructor
	
	public IDS(Graph g) {
		
		int minCost = Integer.MAX_VALUE;
		
		int depth = 0;
		stack = new Stack<>();
		
		Node srcNode = g.getSrcNode();
		Node goal = g.getDestNode();
		srcNode.setCostFromSrc(0);
		
		//System.out.println(goal.isGoal());
		
//		ArrayList<Edge> path = new ArrayList<>();
		
		Node current = srcNode;
		stack.push(current);
//		System.out.println(g.getAdjNodes().get(current));
//		for (int i=depth; i<=limit; i++) {
			
			
			
			
				
			
			
			
			
			
			
			
			
//		}
		
		
	}

	
	
	
	
	
	
	
	
}
