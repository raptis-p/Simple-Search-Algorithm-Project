package searchAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class IDAstar {

	private double minCost;
	private int count,block;
	private ArrayList<Edge> optimalPath;
	
	public IDAstar(Graph g) {
		count=0;
		optimalPath = new ArrayList<Edge> ();
		block = g.getNodesList().size();
		minCost = Double.MAX_VALUE;
		
		g.calculateHeuristic();
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(comparator);
		Node srcNode = g.getSrcNode(), current;
		Node goal = g.getDestNode();
		
		queue.add(srcNode);
		//System.out.println("Added to queue : " + srcNode.getName());
		g.resetVisitsAndPath();
		while (!queue.isEmpty()) {
			
			current = queue.remove();
			current.addPath(current);
			//System.out.println("Getting from queue: " + current.getName() + "isVisited: " + current.isVisited());
			//IF we find goal
			if (current.getName().equals(goal.getName())) {
				count++;
				if(current.getCost()>=minCost)
				{
					continue;
				}
				
				minCost=current.getCost();
				System.out.println("GOAL");
				System.out.println(current.getCost());
				break;
				
			
				
			}
			
			if (!current.isVisited()) {
				//System.out.println(current.getName() + " just visited");
				current.setVisited(true);
				for (Node n : g.getNodesList()) {
					if (n.getName().equals(current.getName())) {
						for (Node n1 : n.getNeighbors()) {
							//System.out.println(n1.getName() + "  " + n1.getCost());
							
							for(Node help:g.getNodesList())
							{
								if(help.getName().equals(n1.getName()))
								{
									n1=help;
								}
							}
							for(Node hel:current.getPathFromSrc()) {
								
								n1.addPath(hel);
							}
							queue.add(n1);
						}
						
					}
				}
			}
			
		}
		
		
	}
	
	
	 class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			double heuristic1 = o1.getHeuristic();
			double heuristic2 = o2.getHeuristic();
			
			if (o1.getCost()+o1.getHeuristic() < o2.getCost() + o2.getHeuristic()) return -1;
			if (o1.getCost()+o1.getHeuristic() > o2.getCost() + o2.getHeuristic()) return -1;
			return 0;
			
			
		}
		 
	 }
	
}
