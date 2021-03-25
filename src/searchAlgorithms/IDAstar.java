package searchAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class IDAstar {

	private double minCost,threshold;
	private int count,block,nodesVisited1,nodesVisited2;



	private ArrayList<Edge> optimalPath;
	
	public IDAstar(Graph g) {
		count=0;
		nodesVisited1= 0;
		nodesVisited2= 0;
//		optimalPath = new ArrayList<Edge> ();
		block = g.getNodesList().size();
		minCost = Double.MAX_VALUE;
		g.calculateHeuristic();
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(comparator);
		Node srcNode = g.getSrcNode(), current;
		Node goal = g.getDestNode();
		threshold = srcNode.getHeuristic() + srcNode.getCost();
		
		queue.add(srcNode);
		//System.out.println("Added to queue : " + srcNode.getName());
		g.resetVisitsAndPath();
		while (!queue.isEmpty()) {
			
			current = queue.remove();
//			System.out.println(current.getName());
			if (current.getHeuristic() + current.getCost() > threshold) {
//				System.out.println("fjwe8ifje");
				threshold = current.getHeuristic() + current.getCost();
				queue.clear();
				queue.add(srcNode);
				g.resetVisitsAndPath();
				nodesVisited2 = 0;
				continue;
			}
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
//				System.out.println("GOAL");
//				System.out.println(current.getCost());
				break;
				
			
				
			}
			
			if (!current.isVisited()) {
				//System.out.println(current.getName() + " just visited");
				current.setVisited(true);
				nodesVisited1++;
				nodesVisited2++;
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
			if (o1.getCost()+o1.getHeuristic() > o2.getCost() + o2.getHeuristic()) return 1;
			return 0;
			
			
		}
		 
	 }


	public double getMinCost() {
		return minCost;
	}


	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}


	public int getNodesVisited1() {
		return nodesVisited1;
	}


	public void setNodesVisited1(int nodesVisited) {
		this.nodesVisited1 = nodesVisited;
	}
	
	public int getNodesVisited2() {
		return nodesVisited2;
	}


	public void setNodesVisited2(int nodesVisited2) {
		this.nodesVisited2 = nodesVisited2;
	}
	
}
