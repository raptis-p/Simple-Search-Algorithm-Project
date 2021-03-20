package searchAlgorithms;

import java.util.ArrayList;

import graph.Graph;
import graph.Node;

public class IDS {

	private int limit;
	
	
	//Constructor
	
	public IDS(Graph g) {
		
		
		limit = 0;
		int depth = 0;
		Node current = g.getSrcNode();
		while(depth<=limit) {
//			int cost = 0;
			State curState = new State (current, (ArrayList<Node>) g.getAdjNodes().get(current), 0, null);
	//		for (int i=0; i<srcState.getChildren().size();i++) {
	//			System.out.println(srcState.getCurrent().getName() + srcState.getChildren().get(i).getName());
	//		}
		
		}
	}
	
	
//	public IDS(Graph g,int maxLim) {
//		
//	}
//	
	
	
	
	
	
	
	
	
}
