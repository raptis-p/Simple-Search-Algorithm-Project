package mainPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import fileHandler.FileHandler;
import fileHandler.GraphMaker;
import graph.ActualTraffic;
import graph.Edge;
import graph.Graph;
import graph.Node;
import graph.Prediction;
import searchAlgorithms.IDAstar;
import searchAlgorithms.DFS;



//Passing filename as argument while running program



public class MainClass {

	public static void main(String[] args) throws IOException {
		
		String content = "";
		FileHandler fHnew = new FileHandler("output.txt");
		fHnew.instansiateWriter();
		
		Graph myGraph = new Graph();
		GraphMaker gM = new GraphMaker(args[0]);  //needs fixing and testing to take args/filename from terminal run
		
		myGraph = gM.createGraph();
		myGraph.initializeNeighbors();
		
		
//		for (Node n : myGraph.getNodesList()) {
//			System.out.println(n.getName());
//			System.out.println("-------------");
//			for (Node n1 : n.getNeighbors()) {
//				System.out.println("Neighbor : " + n1.getName());
//			}
//			System.out.println("-------------");
//		}
//		
		
		//IDS ids = new IDS(myGraph);
//		Node s = myGraph.getSrcNode();
//		System.out.println(myGraph.getSrcNode().getName());
//		System.out.println(s.getNeighbors().size());
//		
		//maybe remove some streets with same src-dest and 
		//big difference in weight values
		
		int c=0,c1=0,cfinal=0;
		
		for (int day=0;day<80;day++) {
			
			myGraph.resetCosts_Path();
			
			
//			System.out.println("--------- fdjfdffd    fdsfdsfd   alaksaaaaaaaaa----------------");
//			System.out.println("Day : "+day);
			//predict traffic
			//myGraph.changePred(day);
			myGraph.predictTrafficInDay(day);
			
			
//			for (Edge e :myGraph.getEdgesList()) {
//				System.out.println(e.toStringPred());
//			}
			//maybe remove some streets
			//based on predictions
			
			
//			System.out.println("-------------------DFS(Night)---------------------");
			DFS dfs = new DFS(myGraph);
//			for (Node n: myGraph.getDestNode().getPathFromSrc()) {
//				System.out.println(n.getName() + "      " + n.getCost()
//				);
//				
//			}
			
//			System.out.println("Minimum Cost to Goal is : " + ids.getMinReturn());
//			System.out.println("Nodes visited : " + ids.getNodesVisited() + " out of " +myGraph.getNodesList().size());
//			System.out.println("--------------------------------------------------");
			//myGraph.resetCosts_Path();
//
			myGraph.calculateHeuristic();
			
			
//			for (Node n : myGraph.getNodesList()) {
//				System.out.println(n.getName() + "       " + n.getHeuristic());
//			}
//			//execute IDS
			
			
			//set actual traffic values
			myGraph.setActual_updatePreds(day);
		
			
			
			
			
//			System.out.println("----------------");
//			System.out.println("Success rate");
			for(Edge e:myGraph.getEdgesList())
			{	
				if(e.getPredictedWeight()==e.getRealWeight())
				{
					if(day==0)
					{
						c1++;
					}
					else if(day==79)
					{
						cfinal++;
					}
					c++;
				}
			}
			double ratio=c;
//			System.out.println(ratio/myGraph.getEdgesList().size());
			c=0;
			
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
			//execute IDA*
			//reset visited but not costs
//			System.out.println("-------------------A*(Night)----------------------");
			IDAstar ida = new IDAstar(myGraph);
//			System.out.println("Minimum Cost to Goal is : " + ida.getMinCost());
//			System.out.println("Nodes visited(total): " + ida.getNodesVisited1());
//			System.out.println("Nodes visited(last iteration): " + ida.getNodesVisited2());
//			for (Node n : myGraph.getDestNode().getPathFromSrc())
//			System.out.println(n.getName() + "     " +n.getCost());
			//use path with actual traffic
//			System.out.println("---------------------------------------------------");
		
			//print Visited Nodes Number, (exec time)
			//sequence of edges(with their weights), total predicted cost
			//and total real cost
//			System.out.println("------------------DFS(Morning)-------------------");
			//execute path with actual traffic
//			int sum1=0,sum2=0;
//			int i = 0;
//			Node n5 = myGraph.getDestNode().getPathFromSrc().get(i);
//			for (Node n1 : myGraph.getDestNode().getPathFromSrc()) {
//				i++;
//				if (n1.getName().equals(myGraph.getDestNode().getPathFromSrc().get(0).getName())) continue;
//				//System.out.println(n1.getName());
//				//For node n -> next node -> findWeight but with real instead of predicted values
//				sum2+=myGraph.findWeight(n5,n1);
//				sum1 += myGraph.findRealWeight(n5,n1);
//				if (i>= myGraph.getDestNode().getPathFromSrc().size()) break;
//				n5 = myGraph.getDestNode().getPathFromSrc().get(i);
//				
//				if (n1.getName().equals(myGraph.getDestNode().getName())) break;
//			}
//			System.out.println("Predicted Cost of Path: " +sum2) ;
//			System.out.println("Real Cost of Path: " + sum1);
//			System.out.println("---------------------------------------------------");
//			
//			
//			System.out.println("------------------A*(Morning)-------------------");
//			
//			System.out.println("Predicted Cost of Path: " +sum2) ;
//			System.out.println("Real Cost of Path: " + sum1);
//			
//			System.out.println("---------------------------------------------------");
			//update p1,p2,p3
			
			
			//go to next day
			content+= "==================================================\n";
			content+= "Day"+(day+1)+"\n";
			content+= "<Depth First Search Algorithm>: \n";
			content+= "\tVisited Nodes Number : " +  + dfs.getNodesVisited() + " out of " +myGraph.getNodesList().size() + "\n";
			content+= "\tPath(with error -- see report --) " + pathToString(myGraph.getDestNode().getPathFromSrc(),myGraph) + "\n";
			content+= "\tPredicted Cost : " + dfs.getMinReturn() + "\n";
			content+= "\tReal Cost : " + dfs.getMinReturnReal() + "\n";
			content+= "IDA*: \n";
			content+= "\tVisited Nodes Number(total) : " +  + ida.getNodesVisited1()+  "\n";
			content+= "\tVisited Nodes Number(last iteration) : " +  + ida.getNodesVisited2()+  "\n";
			content+= "\tPath(with error -- see report --) " + pathToString(myGraph.getDestNode().getPathFromSrc(),myGraph) + "\n";
			content+= "\tPredicted Cost : " + ida.getMinCost() + "\n";
			content+= "\tReal Cost : " + dfs.getMinReturnReal() + "\n";
			System.out.println(content);
			
			
			
			
			
		}
		BufferedWriter wrBuff = fHnew.getBuffWriter();
		
		wrBuff.write(content);
		
		
		double ratio2=c1;
		//System.out.println(ratio2/myGraph.getEdgesList().size());
		
		
		double ratio3=cfinal;
		double res=ratio3/myGraph.getEdgesList().size()-ratio2/myGraph.getEdgesList().size();
//		System.out.println("Namaste:"+res);
		wrBuff.close();
	}
	
	
	
	public static String pathToString(ArrayList<Node> path,Graph g) {
		String s = "";
		for (Node n : path) {
			s+= " " + n.getName()+"(" + n.getCost() +")" + "->";
		}
		s = s + g.getDestNode().getName() + "(" + g.getDestNode().getCost() + ")";
		return s;
	}
}

