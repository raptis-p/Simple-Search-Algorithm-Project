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
	private double minReturn;
	private int nodesVisited;
//	private ArrayList<Edge> optimalPath;
	
	
	public IDS(Graph g) {
		nodesVisited =0;
		
		
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
		g.getEdgesList();
		double minCost1=Double.MAX_VALUE;
		int count =0;
		
		Node nT= new Node();
		while (!stack.isEmpty()) {
			
			current = stack.pop();
			current.addPath(current);
			
		
			
		
			
			//System.out.println(current.getPathFromSrc());
			//System.out.println(current.getCost());
			//System.out.println("Current is : " + current.getName());	
			if (current.getName().equals(goal.getName())) {
				if(current.getCost()>=minCost1)
				{
					continue;
				}
				else {
				minReturn=current.getCost();
//				System.out.println("GOAL");
//				System.out.println(current.getCost());
				for(Node node:current.getPathFromSrc())
//				{
//					//System.out.println(node.getName());
//				}
				count++;
				continue;
				}
				
			
			}
			if (!current.isVisited()) {
				current.setVisited(true);
				nodesVisited++;
				//System.out.println("-----------------");
				for (Node n : g.getNodesList()) {
					if (n.getName().equals(current.getName())) {
						for (Node n1 : n.getNeighbors()) {
							//System.out.println(n1.getName());
							for(Node help:g.getNodesList())
							{
								if(help.getName().equals(n1.getName()))
								{
									n1=help;
								}
							}
							
							
							if (n1.isVisited()) {
								continue;	
							}
							double tmpCost=g.findWeight(current, n1);
							if (current.getName().equals(srcNode.getName())) {
								n1.setCost(tmpCost);
							} else {
							n1.setCost(current.getCost()+tmpCost);
							}
							if(n1.getCost()>minCost1) {
								continue;
							}
							
							
							for(Node hel:current.getPathFromSrc()) {
								n1.addPath(hel);
							}
							
							stack.push(n1);	
						}
						//System.out.println("min weight for Node:"+current.getName()+" to Node:"+stack.peek().getName()+" is:"+stack.peek().getCost());
					}
				}
			}
			else // VISITED
			{
				for (Node n : g.getNodesList()) {
					if (n.getName().equals(current.getName())) {
						for (Node n1 : n.getNeighbors()) {
							for(Node help:g.getNodesList())
							{
								if(help.getName().equals(n1.getName()))
								{
									n1=help;
								}
							}
							double tmpCost=g.findWeight(current, n1);
							//
							if(current.getCost()+tmpCost< n1.getCost())
							{
								n1.setCost(current.getCost()+tmpCost);
								//System.out.println("now cost is: "+n1.getCost());
//								if (!n1.isVisited())
//								nodesVisited++;
								stack.push(n1);
							}
						}
					}
				}
				
			}
			
				
		}
		
		
	}


	public double getMinReturn() {
		return minReturn;
	}


	public void setMinReturn(double minReturn) {
		this.minReturn = minReturn;
	}


	public int getNodesVisited() {
		return nodesVisited;
	}


	public void setNodesVisited(int nodesVisited) {
		this.nodesVisited = nodesVisited;
	}
}

